package com.eomcs.lang.ex07;

import java.util.Scanner;

// 1단계: 공백 출력 코드를 메서드로 추출하기
//
public class Exam0111 {

  static void printSpaces(int len) {  //void: 아무것도 리턴하지 않고 작업만 하겠다  //printSpaces처럼 이름을 지을 때 보통 동사구형태를 쓴다.
    int spaceCnt = 1;
    while (spaceCnt <= len) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  public static void main(String[] args) {  //main처럼 static이 붙어있는 method는 static이 안붙어있는 method를 호출할 수 없다. 그래서 위 printSpace method에 static이 붙어있는거임
    Scanner keyScan = new Scanner(System.in); // static이 뭔지는 나중에 알려주신다고 하니 일단 method를 만들 때 static을 무조건 붙여라
    System.out.print("밑변의 길이? ");        // static 끼리만 호출할 수 있다! static이 안붙은 애들은 안붙은 애들끼리 호출할 수 있다. 이 둘의 기능 차이는 나중에~
    int len = keyScan.nextInt();
    keyScan.close();

    int starLen = 1;
    while (starLen <= len) {
      printSpaces((len - starLen) / 2);

      // 별 출력
      int starCnt = 1;
      while (starCnt <= starLen) {
        System.out.print("*");
        starCnt++;
      }

      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;
    }
  }
}