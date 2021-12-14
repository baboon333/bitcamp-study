package com.eomcs.web.javascript;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //스프링부트가 인식할 수 있도록 등록해준거임
public class Ex00Controller {

  @RequestMapping("/javascript/ex00/exam06")  //이런 요청이 오면 응답하겠다
  public String exam06() {
    return "<ul><li>홍길동</li><li>임꺽정</li><li>유관순</li></ul>" ; //UI 조각을 만들어 던진다!  -> 이게 바로 서버렌더링 방식이다! //js에서는 ""나 ''나 똑같으니까~ 
  }

  @RequestMapping("/javascript/ex00/exam07")
  public Object exam07() {
    String[] names = {"홍길동", "임꺽정", "유관순"}; 
    return names; // 클라이언트에 보내는 것은 UI가 아니라 데이터이다.
  }
}
