package com.eomcs.oop.ex05.n;

public class Sedan extends Car {
  @Override
  public void run() {  // 이렇게 run() 메서드 구현 안하고 추상메서드인채로 놔두면 에러!
    System.out.println("쌩쌩 달린다.");
  }

  public void doSunroof(boolean open) {
    if (open) {
      System.out.println("썬루프를 연다.");
    } else {
      System.out.println("썬루프를 닫는다.");
    }
  }
}
