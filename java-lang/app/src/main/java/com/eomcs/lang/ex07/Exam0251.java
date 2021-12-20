package com.eomcs.lang.ex07;

// # 메서드 : 가변 파라미터
//
public class Exam0251 {

  // 가변 파라미터에 배열을 넘길 경우
  // 기존 배열을 그대로 사용할까? 아니면 파라미터로 받은 배열을 복제해서 사용할까?
  // => 가변 파라미터에 배열을 넘길 경우 그 배열을 그대로 받아 사용한다.
  static void hello(String... names) {
    for (int i = 0; i < names.length; i++) {
      names[i] += "xxx";
      System.out.printf("%s님 반갑습니다.\n", names[i]);
    }
  }

  public static void main(String[] args) {

    hello(); // 이 경우 names 배열의 개수는 0이다.
    System.out.println("-------------------");

    hello("홍길동"); // 이 경우 names 배열의 개수는 1이다.
    System.out.println("-------------------");

    hello("홍길동", "임꺽정", "유관순"); // 이 경우 names 배열의 개수는 3이다.
    System.out.println("-------------------");

    // 가변 파라미터 자리에 배열을 직접 넣어도 된다.  //낱개를 4개 준거랑 똑같음
    String[] arr = {"김구", "안중근", "윤봉길", "유관순"};

    // 가변 파라미터에 배열을 넘길 경우
    hello(arr);
    System.out.println("-------------------");

    for (String value : arr) {  //실행해서 확인해봐! xxx가 붙어있으니 기존 배열이 바뀐걸 알 수 있다
      System.out.println(value);
    }
  }
}
