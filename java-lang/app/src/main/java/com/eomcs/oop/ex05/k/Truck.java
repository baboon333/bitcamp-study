package com.eomcs.oop.ex05.k;

public class Truck {
  public void launch() {  // 메서드 역할을 비슷하지만 이름은 이렇게 달라도 된다. 오해할까봐 start에서 launch로 바꿔줌!
    System.out.println("시동 건다!");
  }
  public void stop() {
    System.out.println("시동 끈다!");
  }
  public void go() {
    System.out.println("덜컹 덜컹 달린다.");
  }
  public void dump() {
    System.out.println("짐을 내린다.");
  }
}
