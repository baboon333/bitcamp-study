// 특정 폴더를 생성하여 그 폴더에 파일을 만든다.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0431 {

  public static void main(String[] args) throws Exception {
    // 생성할 파일의 경로 설정
    File file = new File("temp/b/test.txt");

    // 파일을 생성하기 전에 존재하지 않는 폴더를 생성하고 싶다면,
    //    String path = file.getParent(); // getParent() => temp/b 파일의 앞부분만 리턴한다.
    //    File dir = new File(path); -> 그 경로로 파일 객체를 생성한 후
    File dir = file.getParentFile(); // 위의 코드와 같다. 이 코드가 위 두줄의 코드를 한줄로 줄여주니 더 좋다!
    System.out.println(dir.getCanonicalPath());

    // 먼저 디렉토리를 생성한다.
    if (dir.mkdirs()) {
      System.out.println("디렉토리를 생성하였습니다.");
    } else {
      System.out.println("디렉토리를 생성할 수 없습니다.");
    }

    // 그런 후 파일을 생성한다.
    if (file.createNewFile()) { // 파일 생성
      System.out.println("파일을 생성하였습니다.");
    } else {
      System.out.println("파일을 생성할 수 없습니다.");
    }


  }

}
