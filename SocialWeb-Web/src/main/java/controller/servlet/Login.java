package controller.servlet;

import controller.Page;
import controller.UserBySession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.User;

@WebServlet("/soc")
public class Login extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");

    User user = new UserBySession(req, resp).getUser();
    if (user != null) {
      String firstname = user.getFirstname();
      String lasttname = user.getLastname();
      String name = new String(firstname + " " + lasttname);
      req.setAttribute("name", name);
      new Page().createPage(req, resp, "WEB-INF/user_wall.jsp");
    }else {
      resp.sendRedirect("/start");
//      new Page().createPage(req,resp, "/start");
    }
  }
}
