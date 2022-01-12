package com.eomcs.oop.ex05.l;

public class Truck extends Car {
  @Override
  public void run() { // 오버라이딩
    System.out.println("덜컹 덜컹 달린다.");
  }

  public void dump() {
    System.out.println("짐을 내린다.");
  }
}
