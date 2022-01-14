package com.eomcs.oop.ex05.x7;

public class Sedan extends Car {

  boolean auto;
  boolean openedSunroof;

  @Override
  public void run() {
    System.out.println("부드럽게 달린다!");
  }

  public void openSunroof() {
    System.out.println("선루프 오픈!");
    this.openedSunroof = true;
  } 

  public void closeSunroof() {
    System.out.println("선루프 클로즈!");
    this.openedSunroof = false;
  }

}
