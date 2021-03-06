package com.eomcs.lang.ex04;

//# 형변환 - 명시적 형변환
//
public class Exam0930 {
  public static void main(String[] args) {
    //쓰다 말음!!!!!!
    // 부동소수점 메모리의 값은 정수 메모리에 저장할 수 없다.
    // 그럼에도 저장하려 한다면, 명시적 형변환 문법을 사용해야 한다. 
    //
    // 명시적 형변환을 통해 부동소수점의 값을 정수 메모리에 저장할 때. 
    // 소수점 이하의 값이 잘린다.
    // 값이 짤릴 수 있음을 알면서도 정수 메모리에 저장해야 할 때가 있다.
    // 또는 큰 메모리의 값을 작은 메모리에 저장해야 할 때가 있다.
    //
    //"명시적 형변환(explicit )"

    // 해결책?
    // - 컴파일러에게 강제로 값을 넣을 것을 명시하라!
    // - 이것을 "명시적 형변환(explicit type conversion)"이라 부른다.
    //
    // float ==> int 
    float f = 3.14f;
    int i = (int)f;  // 소수점 이하가 제거된다.  //int i = f; 이렇게 하면 에러난다
    System.out.println(i);

    // double ==> long
    double d = 9876.56789;
    long l = (long)d; // 소수점 이하가 제거된다.
    System.out.println(l);
  }
}
// 명시적 형변환
// - 큰 메모리의 값을 작은 메모리로 변환 할 때 
// - 부동소수점을 정수로 변환 할 때  
// - 문법
//   변수 = (바꾸고자하는타입) 변수 또는 값;
//