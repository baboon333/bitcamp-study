//변수 : 값을 저장할 메모리를 준비시키는 명령어
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam1")  // 클래스 이름이 같은 경우 충돌 방지 ////스프링 부트가 클래스를 구분하기 위해서 붙이는 이름//이름 경로로 주면 구분하기 쉬우니까 그런거지 이름 아무거나 줘도 된다
@RequestMapping("/lang/variable/exam1")  //요청과 연결된 것 // 웹브라우저가 요청과 실행할 메소드를 연결하는 주소! 웹 브라우저가 요청하는 이름! 
public class Exam1 {

  //변수 선언
  //- 값을 저장할 메모리를 준비시키는 명령문
  //강사님꺼 복붙해오기!!

  @GetMapping("/test1")
  public String test1(String name, String tel, String gender) {
    return "클라이언트에서 받은 값= " + name + "," + tel + "," +gender;
  }

  //정수 변수 선언과 값의 범위
  //정수 값을 저장하는 변수 선언과 값의 범위 확인
  //테스트 url:
  //http://localhost:8080/lang/variable/exam1/test2?b=100&s=200&i=2100000000&l=92200000000000000
  @GetMapping("/test2")
  public String test2(byte b, short s, int i, long l) {
    return "클라이언트에서 받은 값= " + b + "," + s + "," + i + "," + l;
  } 

  //부동소수점 변수 선언과 값의 범위
  //- 부동소수점 값을 저장하는 메모리를 준비시키는 명령문
  //메모리 크기에 따른 값의 유효 범위
  //테스트 url:
  //http://localhost:8080/lang/variable/exam1/test3?f=987654.321234&d=987654.32123456789
  @GetMapping("/test3")
  public String test3(float f, double d) {
    return "클라이언트에서 받은 값= " + f + "," + d;
  } 

  //문자 변수 선언
  //- 문자에 부여된 번호를 저장할 메모리를 준비시키는 명령문
  //테스트 url:
  //http://localhost:8080/lang/variable/exam1/test4?c=가
  //http://localhost:8080/lang/variable/exam1/test4?c=%EA%B0%80
  //char는 문자 한개! 두개 이상은 안된다 //%EA%B0%80는 '가'임!! URL 인코딩!
  @GetMapping("/test4")
  public String test4(char c) {
    return "클라이언트에서 받은 값= " + c + "," + (int) c;
  }

  //논리 변수 선언
  //- true/false 논리 값을 저장할 메모리를 준비시키는 명령문
  //테스트 url:
  //http://localhost:8080/lang/variable/exam1/test5?b=true
  //http://localhost:8080/lang/variable/exam1/test5?b=1
  //http://localhost:8080/lang/variable/exam1/test5?b=TRUE
  //(int) b 이거는 오류남! 모든게 형변환이 되는건 아니다
  //주의! (ex04.exam0441)
  // - JVM 내부에서 true, false를 정수 값으로 다룬다고 해서 boolean 변수에 직접 1과 0을 저장할 수 없다.
  //boolean 리터럴은 true/false이다.
  //논리 값으로 1/0, TRUE/FALSE를 받을 수 있는 이유는 
  //스프링 부트가 중간에서 true/false 값으로 변환해주기 때문이다.
  @GetMapping("/test5")
  public String test5(boolean b) {
    return "클라이언트에서 받은 값= " + b;
  }
}
//exam0100~0441까지 공부하기
