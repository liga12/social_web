package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Page {
  public void setSession(HttpServletRequest req, HttpServletResponse resp, Integer id) throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.setAttribute("id", String.valueOf(id));
    createPage(req, resp);
  }

  public void createPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=utf-8");
    String id = (String) req.getSession().getAttribute("id");
    RequestDispatcher dispatcherFirst = req.getRequestDispatcher("/user_wall.jsp");
    dispatcherFirst.include(req, resp);
  }
}
