package com.eomcs.oop.ex05.x6;

public abstract class Option extends Car {
  Car car;

  public Option(Car car) {
    this.car = car;  // 어느 자동차에 붙일지 이렇게 주소를 줘야함
  }

  @Override
  public void start() {
    // 데코레이터는 자동차가 아니다.
    // 따라서 시동을 걸라고 요청이 들어오면
    // 실제 자동차 객체에게 위임해야 한다.
    car.start();
  }

  @Override
  public void stop() {
    // 데코레이터는 자동차가 아니다.
    // 따라서 시동을 끄라고 요청이 들어오면
    // 실제 자동차 객체에게 위임해야 한다.
    car.stop(); // 자기가 갖고 있는 stop이나 start가 아니라 car의 것을 써라!! 데코레이터는 차가 아니라 그냥 껍데기일 뿐이니!
  }

}
