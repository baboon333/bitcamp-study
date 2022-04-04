/*package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping; //@RequestMapping 이거 치면 자동으로 생성된다
import org.springframework.web.bind.annotation.RestController; //@RestController 이거 치면 자동으로 생성된다

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 인식한다.
public class ContactController {

  String[] contacts = new String[5];
  int size = 0; // 배열에 집어넣은 개수

  @RequestMapping("/contact/list") //요청과 이 메소드를 연결한다. 반드시 앞에 / 붙여줘야한다!!!
  public Object list() {
    String[] arr = new String[size];     //배열에 저장된 값만 복사할 새 배열을 만든다. 들어있는 값이 두개면 두개만 복사해주는거임
    for (int i =0; i < size; i++) {
      arr[i] = contacts[i]; // 전체 배열에서 값이 들어 있는 항목만 복사한다
    }
    return arr; //복사한 항목들을 리턴한다.
  }

  /*
  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    if (size == contacts.length) {     //배열이 꽉 찼다면,
      contacts = grow(); // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    contacts[size++] = createCSV(name, email, tel, company);  // add 호출이 들어올 때마다 size가 커진다.
    return size;
  }

  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {  //못찾으면 -1
      return "";
    }

    return contacts[index];  //찾으면 그 인덱스에 해당하는걸 리턴해주겠다!
  }

  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    int index = indexOf(email);
    if (index == -1) {  
      return 0;  //못바꿨다! 아무것도 하지마라
    }

    contacts[index] = createCSV(name, email, tel, company);  //찾으면 그 인덱스에 해당하는걸 리턴해주겠다!
    return 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    remove(index); // 메서드 이름으로 코드의 의미를 김작할 수 있다. 이것이 메서드로 분리하는 이유이다.
    return 1;
  }


  //기능: 입력 받은 파라미터 값을 가지고 CSV 형식으로 문자열을 만들어 준다.
  //
  String createCSV(String name, String email, String tel, String company) {  //메소드: 어떤 기능을 수행하는 코드를 묶어놓은 것 //자바는 리턴타입(String)을 꼭 지정해줘야하고 파라미터를 전부 써줘야 한다! //자바의 createCSV 함수를 흉내내서 쓰는거임. 이렇게 있는걸 흉내내서 써야 이해도를 높이니까!!
    return name + "," + email + "," + tel + "," + company;  
  } //한 사람의 연락처 정보를 문자열로 만드는 코드를 메서드로 분리한다.


  //기능: 
  //- 이메일로 연락처 정보를 찾는다.
  //- 찾은 연락처의 배열 인덱스를 리턴한다. 
  //
  int indexOf(String email) {   //이렇게 명확하게 그 기능에 해당하는 메소드 이름을 적어야 한다! //자바의 indexOf 함수를 흉내내서 쓰는거임. 이렇게 있는걸 흉내내서 써야 이해도를 높이니까!!
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) {
        return i;
      }
    }
    return -1;
  } 


  //기능:
  // - 배열에서 지정한 항목을 삭제한다.
  //
  String remove (int index) {      //자바의 remove 함수를 흉내내서 쓰는거임. 이렇게 있는걸 흉내내서 써야 이해도를 높이니까!!
    String old = contacts[index];  //자바의 remove 함수를 흉내내서 쓰는거니까 그 함수랑 비슷한 기능을 수행하게 하려고 나중을 위해서 삭제한 값을 리턴하도록 코드를 짠거임!!!
    for (int i = index + 1; i < size; i++) {
      contacts[i - 1] = contacts[index];   
    }
    size--; 
    return old;
  }

  // 기능:
  // - 배열의 크기를 늘린다.
  // - 기존 배열의 값을 복사해온다.
  //
  String[] grow() {
    String[] arr = new String[newLength()]; //새 길이의 배열을 만들고
    copy(contacts, arr);  //기존 배열의 값을 새 배열에 복사한다
    return arr; //새 배열을 리턴한다
  }

  // 기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  //
  int newLength() {  // 코드의 가독성을 위해 뺌. 속도는 느려지지만 그만큼 가독성이 중요하다.
    return contacts.length + (contacts.length >> 1);
  }

  // 기능:
  // - 배열을 복사한다.
  //
  void copy(String[] source, String[] target) {
    // 개발자가 잘못 사용할 것을 대비해서 다음 코드를 추가한다.
    // 즉 target 배열이 source 배열 보다 작을 경우 target 배열 크기만큼만 복사한다.
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < source.length; i++) {
      target[i] = source[i]; 
    }

  }

}*/




