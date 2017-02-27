package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.entity.User;

public class RecipientUserBySession {

  public User getUser(HttpServletRequest request){

    Cookie[] cookies = request.getCookies();
    Cookie userCookie = null;
    HttpSession session = request.getSession();
    User user = null;
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("idSession")) {
        userCookie = cookie;
        break;
      }
    }
    if (userCookie.getValue().equals(session.getId())) {
      user = (User) session.getAttribute("user");
    }
    return user;
  }
}
