package com.eomcs.oop.ex01;

// # 패키지 멤버 클래스와 중첩 클래스
//

// 패키지 멤버 클래스
// - 단독으로 선언하는 클래스이다.
// - "패키지 멤버 클래스"라 부른다.
// - 물론 이 예제처럼 한 파일에 여러 개의 클래스를 선언할 수 있지만,
//   보통은 한 파일에 한 클래스를 선언한다.
// - 패키지 멤버 클래스는 접근 권한이 있다면 누구든 사용할 수 있다.
//
// bin/main/com/eomcs/oop/ex01/A.class    //컴파일한 파일이 기본으로 놓이는 폴더가 bin/main 여기이다!
class A {}  //클래스 A는 0510과 같은 레벨이다  // a 클래스는 이 밑에 exam0510 안에 있는 class는 다 쓸 수 있다.

// => bin/main/com/eomcs/oop/ex01/Exam0510.class
public class Exam0510 {

  // 중첩 클래스(nested class)  //이런 기술용어들 영어로 써! 한글로 말하지말고! 네스티드 클래스!!!
  // - 다른 클래스 안에 정의된 클래스
  // - 그 클래스 안에서만 사용된다.
  // - 종류:
  //   1) 스태틱 중첩 클래스(static nested class)
  //   2) 논-스태틱 중첩 클래스(non-static nested class = inner class)
  //   3) 로컬 클래스(local class)
  //   4) 익명 클래스(anonymous class)
  //

  // 1) 스태틱 중첩 클래스(static nested class)
  // - 이 클래스를 소유하고 있는 클래스 뿐만 아니라 다른 클래스도 사용할 수 있다.
  //
  // bin/main/com/eomcs/oop/ex01/Exam0510$B.class
  static class B {}

  // 2) 논-스태틱 중첩 클래스
  // - 특정 인스턴스에 종속된 클래스인 경우 논-스태틱 중첩 클래스로 정의한다.
  //
  // bin/main/com/eomcs/oop/ex01/Exam0510$C.class
  class C {}


  public static void main(String[] args) {
    // 3) 로컬 클래스(local class)
    // - 메서드 블록 안에 정의된 클래스
    // - 오직 그 메서드 블록 안에서만 사용된다.
    //
    // bin/main/com/eomcs/oop/ex01/Exam0510$1D.class
    class D {}   //static class D{} 안되는 이유는 클래스 멤버가 아니기 때문이다. 얘는 메서드 안에 있는 메서드 클래스이기 때문이다. 메서드 안에서만 이 클래스를 쓸 수 있다. 밖에선 못씀

    // 4) 익명 클래스(anonymouse class)
    // - 클래스 이름이 없는 중첩 클래스이다.
    // - 딱 한 개의 인스턴스를 생성할 때 사용한다.
    // - 클래스를 정의할 때 수퍼 클래스나 인터페이스를 지정해야 한다.
    // - 클래스를 정의할 때 new 연산자를 사용하여 즉시 인스턴스를 생성해야 한다.
    //
    // bin/main/com/eomcs/oop/ex01/Exam0510$1.class   (네비게이터에서 확인해봐)
    Object obj = new Object() {          //익명 클래스 만드는 문법 : 자세한건 나중에!
      String name;
      int age;
    };
  }

  static void m1() {
    // 패키지 멤버 클래스는 그 패키지에 소속된 누구라도 사용할 수 있다.
    // 같은 패키지가 아니라도 공개된 패키지 멤버는 누구라도 사용할 수 있다.
    A obj1 = new A();

    // 같은 스태틱 멤버라면 스태틱 중첩 클래스를 사용할 수 있다.
    B obj2 = new B();

    // 스태틱 멤버는 논-스태틱 중첩 클래스(인스턴스 멤버)를 사용할 수 없다.
    // C obj3 = new C(); // 컴파일 오류!  C는 Static이니까  //static 멤버가 non-statiac 멤버를 사용하려면 반드시 인스턴스 주소를 지정해야 한다. //non-static 멤버는 static 멤버에 접근할 때 인스턴스 주소 없이 클래스 이름으로 접근 가능하다. 

    // 다른 메서드에 정의된 로컬 클래스는 사용할 수 없다.
    // D obj4 = new D(); // 컴파일 오류!   // 주석풀고 저장하면 자동으로 import되기 때문에 그거 지워줘야 한다!!!(다른데 있는 파일 긁어오는 것)

  }

  void m2() {
    // 패키지 멤버 클래스는 그 패키지에 소속된 누구라도 사용할 수 있다.
    // 같은 패키지가 아니라도 공개된 패키지 멤버는 누구라도 사용할 수 있다.
    A obj1 = new A();

    // 논-스태틱 멤버(인스턴스 멤버)는 스태틱 중첩 클래스를 사용할 수 있다.
    B obj2 = new B();

    // 인스턴스 멤버는 다른 인스턴스 멤버(논-스태틱 중첩 클래스)를 사용할 수 있다.
    C obj3 = new C(); // OK!

    // 다른 메서드에 정의된 로컬 클래스는 사용할 수 없다.
    // D obj4 = new D(); // 컴파일 오류!

  }
}
