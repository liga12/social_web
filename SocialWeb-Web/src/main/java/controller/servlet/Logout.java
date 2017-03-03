package controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String logout = req.getParameter("logout");

        if (logout != null) {
            HttpSession session = req.getSession();
            if (session != null) {
                Cookie[] cookies = req.getCookies();
                Cookie reqCookie = null;
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("idSession")) {
                            reqCookie = cookie;
                            break;
                        }

                    }
                    if (reqCookie != null) {
                        String sessionId = session.getId();
                        if (reqCookie.getValue().equals(sessionId)) {
                            session.invalidate();
                            resp.addCookie(new Cookie("idSession", null));

                        }
                    }
                }
            }
        }
        resp.sendRedirect("/start");
    }
}

