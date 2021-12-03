package com.eomcs.lang.ex04;

//# 배열 - 배열을 선언하는 방법 
// 배열?
// - 같은 종류의 메모리를 쉽게 만드는 방법
//
// - 문법
//        메모리종류[] 메모리이름 = new 메모리종류[개수]
//        데이터타입[] 변수명 = new 데이터타입[개수];
//        ex) int[] arr = new int[5];
//
// - C언어 스타일 
//        데이터타입 변수명[] = new 데이터타입[개수];
//        ex) int arr[] = new int[5];
//
// 배열의 개수는 int 타입의 최대 값과 같다.
// 즉 2147483647 개 이다. 
//
public class Exam0510 {
  public static void main(String[] args) {
    // 배열 사용 전
    int i1, i2, i3, i4, i5;

    // 배열 선언
    int[] arr1 = new int[5]; // OK! // java 방식
    int arr2[] = new int[5]; // OK! C-style. //c 언어 방식

    // 배열의 크기는 int 타입의 최대 값에서 2를 뺀 값이다.
    // 배열의 최대 크기 = Integer.MAX_VALUE - 2

    //int[] arr3 = new int[2147483647]; // 실행 오류(컴파일 할 때 나는게 아니라 실행할 때 나는 오류) => VM의 배열 크기 제한을 초과  //운영체제가 준 메모리보다 메모리를 더 쓴다고 하니까 실행오류가 나는 거임. 
    // Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit

    //int[] arr3 = new int[2147483645]; // OK! //1바이트 21억개가 아니라 4byte를 21억개 만드는거니 84억개 바이트를 기가 바이트로 표현하면 8GB이니!
    //int[] arr3 = new int[Integer.MAX_VALUE - 2]; // OK!  //integer의 최대 크기보다 2개 작은!!

    // 실행 오류 발생!
    // => Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    // => JVM이 OS로부터 사용 허가를 받은 메모리 크기를 벗어났기 때문에 발생한 것이다.

    // 해결책?
    // => JVM을 실행할 때 최대 힙(heap) 메모리의 크기를 늘리면 된다.
    // => JVM 실행 옵션에 다음을 추가하라!
    //        -Xmx메모리크기
    //    예) $ java -Xmx20000m ...
    System.out.println("종료!");
  }
}


