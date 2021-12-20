package com.eomcs.lang.ex07;

// # JVM 아규먼트  //값에 대해 이름을 부여할 수 있는게 특징이다. 따라서 순서가 상관없으니 프로그램 아규먼트는 순서가 상관있다.
//
public class Exam0610 {

  public static void main(String[] 변수명은상관없다) {
    // JVM 아규먼트?  //클래스 앞에!  // 주의: 클래스 뒤에 놓으면 프로그램 아규먼트이다.
    // - JVM에게 전달하는 값
    // - 형식
    // $java -cp ./bin/main -D이름=값 -D이름=값 -D이름=값 com.eomcs.basic.ex07.Exam0610 //공백을 띄면 안된다.
    //

    // JVM 아규먼트의 값 꺼내기
    // => System.getProperty("이름");
    //
    String value1 = System.getProperty("a");
    String value2 = System.getProperty("b");
    String value3 = System.getProperty("c");

    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
  }
}


