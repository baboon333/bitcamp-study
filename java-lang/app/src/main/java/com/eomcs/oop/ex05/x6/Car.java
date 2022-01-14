package com.eomcs.oop.ex05.x6;

public abstract class Car {

  int cc;
  int valve;

  public void start() {
    System.out.println("시동켠다!");
  }

  public void stop() {
    System.out.println("시동 끈다!");
  }

  public abstract void run();  // 추상메서드는 추상클래스로만 사용할 수 있따!

}
