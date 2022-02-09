package com.eomcs.net.ex11.test;

import java.net.ServerSocket;

public class CalculatorServer1 {
  public static void main(String[] args) {
    try(ServerSocket serversocket = new ServerSocket(8888)){ // close를 자동으로 하려고 try 안에 둔다. // 서버는 포트번호만 주면 된다
      System.out.println("서버 실행 중...");

    } catch (Exception e) {
      System.out.println("서버 소켓 생성 중 오류 발생!");
    }
  }
}