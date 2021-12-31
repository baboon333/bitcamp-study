package com.eomcs.oop.ex01;

//# 레퍼런스와 인스턴스 - 인스턴스 주소 주고 받기
//
public class Exam0310 {
  public static void main(String[] args) {
    class Score {
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float aver;
    }

    // Score 레퍼런스 선언 + 인스턴스 생성(사용할 메모리 확보)
    Score s1 = new Score();

    // s1에 저장된 주소를 s2에도 저장한다.
    // => s1과 s2는 같은 메모리를 가리킨다.
    Score s2 = s1;  // 객체를 주는게 아니라 s1에 저장되어 있는 주소를 s2에 저장하는거다.

    s1.name = "홍길동";  //s1의 name 혹은 s1 객체의 name 이런식으로 개발자들 다 줄여말함~ // "홍길동"은 String 이기 때문에(자바 원시타입이 아닌 레퍼런스 변수이다) 사실은 이 자리에 주소가 오는 건데("홍길동"이 아니라 이 string이 있는 주소) 헷갈리니까 그냥 그림 그릴 때는 String까지는 그냥 값이 들어간다고 생각하고 그리시는 거임 

    // s1이 가리키는 메모리는 s2를 사용하여 접근할 수 있다.
    System.out.println(s2.name);
  }
}
