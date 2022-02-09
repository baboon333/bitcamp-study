// URL 클래스를 이용하여 HTTP 요청 수행하기
package com.eomcs.net.ex08;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    // URL 클래스를 이용하면 HTTP 프로토콜을 신경쓰지 않고
    // HTTP 요청을 수행할 수 있다.
    // 특히 HTTPS까지도 처리할 수 있다.
    // 따라서 직접 socket 프로그램을 짜지말고 url 클래스를 사용하라

    // => URL 주소를 검증하고 준비한다.
    URL url = new URL("https://www.weather.go.kr/w/index.do");

    // => 서버와 연결하고 HTTP 요청을 수행한다.
    // => 그런 후에 웹서버의 응답 데이터를 읽어들일 도구(openStream())를 준비한다.
    InputStream in = url.openStream();

    // => 서버가 보낸 데이터를 한 줄씩 읽기 위해 데코레이터를 붙인다. -> BufferedReader의 readline 메서드로 한줄씩 읽기 가능
    BufferedReader in2 = new BufferedReader(new InputStreamReader(in));

    while (true) {
      String str = in2.readLine();
      if (str == null)
        break;

      System.out.println(str);
    }

    in2.close();
    in.close();
  }

}


