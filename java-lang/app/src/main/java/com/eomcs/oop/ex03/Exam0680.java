// 스태틱 초기화 블록(static initializer) - 변수 초기화 문장(variable initializer)
// 주석 복붙해오기!!!!!!!!!!!!!!!1
package com.eomcs.oop.ex03;

public class Exam0680 {

  public static class A {

    static int a = 100;  // variable initializer

    static {
      a = 200;
      System.out.println("static {} 실행");
    }

    static {
      b = 400;
    }

    static int b = 300;

    // 클래스 변수가 만들어진 후 변수 초기화 문장과 static 블록은 위에서 아래로 그냥 있는 위치에서 실행된다!
    // 항상 변수 초기화 문장은 두개의 문장으로 분리된 후(static 변수 선언과 스태틱 블록으로), 그 다음 변수선언만 맨 위로 올라가고 static 블록이 합쳐진 후 static 블록이나 초기화 문장에 상관없이 나머지가 위에서 아래로 순서대로 실행된다.  
    // 근데 보통 코드를 짤 때 변수 선언을 맨 처음에 적고 static 블록 적고...!

    // 변수 초기화 문장(variable initializer)을 컴파일 할 때,
    // 1) 스태틱 변수 선언에서 변수 초기화 문장을 별도의 스태틱 블록으로 분리한다.
    // static int a;
    // static {
    //}
    // 
    // - 모든 스태틱 블록을 순서에 따라 한 스태틱 블록에 합친다.
    // - 스태틱 변수 선언문에서 초기화 문장을 분리하여 스태틱 블록의 첫 부분으로 옮긴다.
    //
    // static int a;
    // static int b;
    // static {
    //   a = 100;
    //   a = 200;
    //   System.out.println("static {} 실행");
    //   b = 400;
    //   b = 300;
    // }
    // - 바이트 코드(Exam0680$A.class)를 확인해 보라!
  }

  public static void main(String[] args) throws Exception {

    System.out.println(A.a);
    System.out.println(A.b);
  }
}


