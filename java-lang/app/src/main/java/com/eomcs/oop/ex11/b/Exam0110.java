// static nested class : 클래스 정의와 인스턴스 생성
package com.eomcs.oop.ex11.b;

class A {
  static class X {

  }
}

public class Exam0110 {

  public static void main(String[] args) {
    // 레퍼런스 선언
    A.X obj; // 일반적인 클래스 메서드를 호출하듯이 똑같이 호출할 수 있다. 임포트할 때 패키지명을 적듯이 클래스명을 적으면 된다!

    // 인스턴스 생성
    obj = new A.X();
  }

}
