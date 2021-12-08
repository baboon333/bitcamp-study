package com.eomcs.lang.ex05;

//# 비트 연산자 & 를 이용하여 % 연산 구현하기 응용 I
//
public class Exam0352 {
  public static void main(String[] args) {
    // % 연산자를 이용하여 짝수/홀수 알아내기
    System.out.println(57 % 2 == 0 ? "짝수" : "홀수");

    // & 연산자를 이용하여 짝수/홀수 알아내기
    System.out.println((57 & 0x1) == 0 ? "짝수" : "홀수"); // 맨끝 비트가 0이면 짝수고 아니면 홀수다  //홀짝 할 떄 이렇게 &연산자 쓰는 선배 있으니 꼭 알아둬

  }
}

