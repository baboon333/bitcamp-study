package com.eomcs.oop.ex05.x7;

public abstract class Car {

  int cc;
  int valve;

  public void start() {
    System.out.println("차 시동 건다!");
  }

  public void stop() {
    System.out.println("차 시동 끈다!");
  }

  public abstract void run();
}
