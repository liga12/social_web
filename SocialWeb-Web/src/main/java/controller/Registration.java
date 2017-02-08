package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserServiceImpl;

@WebServlet("/registraion")
public class Registration extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");
    String firstname = req.getParameter("firstname");
    String lastname = req.getParameter("lastname");
    String email = req.getParameter("email");
    String login = req.getParameter("login");
    String password = req.getParameter("password");

    new UserServiceImpl().registration(firstname, lastname, email, login, password);
    req.setAttribute("error","Регистрация прошла успешно");
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
    dispatcher.forward(req, resp);
  }

  private void printPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
    dispatcher.forward(req, resp);
  }
}
