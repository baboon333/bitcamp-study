// Object 클래스 - getClass() 와 배열
package com.eomcs.basic.ex01;

public class Exam0161 {

  public static void main(String[] args) {

    String obj1 = new String();
    Class classInfo = obj1.getClass();
    System.out.println(classInfo.getName()); // java.lang.String

    // 배열의 클래스 정보
    String[] obj2 = new String[10];
    classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); //[Ljava.lang.String; // array 배열이라는 의미에서 [와 L이 붙는다 // [로 시작하면 배열이라는 의미다

    //    int i = 100;
    //    classInfo = i.getClass(); // primitive type은 Object의 서브 클래스가 아니다.

    int[] obj3 = new int[10];
    classInfo = obj3.getClass();
    System.out.println(classInfo.getName()); //[I : int 배열

    float[] obj4 = new float[10];
    classInfo = obj4.getClass();
    System.out.println(classInfo.getName()); //[F

    double[] obj5 = new double[10];
    classInfo = obj5.getClass();
    System.out.println(classInfo.getName()); //[D

    System.out.println(new byte[10].getClass().getName()); //[B
    System.out.println(new short[10].getClass().getName()); //[S
    System.out.println(new long[10].getClass().getName()); //[J  : array 배열에서 이미 L을 써서 J를 쓴다. class를 clazz로 쓰는 것처럼 l과 비슷하게 생겨서 j로 했을 것!
    System.out.println(new char[10].getClass().getName()); //[C
    System.out.println(new boolean[10].getClass().getName()); //[Z
  }
}







