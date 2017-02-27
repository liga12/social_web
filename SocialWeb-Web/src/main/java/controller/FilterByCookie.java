package controller;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter( urlPatterns = {"/soc"})
public class FilterByCookie implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    httpServletRequest.setCharacterEncoding("utf-8");
    httpServletResponse.setCharacterEncoding("utf-8");
    HttpSession session = httpServletRequest.getSession();
    Cookie[] cookies = httpServletRequest.getCookies();
    Cookie reqCookie = null;
    System.out.println(httpServletRequest.getRequestURI());

    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("idSession")) {
          reqCookie = cookie;
          break;
        }
      }
      if (reqCookie != null) {
        if (reqCookie.getValue().equals(session.getId())) {
          chain.doFilter(request, response);

        } else {
          httpServletResponse.sendRedirect("/start");
        }
      } else {
        httpServletResponse.sendRedirect("/start");
      }

    } else {
      httpServletResponse.sendRedirect("/start");
    }
  }



  @Override
  public void destroy() {

  }
}
