// 기존의 클래스를 손대지 않고 새 기능만 추가한다.
// 어떻게? 상속 문법을 이용한다.
package com.eomcs.oop.ex05.d;

public class Score2 extends Score { // 상속 문법: extends 수퍼 클래스이름

  // 새 필드를 추가한다.
  public int music;
  public int art;


  // 기존 코드를 변경한다. => 기존의 메서드 재정의 => 오버라이딩(overriding): super class의 메서드 형식(메서드명, 파라미터, 리턴타입)이 같아야 한다 //이 메서드 형식을 “method signature”라고 한다.
  @Override  // 컴파일러에게 재정의를 제대로 했는지 검사해달라고 서비스를 요청하는 명령(안붙여도 되지만 붙이면 실수를 줄일 수 있다) // 개발자님! 메서드명이 틀렸습니다!!이런 것!
  public void compute() {
    this.sum = this.kor + this.eng + this.math + this.music + this.art;
    this.aver = this.sum / 5f;
  }
}







