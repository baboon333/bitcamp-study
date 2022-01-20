package com.eomcs.io.ex11.a;

public class Member {
  String name;
  int age;
  boolean gender; // true(여자), false(남자)

  @Override // Object 클래스에 있는걸 오버라이딩 함
  public String toString() {
    return "Member [name=" + name + ", age=" + age + ", gender=" + gender + "]";  // this.name에서 this가 생략된걸 잊지말아라 컴파일러가 자동으로 붙인 것! js는 생략불가. js는 컴파일 방식이 아니니! java는 가능! 
  }
}
