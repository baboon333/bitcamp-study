package com.eomcs.lang.ex06;

import java.util.Scanner;

//# 흐름 제어문 - if ~ else if ~ else if ~ else
//
public class Exam0161 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("나이를 입력하세요? ");
    int age = keyScan.nextInt();

    // if ~ else ~는 한 문장이기 때문에
    // if ~ else ~ 만 있다면 블록으로 묶지 않아도 된다.      
    // if~else에서 else 안에 있는건 한문장 치기 때문에 중괄호 없애도 된다. 
    //exam 0160이랑 똑같으니까 확인해봐! 앞에서 중괄호 빼고 줄만 맞춘거임!! 다른게 아니야~ 
    //자바는 else if라는 문법이 없음 if는 그냥 else에 속한 if임!! 근데 elseif라는 문법이 존재하는 언어도 있다.

    if (age < 8)
      System.out.println("아동입니다.");
    else if (age < 14)
      System.out.println("어린이입니다.");
    else if (age < 19)
      System.out.println("청소년입니다.");
    else if (age < 65)
      System.out.println("성인입니다.");
    else
      System.out.println("노인입니다.");

    keyScan.close();
  }
}