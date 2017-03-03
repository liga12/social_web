package controller.servlet;

import controller.Encrupt;
import controller.Mailer;
import controller.Page;
import controller.RegistrationUser;
import model.dao.entityDao.URLDaoImpl;
import model.entity.URLMassage;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
                (firstname, lastname, email, login, password, passwordTwo, req);
        if (registration.size() == 0) {
            req.setAttribute("data", "Успешно");
            String[] emailc = email.split("@");
            String emailClient = emailc[1];
            req.setAttribute("host", "https://" + emailClient);
            new Page().createPage(req, resp, "WEB-INF/onEmail.jsp");

        } else {
            for (String s : registration) {
                data += "  " + s;

            }
            req.setAttribute("data", data);
            new Page().createPage(req, resp, "/WEB-INF/registration.jsp");
            data = null;
        }
    }


}
