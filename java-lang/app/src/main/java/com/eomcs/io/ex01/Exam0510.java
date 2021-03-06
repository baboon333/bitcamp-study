// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0510 {

  public static void main(String[] args) throws Exception {

    // 현재 폴더(.)의 정보를 알아낸다.  -> 이클립스에서 실행할 때는 프로젝트 폴더가 현재 폴더이다!
    File dir = new File(".");

    // 현재 폴더에 있는 파일이나 하위 디렉토리(직계자식) 이름을 알아내기
    String[] names = dir.list();

    for (String name : names) {
      System.out.println(name);
    }
  }
}


