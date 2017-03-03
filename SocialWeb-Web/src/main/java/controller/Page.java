package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Page {

    public void createPage(HttpServletRequest req, HttpServletResponse resp, String page)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        RequestDispatcher dispatcherFirst = req.getRequestDispatcher(page);
        dispatcherFirst.forward(req, resp);
    }
}
