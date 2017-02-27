package controller.servlet;


import controller.Page;
import controller.RecipientUserBySession;
import controller.SaverPost;
import controller.UploadFiles;
import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.entity.User;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10, // 10MB
    maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet("/uploadFile")
public class UploadFileServlet extends HttpServlet {

  private final String UPLOAD_DIRECTORY = "/home/liga/Downloads/Uploads";

  public static final String SAVE_DIRECTORY = "s";

  public UploadFileServlet() {
    super();
  }

//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//
//    RequestDispatcher dispatcher = request.getServletContext()
//        .getRequestDispatcher("/upload.jsp");
//
//    dispatcher.forward(request, response);
//  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      String description = request.getParameter("description");
      System.out.println("Description: " + description);
      RecipientUserBySession recipientUserBySession = new RecipientUserBySession();
      User user = recipientUserBySession.getUser(request);
      String userId = String.valueOf(user.getId());
      SaverPost saverPost = new SaverPost();
      saverPost.savePost(user);

      user.getPosts();



      // Part list (multi files).
      UploadFiles uploadFiles = new UploadFiles();
      for (Part part : request.getParts()) {
        String fileName = extractFileName(part);
        if (fileName != null && fileName.length() > 0) {
          String filePath = uploadFiles.getFullSavePath(userId+"/post2") + File.separator + fileName;
          System.out.println("Write attachment to file: " + filePath);
          // Write to file
          part.write(filePath);
        }
      }
      // Upload successfully!.
      request.setAttribute("message", "Загружено");
      new Page().createPage(request, response, "/soc");
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("message", "НЕ удалось");
      new Page().createPage(request, response, "/soc");
    }
  }

  private String extractFileName(Part part) {
    // form-data; name="file"; filename="C:\file1.zip"
    // form-data; name="file"; filename="C:\Note\file2.zip"
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
      if (s.trim().startsWith("filename")) {
        // C:\file1.zip
        // C:\Note\file2.zip
        String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
        clientFileName = clientFileName.replace("\\", "/");
        int i = clientFileName.lastIndexOf('/');
        // file1.zip
        // file2.zip
        return clientFileName.substring(i + 1);
      }
    }
    return null;
  }

}