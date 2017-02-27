package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Page {

  public void createPage(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException {
    resp.setContentType("text/html; charset=utf-8");
    RequestDispatcher dispatcherFirst = req.getRequestDispatcher(page);
    dispatcherFirst.include(req, resp);
  }
}
