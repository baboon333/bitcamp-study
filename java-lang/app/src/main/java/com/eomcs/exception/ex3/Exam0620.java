// 예외 처리 후 마무리 작업 - finally 블록과 자원 해제
package com.eomcs.exception.ex3;

import java.util.Scanner;

public class Exam0620 {

  public static void main(String[] args) {
    Scanner keyScan = null; // try 안에 변수를 선언하면 finally에서는 못쓰니! 변수는 블록안에서만 사용할 수 있잖아!
    try {
      keyScan = new Scanner(System.in);

      System.out.print("입력> ");
      int value = keyScan.nextInt();
      System.out.println(value * value);

    } finally {
      // 이렇게 정상적으로 실행되든 예외가 발생하든 상관없이
      // 자원해제 같은 일은 반드시 실행해야 한다.
      keyScan.close();
      System.out.println("스캐너 자원 해제!");
    }
  }

}
