package com.eomcs.net.ex11.test;

import java.net.Socket;

public class CalculatorClient1 {
  public static void main(String[] args) {
    try(Socket socket = new Socket("localhost", 8888)) { // 항상 변수 선언은 try 안에 와야 한다.
      System.out.println("서버 연결 성공!");

    } catch (Exception e) {
      System.out.println("서버 연결 오류!");
    }
  }
}