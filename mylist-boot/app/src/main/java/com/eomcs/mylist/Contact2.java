package com.eomcs.mylist;

//1단계 - 연락처 정보를 한 단위로 묶어서 다룰 새 데이터 타입을 정의한다.
public class Contact2 {
  String name;
  String email;
  String tel;
  String company;

  @Override
  public String toString() { //설계도에 따라 작성된 변수들을 하나의 문자열로 담아서 리턴해주는 유용한 함수(source/ generate toStrint에서)
    return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + ", company=" + company
        + "]";
  }
  //getter/setter (우클릭 source/ generate getters and setters에서!! 모든 변수에 대해서 만들어라.)

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

}  // 이 네개의 변수를 묶어서 다루겠다.

//연락처 목록은 Contact 클래스의 배열로 변경한다

