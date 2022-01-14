package com.eomcs.oop.ex05.x6;

public class BlackBox extends Option {

  public BlackBox(Car car) {
    super(car);
  }

  @Override
  public void run() {
    car.run(); // 기존 자동차가 하는 그 일을 해!
  }

  @Override
  public void start() {
    System.out.println("녹화 시작!");
    super.start();  // 슈퍼클래스인 option에서 car.start()를 호출하게 되어 있으니!
  }

  @Override
  public void stop() {
    super.stop();
    System.out.println("녹화 종료!");
  }
}
