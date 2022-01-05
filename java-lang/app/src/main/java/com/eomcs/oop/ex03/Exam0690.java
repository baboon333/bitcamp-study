// 스태틱 초기화 블록(static initializer) - 활용
package com.eomcs.oop.ex03;

public class Exam0690 {

  public static class A {
    static float pi;   // static float pi = 3.14159f;

    // 스태틱 블록은 클래스 멤버를 사용하기 전에 유효한 값으로 초기화시키는 것.
    static {  // 이런 간단한 변수 초기화는 그냥 한번에 위에서 변수 초기화 문장으로 써!!
      pi = 3.14159f;
    }

    static float area(int r) {
      return pi * r * r; 
    }

  }

  public static void main(String[] args) throws Exception {
    System.out.println(A.area(25));
  }
}


