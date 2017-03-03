package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import model.entity.User;

//@WebFilter(filterName = "NewFilter", urlPatterns = {"/*"})
public class FilterConnect implements Filter {

  private FilterConfig config = null;
  private boolean active = false;


  public FilterConnect() {
  }

  @Override
  public void init(FilterConfig config) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    HttpSession session = httpServletRequest.getSession();
    Cookie[] cookies = httpServletRequest.getCookies();
    Cookie reqCookie = null;

    System.out.println(httpServletRequest.getRequestURI());
    if (!httpServletRequest.getRequestURI().equals("/login.jsp")) {
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if (cookie.getName().equals("idSession")) {
            reqCookie = cookie;
            break;
          }
        }
        if (reqCookie != null) {
          if (reqCookie.getValue().equals(session.getId())) {
            User user = (User) session.getAttribute("user");
//        for role
            if (user.getLogin() != null) {

            }

            chain.doFilter(request, response);
          } else {
            httpServletResponse.sendRedirect("/login.jsp");
          }
        } else {
          httpServletResponse.sendRedirect("/login.jsp");
        }

      } else {
        httpServletResponse.sendRedirect("/login.jsp");
      }
    } else {
      httpServletResponse.sendRedirect("/login.jsp");
    }

//      if (cookies != null) {
//        int count = 0;
//        for (Cookie cookie : cookies) {
//          if (cookie.getName().equals("idSession")) {
//            count++;
//            break;
//          }
//
//        }
//        if (count == 0) {
//          httpServletResponse.sendRedirect("/login.jsp");
//        }
//      } else {
//        httpServletResponse.sendRedirect("/login.jsp");
//      }

//       Здесь можно вставить код для обработки

  }

  @Override
  public void destroy() {

  }
}
