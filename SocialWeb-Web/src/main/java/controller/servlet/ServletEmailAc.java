package controller.servlet;

import controller.Page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.entityDao.URLDaoImpl;
import model.entity.URLMassage;

@WebServlet(urlPatterns = {"/emailRegis/*"})
public class ServletEmailAc extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String url = getURL(req);

        URLDaoImpl urlDao = new URLDaoImpl();
        URLMassage urlMassage = urlDao.byArgument(url, "url");
        if (urlMassage != null) {
            urlDao.remove(urlMassage);
            req.setAttribute("data", "Вы подтвердили регистрацию."
                    + " Введите логин и пароль для входа на сайт");
            new Page().createPage(req, resp, "/start");
        } else {
            req.setAttribute("data", "Вы подтвердили регистрацию."
                    + " Введите логин и пароль для входа на сайт");
            new Page().createPage(req, resp, "/start");
        }
    }

    public static String getURL(HttpServletRequest req) {

        String scheme = req.getScheme();             // http
        String serverName = req.getServerName();     // hostname.com
        int serverPort = req.getServerPort();        // 80
        String contextPath = req.getContextPath();   // /mywebapp
        String servletPath = req.getServletPath();   // /servlet/MyServlet
        String pathInfo = req.getPathInfo();         // /a/b;c=123
        String queryString = req.getQueryString();          // d=789

        // Reconstruct original requesting URL
        StringBuilder url = new StringBuilder();
        url.append(scheme).append("://").append(serverName);

        if (serverPort != 80 && serverPort != 443) {
            url.append(":").append(serverPort);
        }

        url.append(contextPath).append(servletPath);

        if (pathInfo != null) {
            url.append(pathInfo);
        }
        if (queryString != null) {
            url.append("?").append(queryString);
        }
        return url.toString();
    }
}
