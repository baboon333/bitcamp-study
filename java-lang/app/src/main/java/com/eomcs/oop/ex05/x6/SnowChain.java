package com.eomcs.oop.ex05.x6;

public class SnowChain extends Option {

  public SnowChain(Car car) {
    super(car);  // 수퍼클래스 생성자에 car 전달
  }

  @Override
  public void run() {
    System.out.println("도로 마찰력을 증가시킨다");
    car.run();
  }
}
