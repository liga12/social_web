package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "NewFilter", urlPatterns = {"/", "/login.jsp", "/registrationPage",
    "/registration", "/emailRegis/*", "/start", "/security"})
public class FilterLoginAndRegistration implements Filter {

  private FilterConfig config = null;
  private boolean active = false;


  public FilterLoginAndRegistration() {
  }

  @Override
  public void init(FilterConfig config) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    httpServletRequest.setCharacterEncoding("utf-8");
    httpServletResponse.setCharacterEncoding("utf-8");
    HttpSession session = httpServletRequest.getSession();
    Cookie[] cookies = httpServletRequest.getCookies();
    Cookie reqCookie = null;
    if (true) {
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if (cookie.getName().equals("idSession")) {
            reqCookie = cookie;
            break;
          }
        }
        if (reqCookie != null) {
          if (reqCookie.getValue().equals(session.getId())) {
            httpServletResponse.sendRedirect("/soc");
          } else {
            chain.doFilter(request, response);
          }
        } else {
          chain.doFilter(request, response);
        }
      } else {
        chain.doFilter(request, response);
      }
    }
  }

  @Override
  public void destroy() {

  }
}
