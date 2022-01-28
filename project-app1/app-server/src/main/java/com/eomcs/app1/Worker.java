package com.eomcs.app1;   // 쓰다 말음!!!!!!!!

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Worker extends Thread {

  Socket socket;

  public Worker(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      Scanner in = new Scanner(socket.getInputStream());
      PrintStream out = new PrintStream(socket.getOutputStream());

      String queryString = in.nextLine();
      String[] values = queryString.split("/");

      if (values.length != 3) {
        out.println("상은: 계산식이 올바르지 않습니다.");

      } else {
        int a = Integer.parseInt(values[0]);
        String op = values[1];
        int b = Integer.parseInt(values[2]);
        int result = 0;

        switch (op) {
          case "+": 
            result = a + b;
            out.printf("상은: %d %s %d = %d\n", a, op, b, result);
            break;
          case "-": 
            result = a - b; 
            out.printf("상은: %d %s %d = %d\n", a, op, b, result);
            break;
          case "/": 
            Thread.sleep(20000);
            result = a / b; 
            out.printf("상은: %d %s %d = %d\n", a, op, b, result);
            break;  
          case "*": 
            result = a * b; 
            out.printf("상은: %d %s %d = %d\n", a, op, b, result);
            break;  
          default: 
            out.println("상은: 지원하지 않는 연산자입니다.");
        }
      }

      socket.close();
      System.out.println("클라이언트 연결 종료!");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}







