//package com.eomcs.mylist;

/*@RestController // 클라이언트 요청을 처리하는 역할  // 일반 클래스가 아닌 클라이언트 요청에 응답하는 클래스다!
public class ContactController2 {

  // 인스턴스 변수(밖에 선언한 변수임)
  // => 모든 인스턴스 메서드가 공유한다.
  String[] contacts = new String[5]; //빈배열 준비
  int size = 0;

  @GetMapping("/contact/list")//클라이언트가 뭐라고 요청했을 때 이 메소드를 호출해라!
  public Object list() {
    String[] records = new String[size];
    for (int i = 0; i < size; i++) {
      records[i] = contacts[i];
    }
    return records;  //새 배열의 값을 리턴한다.
  }

  @GetMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    //아래 문장의 뜻: int temp = size  //size = size + 1  //contacts[temp]가 되는거임
    contacts[size++] = name + "," + email + "," + tel + "," + company;
    return size;
  }

  @GetMapping("/contact/get")
  public Object get(String email) {
    for (int i =0; i < size; i++) {             //js의 for of와 같은 것
      if (email.equals(contacts[i].split(",")[1])) {    //자바에서는 ==로 문자열 비교 못한다 대신 equals라는 메소드를 호출해서 써야 함.
        return contacts;
      }
    }
    return "";  //같은게 아무것도 없으면 빈 문자열을 return하겠다
  }

}*/
