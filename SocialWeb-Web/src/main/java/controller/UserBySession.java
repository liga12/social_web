package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.User;

public class UserBySession {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private String IDSESSION = "idSession";
  private User user;

  public UserBySession(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
  }

 public User getUser() {
    Cookie[] cookies = request.getCookies();
    Cookie reqCookie = null;
    HttpSession session = request.getSession();

    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals(IDSESSION)) {
          reqCookie = cookie;
          break;
        }
      }
      if (reqCookie != null) {
        if (reqCookie.getValue().equals(session.getId())) {
          user = (User) session.getAttribute("user");
        }
      }
    }
    return user;
  }
}
