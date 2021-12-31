package com.eomcs.oop.ex02;

public class ExamTest3 {

  static class calculator{

    int result = 0;

    static void plus(int value) {
      result += value;
    }

    static void minus(int value) {
      result -= value;
    }

    static void multiple(int value) {
      result *= value;
    }

    static void divide(int value) {
      result /= value;
    }
  }


  public static void main(String[] args) {

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    calculator.plus(c1, 2);
    calculator.plus(c2, 2);

    calculator.plus(c1, 3);
    calculator.plus(c2, 3);

    calculator.minus(c1, 1);
    calculator.minus(c2, 1);

    calculator.multiple(c1, 7);
    calculator.multiple(c2, 7);

    calculator.divide(c1, 3);
    calculator.divide(c2, 3);

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }
}

