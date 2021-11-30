package com.eomcs.lang.ex03;

//# 리터럴(literal)
//- 자바 언어로 표현한 값.
//

public class Exam0100 {
  public static void main(String[] args) {
    System.out.println("-------- 정수 리터럴");
    System.out.println(78); // 10진수
    System.out.println(+78);
    System.out.println(-78);
    System.out.println(0116); // 8진수  //0으로 시작한다.
    System.out.println(0x4e); // 16진수  //0x로 시작한다. e는 12, 15 이렇게 특정 숫자를 16진수에서는 알파벳으로 표현하더라!
    System.out.println(0b01001110); // 2진수  //0b로 시작한다. 

    System.out.println("-------- 부동소수점 리터럴");
    System.out.println(3.14);
    System.out.println(31.4e-1);

    System.out.println("-------- 논리 리터럴");
    System.out.println(true);
    System.out.println(false);

    System.out.println("-------- 문자 리터럴");
    System.out.println('가');

    System.out.println("-------- 문자열 리터럴");
    System.out.println("오호라 코딩스쿨!");
  }
}