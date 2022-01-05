// 생성자 - 생성자 호출 막기 = 인스턴스 생성을 막기
package com.eomcs.oop.ex03;

class X {
  // 생성자의 접근 범위를 private으로 설정하면 외부에서 접근할 수 없기 때문에
  // 생성자를 호출할 수 없다.
  // 결국 인스턴스를 생성하지 못하게 만든다.
  private X() {  // 생성자 앞에 private하면 외부에서 이를 접근 할 수 없다.
    System.out.println("X()");
  }
}

public class Exam0450 {
  public static void main(String[] args) {
    X obj1;

    // 생성자의 접근이 막혀있기 때문에 생성자를 호출할 수 없다.  // 이게 필요한 경우가 있다! 자세한건 나중에~
    // 따라서 new 명령으로 객체를 생성할 수 없도록 만든다.
    //    obj1 = new X(); // 컴파일 오류!  외부에서 접근하지 못하도록 private로 했기 때문!

  }
}








