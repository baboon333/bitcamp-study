package com.eomcs.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);   //App이라는 클래스는 SpringApplication이라는 외부 라이브러리를 사용하는 것! ctrl 누른채로 SpringApplication 클릭하면 이 위치로 간다! 
  }

  @RequestMapping("/hello") 
  String hello() {
    return "Hello, java-lang-boot";
  }
}//앱 클래스를 실행하면 스프링 부트를 실행하면서 서브렛 컨테이너와 웹 서버가 실행된다.