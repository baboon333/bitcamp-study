package com.eomcs.lang.ex04;

//# 배열 - 배열 레퍼런스와 null
//
public class Exam0551 {
  public static void main(String[] args) {

    int[] arr1;
    arr1 = new int[5];

    // 배열 레퍼런스를 초기화시키고 싶다면 null로 설정하라.
    arr1 = null; // 0으로 설정. 즉 레퍼런스가 아무것도 가리키지 않음을 의미. 주소를 0으로 설정하고 싶다고 0이라고 하면 안되고 null이라고 해야 한다. 이렇게 하면 내부적으로 0이 되는 거임!!
    // 레퍼런스만 초기화 되는 거고, 인스턴스는 그대로 남아 있는거임! 저 남아있는 인스턴스는 c나 c++에서는 개발자가 직접 메모리를 없앨 수 있는데 자바에서는 c언어의 댕글링 포인터를 사용하게 될까봐 문법 자체를 만들지를 않아 안된다. 이런 더이상 사용할 수 없는 메모리가 "garbage"이다.
    // 레퍼런스가 배열 인스턴스를 가리키지 않은 상태에서 사용하려 하면?
    System.out.println(arr1[0]); // NullPointerException 실행 오류!
  }
}