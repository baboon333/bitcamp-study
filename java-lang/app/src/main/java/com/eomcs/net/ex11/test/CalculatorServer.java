package com.eomcs.net.ex11.test;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
  public static void main(String[] args) {
    try(ServerSocket serverSocket = new ServerSocket(8888)){ // close를 자동으로 하려고 try 안에 둔다. // 서버는 포트번호만 주면 된다
      System.out.println("서버 실행 중...");

      while(true) {
        try(Socket socket = serverSocket.accept();
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            ) {

          String str = in.nextLine();
          out.println(str);
          out.flush();

        } catch (Exception e) {
          System.out.println("클라이언트 요청 처리 중 오류 발생!");

        }

      } catch (Exception e) {
        System.out.println("서버 소켓 생성 중 오류 발생!");
      }

    }
  }
