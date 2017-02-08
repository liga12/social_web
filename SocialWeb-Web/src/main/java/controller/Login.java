package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.User;
import service.UserServiceImpl;

@WebServlet("/social12web")
public class Login extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String login = req.getParameter("login");
    String password = req.getParameter("password");
    Page page = new Page();

    User user = new UserServiceImpl().getUserAuthorization(login, password);
    if (user != null) {
//      Integer id = user.getId();
//      String role = user.getRole().getRole();
//      String firstname = user.getUserInform().getFirstname();
//      String lasttname = user.getUserInform().getLastname();
//      String name = new String(firstname +" "+lasttname);
//      req.setAttribute("name", name);
//      System.out.println(name);
//      page.setSession(req, resp, role, id);


    } else {
      req.setAttribute("error", "Неверный логин или пароль");
      printPage(req, resp);
    }

  }

  private void printPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
    dispatcher.forward(req, resp);
  }
}
