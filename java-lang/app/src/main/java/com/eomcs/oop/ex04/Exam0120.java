// 생성자 활용 예 - java.util.Date 클래스의 생성자
package com.eomcs.oop.ex04;

import java.util.Date;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    // java.util.Date 클래스는 날짜 데이터를 다루는 클래스이다.
    // => 이 클래스에는 날짜 데이터를 다룰 수 있는 다양한 변수와 메서드 등이 들어 있다.

    // Date() 기본 생성자는 메모리를 오늘 날짜 값으로 초기화시킨다.
    Date d1 = new Date();  // kst : 한국날짜/시간이다!
    System.out.println(d1);

    // 년, 월, 일 값으로 날짜 인스턴스를 초기화시킨다.
    Date d2 = new Date(122, 4, 3);  // 이제는 다른걸로 대체되어서 쓰지말라고 권고하는 것(유효하지 않은 생성자 deprecated)! 생성자 메뉴얼에서 찾아봐!
    // Parameters:
    // year - the year minus 1900.
    // month - the month between 0-11.
    // date - the day of the month between 1-31.
    // 시간 안알려주면 이렇게 무조건 0시0초!
    System.out.println(d2);

    // 1970년 1월 1일 0시 0분 0초부터 측정된 밀리초를 가지고 
    // 날짜 인스턴스(객체=메모리) 초기화시킨다.
    Date d3 = new Date(1000L * 60 * 60 * 24 * 365 * 50);  //1970년 1월 1일 0시 0분 0초 이때부터 50년이 지난!
    System.out.println(d3);
  }
}














