package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 문자열 한 줄 읽기
//
public class Exam0220 {
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;                //시스템 in을 변수에 담아서
    java.util.Scanner keyboardScanner = new java.util.Scanner(keyboard);

    // 팀 멤버의 정보를 입력 받아 출력하라.
    // 이름, 전화, 이메일, 나이, 재직여부
    // 예)
    // 이름? 홍길동
    // 홍길동
    // 전화? 1111-2222
    // 1111-2222
    // 이메일? hong@test.com
    // hong@test.com
    // 나이? 20
    // 20
    // 재직여부? y
    // y
    System.out.print("이름? ");
    System.out.println(keyboardScanner.nextLine());  //사용자가 문자열을 입력하고 난 다음 엔터를 칠 때까지 기다리다가 엔터를 치면 그 전까지를 문자열로 만들어서 리턴해줌. nextLine()은 엔터를 쳤을 때 실행이 끝난다 
    System.out.print("전화? ");
    System.out.println(keyboardScanner.nextLine());
    System.out.print("이메일? ");
    System.out.println(keyboardScanner.nextLine());
    System.out.print("나이? ");
    System.out.println(keyboardScanner.nextLine());
    System.out.print("재직여부? ");
    System.out.println(keyboardScanner.nextLine());

    keyboardScanner.close();
  }
}

