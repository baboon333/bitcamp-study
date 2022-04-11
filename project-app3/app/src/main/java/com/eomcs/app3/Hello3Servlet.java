package com.eomcs.app3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 컨테이너가 실행할 클래스를 만드려면
@SuppressWarnings("serial")
@WebServlet("/hello3") // 서블릿 컨테이너에게 이 클래스가 /hello 요청을 처리하는 서블릿임을 알려준다. // 이 클래스를 실행하려면 hello라고 요청해야 한다. hello 라고 요청하면 이 클래스의 service()를 서블릿 컨테이너가 실행할 것이다.
public class Hello3Servlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("service() 호출!");

    // HTTP 클라이언트(웹브라우저)가 name이라는 이름으로 보내 온 파라미터 값을 읽는다.
    String name = req.getParameter("name"); // request에 대해서 name이라는 이름으로 파라미터 값이 넘어오면 받는다.

    // HTTP 클라이언트에게 보낼 콘텐트의 MIME 타입을 설정한다.
    resp.setContentType("text/plain;charset=UTF-8"); // response에 대해서 순수 텍스트로 출력할건데 클라이언트에서 보낼 때는 utf-8로 바꿔서 보내라

    // HTTP 클라이언트에게 콘텐트를 출력할 도구를 준비한다.
    PrintWriter out = resp.getWriter(); // 출력스트림을 얻는다

    // HTTP 클라이언트에게 콘텐트를 출력한다.
    out.printf("%s 님 환영합니다!", name);
  }
}
