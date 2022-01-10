package com.eomcs.oop.ex05.x1.test1;

class CalculatorTest {
  public static void main(String[] args) {
    Calculator c = new Calculator();

    c.plus(100);  // 인스턴스 메서드이기 때문에! 메서드 앞 부분에 인스턴스 주소를 파라미터로 전달(this)한다.
    c.minus(200);

    System.out.println(c.result);
  }
}
