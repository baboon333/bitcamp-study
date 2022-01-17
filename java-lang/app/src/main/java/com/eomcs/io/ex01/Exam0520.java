// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기 II
package com.eomcs.io.ex01;

import java.io.File;
import java.sql.Date;

public class Exam0520 {

  public static void main(String[] args) throws Exception {

    File dir = new File(".");

    // 파일이나 디렉토리 정보를 File 객체로 받기
    // => File은 디렉토리와 파일을 통칭하는 용어다.
    // 0510과 다르게 파일과 디렉토리를 구분하여 리턴한다.
    File[] files = dir.listFiles();

    for (File file : files) {
      System.out.printf("%s   %s %12d %s\n",  // %12d: 최대 12자리
          file.isDirectory() ? "d" : "-",       // 파일이면 -를 집어넣어라~
              new Date(file.lastModified()),  // 파일 마지막 수정날짜
              file.length(),
              file.getName());
    }

  }

}


