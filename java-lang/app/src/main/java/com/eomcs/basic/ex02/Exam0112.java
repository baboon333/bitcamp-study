// String - String 객체와 문자열 리터럴의 타입
package com.eomcs.basic.ex02;

public class Exam0112 {
  public static void main(String[] args) {

    String s1 = new String("Hello");  // Heap 영역에 String 인스턴스를 만든다.
    String s2 = "Hello";  // String Pool 영역에 String 인스턴스를 만든다.  // 얘가 다른 점은 얘는 똑같은 문자열 들어있는 객체 생성할라치면 안만들고 기존 것의 주소를 리턴한다. 
    // 레퍼런스는 무조건 주소만 저장한다. s2에는 "hello"문자열이 있는 인스턴스의 주소가 들어있는 것이다.
    // 둘다 인스턴스를 만든다는 점은 같다.

    // 문자열 리터럴이 String 객체인지 확인해보자.
    System.out.println(s1 == s2);
    System.out.println(s1 instanceof String);
    System.out.println(s2 instanceof String);
  }
}


