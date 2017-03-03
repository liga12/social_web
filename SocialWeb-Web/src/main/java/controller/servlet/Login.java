package controller.servlet;

import controller.Page;
import controller.RecipientUserBySession;

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
        RecipientUserBySession userBySession = new RecipientUserBySession();
        User user = userBySession.getUser(req);
        if (user != null) {
            String firstname = user.getFirstname();
            String lasttname = user.getLastname();
            String name = new String(firstname + " " + lasttname);
            req.setAttribute("name", name);
            new Page().createPage(req, resp, "WEB-INF/user_wall.jsp");
            return;
        }
        resp.sendRedirect("/start");
    }

}


