package com.eomcs.lang.ex07;

// # 메서드 : 개념 및 기본 문법 II
//
public class Exam0221 {

  static void hello(String name, int age) {
    System.out.printf("%d살 %s님 반갑습니다.\n", age, name);
  }

  public static void main(String[] args) {
    // 파라미터의 타입, 개수, 순서가 일치해야 한다.  // js같이 느슨한 언어에서는 ok

    //    hello("윤봉길"); // 컴파일 오류! 개수가 틀리다
    //    hello(20, "윤봉길"); // 컴파일 오류! 순서가 다르다
    //    String r = hello("안중근", 30); // 컴파일 오류! // 리턴값이 없으니 오류이다(void)
    //    void r = hello("안중근", 30); // 컴파일 오류! // 리턴하지 않으니
  }
}
