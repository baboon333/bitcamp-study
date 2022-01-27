// 쓰다 말음!!!!!!!!!!!!
// 인터페이스 - private 메서드
package com.eomcs.oop.ex09.b;

interface MyInterface4 {

  // 인터페이스 내부에서 사용할 메서드라면
  // private 접근 범위를 갖는
  // 구현 메서드를 정의할 수 있다.
  private void m1() {
    System.out.println("MyInterface4.m1()");
  }

  default void m2() {
    m1();
    System.out.println("MyInterface4.m2()");
  };

  void m3();

}

// 2) 인터페이스 구현
class MyInterface4Impl implements MyInterface4 {
  @Override
  public void m3() {
    // 인터페이스에 선언된 다른 default 메서드를 호출하고 싶다면, -> 앞에 인터페이스명을 안붙여주면 수퍼 클래스의 메서드가 호출된다.
    MyInterface4.super.m2();

    System.out.println("MyInterface4Impl.m3()");
  }
}

public class Exam04 {

  public static void main(String[] args) {
    MyInterface4 obj = new MyInterface4Impl();

    obj.m2();
    System.out.println("-----------------------------");

    obj.m3();

    // 인터페이스에 정의된 private 메서드는 호출할 수 없다. 내부적으로만 쓰는 것이기 때문에!
    //    obj.x(); // 컴파일 오류!

  }

}
