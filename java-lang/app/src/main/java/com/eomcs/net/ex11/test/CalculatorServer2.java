package com.eomcs.net.ex11.test;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer2 {
  public static void main(String[] args) {
    try(ServerSocket serverSocket = new ServerSocket(8888)){ // close를 자동으로 하려고 try 안에 둔다. // 서버는 포트번호만 주면 된다
      System.out.println("서버 실행 중...");

      Socket socket = serverSocket.accept(); // 대기열의 한놈의 클라이언트가 들어올 때까지 계속 기다리기 때문에 서버 소켓 생성 중 오류 안남! // accept() : 클라이언트와 연결된 소켓을 리턴한다.

      Scanner in = new Scanner(socket.getInputStream());
      PrintStream out = new PrintStream(socket.getOutputStream());// 한 줄을 출력할거니 프린트 스트림 사용

      String str = in.nextLine();
      out.println(str);
      out.flush();

      in.close();  // autocloseble 메서드를 상속받은 것들은 try 괄호 안에 집어넣으면 자동으로 close된다.
      out.close();
      socket.close();    // 소캣으로 부터 입출력 스트림을 얻었기 때문에 소캣을 마지막으로 닫아야 한다


    } catch (Exception e) {
      System.out.println("서버 소켓 생성 중 오류 발생!");
    }
  }
}