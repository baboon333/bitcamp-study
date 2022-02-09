package com.eomcs.net.ex11.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorMiddleS3 {

  String logo;

  public CalculatorMiddleS3() {
    StringBuilder logoStr = new StringBuilder();

    try (BufferedReader welcomeIn = new BufferedReader(new FileReader("welcome.txt"));) {
      while (true) {
        String str = welcomeIn.readLine();
        if (str == null) {
          break;
        }
        logoStr.append(str + "\n");
      }
    } catch (Exception e) {
      if (logoStr.length() > 0) {
        logoStr.setLength(0);
      }
      logoStr.append("환영합니다!\n");
    }

    logo = logoStr.toString();
  }

  public void launch(int port) {
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("서버 실행 중...");

      while (true) {
        new RequestHandler(serverSocket.accept());  // 어떻게 바꿨냐 이거
        requestHandler.start();
      }

    } catch (Exception e) {
      System.out.println("서버 소켓 생성 중 오류 발생!");
    }
  }

  public static void main(String[] args) {
    new CalculatorMiddleS3().launch(8888);
  }

  class RequestHandler extends Thread { // CalculatorServer에서만 쓰니 굳이 공개할 필요도 없다.

    Socket socket;

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (
          Socket socket2 = socket; // close() 자동 호출하기 위해
          Scanner in = new Scanner(socket.getInputStream());
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {

        out.print(logo); // 바깥클래스명.this 생략가능! 마치 자기 변수인냥!

        out.println("계산식을 입력하세요!");
        out.println("예) 23 + 7 ");
        out.println();

        String str = in.nextLine();
        out.println(str);
        out.flush();

      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
      }
    }
  }
}








