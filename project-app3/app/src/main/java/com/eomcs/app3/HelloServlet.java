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
@WebServlet("/hello") // 서블릿 컨테이너에게 이 클래스가 /hello 요청을 처리하는 서블릿임을 알려준다. // 이 클래스를 실행하려면 hello라고 요청해야 한다. hello 라고 요청하면 이 클래스의 service()를 서블릿 컨테이너가 실행할 것이다.
public class HelloServlet implements Servlet {

  ServletConfig config;

  @Override
  public void init(ServletConfig config) throws ServletException { // init()가 호출될 때 파라미터 값으로 ServletConfig를 받는다.
    System.out.println("init() 호출!");
    this.config = config; // 파라미터로 받은 config 객체를 인스턴스 변수에 잘 담아놨다가 getServletConfig()에서 config를 달라고 하면 인스턴스 변수의 config에 담아놨던걸 리턴하면 된다.
  }

  @Override
  public ServletConfig getServletConfig() { // config 객체를 리턴하는 메서드 -> 여기서 ServletConfig를 만들어서 리턴하는게 아니라 init()가 호출될 때 서블릿 컨테이너가 파라미터로 ServletConfig 객체, 즉, 서블릿 설정 정보를 다룰 수 있는 객체를 넘겨주는데 이걸 버리지 말고 내부 인스턴스 변수에 잘 담아놨다가 누군가 getServletConfig()를 호출할 때 리턴해주라는 뜻이다. 
    System.out.println("getServletConfig() 호출!");
    return this.config;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("service() 호출!");

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
  public String getServletInfo() { // 서블릿에 대한 간단한 정보를 리턴
    System.out.println("getServletInfo() 호출!");
    return "HelloServlet";
  }

  @Override
  public void destroy() {
    System.out.println("destroy() 호출!");
  }

}
