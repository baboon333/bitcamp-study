package com.eomcs.web.session;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

  @RequestMapping("/session/test1")
  public Object test1() {
    return "test1() 실행!";
  }

  @RequestMapping("/session/test2")
  public Object test2(HttpSession session) {
    System.out.printf("test2() => %s\n", session.getId());
    return "test2() 실행!";
  }

  @RequestMapping("/session/test3")
  public Object test3(HttpSession session) {
    System.out.printf("test3() => %s\n", session.getId());
    return "test3() 실행!";
  }

  @RequestMapping("/session/test4")
  public Object test4(HttpSession session) {
    System.out.printf("test4() => %s\n", session.getId());
    session.invalidate(); // 요청한 클라이언트가 사용하는 현재 세션을 무효화시킨다.
    return "test4() 실행!";
  }

}
