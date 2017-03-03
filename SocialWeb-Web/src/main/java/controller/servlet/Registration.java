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

  String data = "";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

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
      Mailer mailer = new Mailer();
      mailer.send(email);
      printPage(req, resp);
    } else {

      for (String s : registration) {
        if (s.equals("emailNotCorrect")) {
          data = "Не корректный email\n";
        } else {
          if (s.equals("email")) {
            data += "Email существует\n";
          }
        }
        if (s.equals("login")) {
          data += "Логин существует\n";
        }
        if (s.equals("password < 6")) {
          data += "Пароль меньше 6 символов\n";
        }
      }
      printPage(req, resp);
    }

//      for (String s : registration) {
//        if (s.equals("email")) {
//          data = "email существует";
//        } else {
//          if (s.equals("emailNotCorrect")) {
//            data = "Не корректный email";
//          } else {
//            if (s.equals("login")) {
//              data = "логин существует";
//            }
//          }
////        }
//      }
//      printPage(req, resp, data);
//    }
  }

  private void printPage(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("data", data);
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
    dispatcher.forward(req, resp);
    data = null;
  }
}
