// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!(String 클래스)
package com.eomcs.oop.ex04;

public class Exam0111 {  //디버그 모드로 확인해봐!

  public static void main(String[] args) throws Exception {
    // 생성자를 호출하여 문자열 인스턴스를 초기화시킨다.

    String s0 = new String(); // default constructor 호출  // String 클래스에 ctrl+ 클릭해서 들어가보면 변수 value(문자열)가 byte[]임! java8까지는 char[]였는데 byte[]로 바뀜! 무튼 들어가보면 value에 빈 문자열을 집어넣으니 빈문자열이 출력된다!
    System.out.println(s0);
    System.out.println("------------------------------------");

    // => 문자열 리터럴을 사용하여 String 인스턴스를 초기화시키기.
    String s1 = new String("HelloABCabc012가각간"); // String(스트링 리터럴) 생성자를 호출하여 인스턴스 초기화  // String(String original)  // 문자열을 주면 문자열을 담는 생성자
    System.out.println(s1);
    System.out.println("------------------------------------");
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html  -> java11 api ->  java.base / java.lang / string

    // => char[] 을 사용하여 String 인스턴스 초기화시키기.
    char[] chars = new char[] {'H', 'e', 'l', 'l', 'o'};
    String s2 = new String(chars); // String(char[]) 생성자를 호출하여 인스턴스 초기화  // 캐릭터 배열을 주면 그 값을 가지고 String 인스턴스의 값을 초기화시키는! // 만약 우리가 문자열이 들어있는 char 배열을 갖고 있다면 char 배열을 받는 string 생성자를 호출하면 되는 것이다!!!!
    System.out.println(s2);
    System.out.println("------------------------------------");

    s2 = new String(chars, 1, 3); // String(char[], offset, count) 생성자를 호출하여 인스턴스 초기화  // 몇 번째 몇개를 꺼내와서 초기화시킬건지!
    System.out.println(s2);
    System.out.println("------------------------------------");

    // => 바이트 배열을 가지고 String 인스턴스 초기화시키기
    byte[] bytes = {  // 아예 바이트 배열에 그 문자에 해당하는 바이트 코드를 작성하여 넘기기!
        (byte)0x48, // H 
        (byte)0x65, // e
        (byte)0x6c, // l
        (byte)0x6c, // l
        (byte)0x6f  // o 
    };
    String s3 = new String(bytes); // String(byte[]) 생성자를 호출하여 인스턴스 초기화

    System.out.printf("%s, %s, %s\n", s1, s2, s3);
  }
}

// 생성자의 활용
// => 인스턴스 변수를 초기화시키기 위해 여러 개의 생성자를 만들어 제공할 수 있다.
// => 자신에게 맞는 적절한 생성자를 호출하여 인스턴스를 초기화시킨 후 사용하면 된다. 















