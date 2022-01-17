// 디렉토리 생성
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0310 {

  public static void main(String[] args) throws Exception {
    // 1) 생성할 디렉토리 경로 설정
    // - 폴더 경로를 지정하지 않으면 현재 폴더를 의미한다.
    //
    // 아 파일 클래스(자바 프로그램)로 디렉토리를 만들 수 있다. 이것만 알아둬!
    File dir = new File("temp");
    if (dir.mkdir()) { // 디렉토리 생성
      System.out.println("temp 디렉토리를 생성하였습니다.");
    } else {
      System.out.println("temp 디렉토리를 생성할 수 없습니다.");
    }


  }

}
