package controller.servlet;

import controller.Authorization;
import controller.Page;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.User;
import service.UserServiceImpl;

@WebServlet("/soc")
public class Login extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    String login = req.getParameter("login");
    String password = req.getParameter("password");
    Page page = new Page();



    User user = new Authorization().getUserAuthorization(login, password);
    if (user != null) {
      Integer id = user.getId();
      String firstname = user.getFirstname();
      String lasttname = user.getLastname();
      String name = new String(firstname +" "+lasttname);
      req.setAttribute("name", name);
      HttpSession session = req.getSession(true);
      session.setAttribute("user", user);
      Cookie cookie = new Cookie("idSession", session.getId());
      resp.addCookie(cookie);
      page.setSession(req, resp, id);

    } else {
      req.setAttribute("data", "Неверный логин или пароль");
      printPage(req, resp);
    }

  }

  private void printPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
    dispatcher.forward(req, resp);
  }
}
