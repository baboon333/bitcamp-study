package com.eomcs.app1;

public class App {

  public static void main(String[] args) {

    java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);

    if (keyboardScanner.nextLine() == "help") {
      int age = keyboardScanner.nextInt();
      keyboardScanner.nextLine();

      String name = keyboardScanner.nextLine();

      keyboardScanner.close();

      System.out.printf("%d(%s)\n", age, name);

    }


    if (args.length == 0) {          
      System.out.println("사용법:\n"
          + "App [명령] [값1] [값2]\n"
          + "명령: \n"
          + "add   [값1] [값2]   더하기 계산을 수행한다. 예) App add 100 200\n"
          + "minus [값1] [값2]   빼기 계산을 수행한다.   예) App minus 100 200\n");
    } else {
      if (args[0].equals("add")) {
        int v1 = Integer.parseInt(args[1]);
        int v2 = Integer.parseInt(args[2]);
        System.out.printf("%d + %d = %d\n", v1, v2, (v1 + v2));
      }

      if (args[0].equals("minus")) {
        int v1 = Integer.parseInt(args[1]);
        int v2 = Integer.parseInt(args[2]);
        System.out.printf("%d - %d = %d\n", v1, v2, (v1 - v2));
      }

    }
  }
} // 아규먼트가 안만들어지면 빈배열이 만들어진다!! null이 아니라!!
