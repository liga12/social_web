package controller.servlet;

import controller.Mailer;
import controller.RegistrationUser;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registraion")
public class Registration extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String data = null;

    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    String firstname = req.getParameter("firstname");
    String lastname = req.getParameter("lastname");
    String email = req.getParameter("email");
    String login = req.getParameter("login");
    String password = req.getParameter("password");

    List<String> registration = new RegistrationUser().setRegistration
        (firstname, lastname, email, login, password);
    if (registration.size() == 0) {
      data = "Успешно";
//      Mailer.send();
      printPage(req, resp, data);
    } else {
      for (String s : registration) {
        if (s.equals("email")) {
          data = "email существует";
        }
        else {
          if (s.equals("emailNotCorrect")) {
            data = "Не корректный email";
          }
          else {
            if (s.equals("login")) {
              data = "логин существует";
            }
          }
        }
      }
      printPage(req, resp, data);
    }
  }

  private void printPage(HttpServletRequest req, HttpServletResponse resp, String data)
      throws ServletException, IOException {
    req.setAttribute("data", data);
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
    dispatcher.forward(req, resp);
  }
}
