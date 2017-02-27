package controller.servlet;

import controller.Encrupt;
import controller.Mailer;
import controller.Page;
import controller.RegistrationUser;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.entityDao.URLDaoImpl;
import model.entity.URLMassage;

@WebServlet("/registration")
public class Registration extends HttpServlet {

  String data = "";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String firstname = req.getParameter("firstname");
    String lastname = req.getParameter("lastname");
    String email = req.getParameter("email");
    String login = req.getParameter("login");
    String password = req.getParameter("password");
    String passwordTwo = req.getParameter("passwordtwo");

    List<String> registration = new RegistrationUser().setRegistration

        (firstname, lastname, email, login, password, passwordTwo);
    if (registration.size() == 0) {

      req.setAttribute("data", "Успешно");

      URLMassage urlMassage = new URLMassage();
      URLDaoImpl urlDao = new URLDaoImpl();
      Encrupt encrupt = new Encrupt();

      String scheme = req.getScheme();
      String serverName = req.getServerName();
      StringBuilder url = new StringBuilder();
      url.append(scheme).append("://").append(serverName);
      url.append(":").append(req.getServerPort());
      url.append("/emailRegis/").append(encrupt.getEncryptedMd5(email));
      String urlfull  = url.toString();


//      String url = new String("http://localhost:8090/emailRegis/" + encrupt.getEncryptedMd5(email));

      urlMassage.setUrl(urlfull);
      urlDao.save(urlMassage);

      Mailer mailer = new Mailer();
      mailer.send(email, urlfull);

      String[] emailc = email.split("@");
      String emailClient = emailc[1];
      req.setAttribute("host", "https://" + emailClient);
//      new Page().createPage(req, resp, "/registration.jsp");

      new Page().createPage(req, resp, "WEB-INF/onEmail.jsp");


    } else {
      for (String s : registration) {
        data += "  " + s;

//      for (String s : registration) {
//        if (s.equals("emailNotCorrect")) {
//          data = "Не корректный email\n";
//        } else {
//          if (s.equals("email")) {
//            data += "Email существует\n";
//          }
//        }
//        if (s.equals("login")) {
//          data += "Логин существует\n";
//        }
//        if (s.equals("password < 6")) {
//          data += "Пароль меньше 6 символов\n";
//        }
//      }

      }
      req.setAttribute("data", data);
      new Page().createPage(req, resp, "/WEB-INF/registration.jsp");
    }
  }
}
