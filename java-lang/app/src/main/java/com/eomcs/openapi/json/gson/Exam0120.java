// JSON 문자열 --> 객체 : JSON 문자열을 해석하여 객체를 생성하기
package com.eomcs.openapi.json.gson;

import com.google.gson.Gson;

public class Exam0120 {
  public static void main(String[] args) {

    // 1) JSON 문자열 준비
    String jsonStr = "{\"no\":100,\"name\":\"홍길동\",\"email\":\"hong@test.com\",\"password\":\"1111\",\"photo\":\"hong.gif\",\"tel\":\"010-2222-1111\",\"registeredDate\":\"1월 24, 2022\"}";

    // 2) JSON 처리 객체 준비
    Gson gson = new Gson();

    // 3) JSON 문자열을 가지고 객체 만들기
    Member m = gson.fromJson(jsonStr, Member.class); // 두 번째 파라미터로 클래스 정보를 준다!! .class는 변수임!! 여기에 클래스 정보가 들어있음

    System.out.println(m);
  }
}





