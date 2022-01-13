package com.eomcs.oop.ex05.x3.app1;

public class Engine {
  int cc;
  int valve;

  public void run () {
    System.out.println("씽씽 달린다.!");  // 이렇게 직접 하나하나 찾아서 바꾸다보면 오타 실수를 할 수 있다! 
  }

  // 자동차 기능 추가
  public void start() {
    System.out.println("시동 건다!");
  }

  public void stop() {
    System.out.println("시동 끈다!");
  }

}

















