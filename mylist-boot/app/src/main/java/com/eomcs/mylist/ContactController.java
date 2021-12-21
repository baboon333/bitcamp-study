package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
public class ContactController {

  Contact[] contacts = new Contact[5];
  int size = 0;

  //연락처 목록은 Contact 클래스의 배열로 변경한다.
  @RequestMapping("/contact/list")
  public Object list() {
    Contact[] arr = new Contact[size];
    for (int i =0; i < size; i++) {
      arr[i] = contacts[i];
    }
    return arr;
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {   //contact 레퍼런스 변수를 스프링부트가 넘겨줌. //스프링부트는 add()를 호출하기 전에 그 파라미터인 contact 인스턴스를 만든 후에 값을 저장한다. 그리고 그 주소를 넘겨주는거임
    System.out.println(contact); //Contact.java에 @override 덕분에 이렇게 간단하게 쓸 수 있음. //(contact.toString()) to.String() 생략가능! 인스턴스의 주소만 주면 된다.

    if (size == contacts.length) {     //배열이 꽉 찼다면,
      contacts = grow(); // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    contacts[size++] = contact;

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
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {  
      return 0;  //못바꿨다! 아무것도 하지마라
    }

    contacts[index] = contact;  //찾으면 그 인덱스에 해당하는걸 리턴해주겠다!
    return 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    remove(index); // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
    return 1;
  }

  //기능: 
  //- 이메일로 연락처 정보를 찾는다.
  //- 찾은 연락처의 배열 인덱스를 리턴한다. 
  //
  int indexOf(String email) {   //이렇게 명확하게 그 기능에 해당하는 메소드 이름을 적어야 한다! //자바의 indexOf 함수를 흉내내서 쓰는거임. 이렇게 있는걸 흉내내서 써야 이해도를 높이니까!!
    for (int i = 0; i < size; i++) {
      Contact contact = contacts[i]; //각 주소들
      if (contact.email.equals(email)) {  //파라미터(email)과 같으면
        return i;
      }
    }
    return -1;
  } 

  //기능:
  // - 배열에서 지정한 항목을 삭제한다.
  //
  Contact remove (int index) {      //자바의 remove 함수를 흉내내서 쓰는거임. 이렇게 있는걸 흉내내서 써야 이해도를 높이니까!!
    Contact old = contacts[index];  //자바의 remove 함수를 흉내내서 쓰는거니까 그 함수랑 비슷한 기능을 수행하게 하려고 나중을 위해서 삭제한 값을 리턴하도록 코드를 짠거임!!!
    for (int i = index + 1; i < size; i++) {
      contacts[i - 1] = contacts[i];   
    }
    size--; 
    return old;
  }

  // 기능:
  // - 배열의 크기를 늘린다.
  // - 기존 배열의 값을 복사해온다.
  //

  Contact[] grow() {
    Contact[] arr = new Contact[newLength()]; //contact 인스턴스 배열이 아니라 레퍼런스 배열이다!!!
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
  void copy(Contact[] source, Contact[] target) {
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
}




