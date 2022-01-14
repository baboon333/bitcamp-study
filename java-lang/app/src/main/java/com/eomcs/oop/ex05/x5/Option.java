package com.eomcs.oop.ex05.x5;

public abstract class Option extends Car {  // run 구현 안하니 추상 클래스로 만들어야함! run이 추상메서드잖아! 

  Car car;

  public Option(Car car) {
    this.car = car;
  }
}
