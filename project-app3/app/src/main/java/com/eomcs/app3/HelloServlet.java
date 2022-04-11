package com.eomcs.app3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 서블릿 컨테이너가 실행할 클래스를 만드려면
// Servlet API 규칙에 따라 작성해야 한다.
@WebServlet("/hello") // 이 클래스를 실행하려면 hello라고 요청해야 한다. hello 라고 요청하면 이 클래스의 service()를 서블릿 컨테이너가 실행할 것이다.
public class HelloServlet implements Servlet {

  @Override
  public void init(ServletConfig config) throws ServletException {

  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    // HTTP 클라이언트(웹브라우저)가 name이라는 이름으로 보내 온 파라미터 값을 읽는다.
    String name = req.getParameter("name"); // request에 대해서 name이라는 이름으로 파라미터 값이 넘어오면 받는다.

    // HTTP 클라이언트에게 보낼 콘텐트의 MIME 타입을 설정한다.
    res.setContentType("text/plain;charset=UTF-8"); // response에 대해서 순수 텍스트로 출력할건데 클라이언트에서 보낼 때는 utf-8로 바꿔서 보내라

    // HTTP 클라이언트에게 콘텐트를 출력할 도구를 준비한다.
    PrintWriter out = res.getWriter(); // 출력스트림을 얻는다

    // HTTP 클라이언트에게 콘텐트를 출력한다.
    out.printf("%s 님 환영합니다!", name);
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {

  }

}
