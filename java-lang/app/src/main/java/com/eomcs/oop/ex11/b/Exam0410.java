//static nested class : import static 사용 전
package com.eomcs.oop.ex11.b;

import com.eomcs.oop.ex11.b.sub.M;

class D {
  static int v1;

  static void m1() {}

  static class X {
    void test() {
      System.out.println("test()");
    }
  }
}

public class Exam0410 {

  public static void main(String[] args) {
    // 같은 패키지 클래스
    com.eomcs.oop.ex11.b.D.v1 = 100; // 같은 패키지에 있기 때문에 com.eomcs.oop.ex11.b 패키지명 생략 가능! 컴파일러가 컴파일할 때 자동으로 붙인다. 
    D.m1();
    D.X obj = new D.X();

    // 다른 패키지 클래스
    M.v2 = 200; // 미리 import 해왔기 때문에 com.eomcs.oop.ex11.b.sub 패키지명 생략 가능! 컴파일러가 컴파일할 때 자동으로 붙인다.
    M.m2();
    M.Y obj2 = new M.Y();
  }

}
