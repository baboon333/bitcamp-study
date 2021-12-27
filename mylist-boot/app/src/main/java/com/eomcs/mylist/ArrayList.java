package com.eomcs.mylist;

public class ArrayList {
  static Contact[] contacts = new Contact[5];
  static int size = 0;

  //기능: 
  //- 이메일로 연락처 정보를 찾는다.
  //- 찾은 연락처의 배열 인덱스를 리턴한다. 
  //
  static int indexOf(String email) {   //이렇게 명확하게 그 기능에 해당하는 메소드 이름을 적어야 한다! //자바의 indexOf 함수를 흉내내서 쓰는거임. 이렇게 있는걸 흉내내서 써야 이해도를 높이니까!!
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
  static Contact remove (int index) {      //자바의 remove 함수를 흉내내서 쓰는거임. 이렇게 있는걸 흉내내서 써야 이해도를 높이니까!!
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
  static Contact[] grow() {
    Contact[] arr = new Contact[newLength()]; //contact 인스턴스 배열이 아니라 레퍼런스 배열이다!!!
    copy(contacts, arr);  //기존 배열의 값을 새 배열에 복사한다
    return arr; //새 배열을 리턴한다
  }

  // 기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  //
  static int newLength() {  // 코드의 가독성을 위해 뺌. 속도는 느려지지만 그만큼 가독성이 중요하다.
    return contacts.length + (contacts.length >> 1);
  }

  // 기능:
  // - 배열을 복사한다.
  //
  static void copy(Contact[] source, Contact[] target) {
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


  // 기능:
  // - 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한다.
  //

  static Contact[] toArray() {
    Contact[] arr = new Contact[size];
    for (int i =0; i < size; i++) {
      arr[i] = contacts[i];
    }
    return arr;
  }

  // 기능:
  // - 배열에 항목을 추가한다.
  // - 배열이 꽉 찼으면 배열의 크기를 늘린다.
  static void add(Contact contact) {
    if (size == contacts.length) {     //배열이 꽉 찼다면,
      contacts = grow(); // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    contacts[size++] = contact;
  }

  // 기능:
  // - 배열의 특정 위치에 값을 변경한다.
  // - 리턴 값:
  //    - 변경하기 전에 저장되어 있던 값이다.  
  static Contact set(int index, Contact contact) {
    if (index < 0 || index >= size) { // 값이 저장된 위차가 무효한 인덱스라면
      return null;
    }
    Contact old = contacts[index];  // 기존 값을 old에 저장하고
    contacts[index] = contact;      // 새 값을 저장한다.
    return old;                     // 기존 값을 리턴한다
  }
}
// 배열을 다루는 메서드를 별도의 클래스로 분류한다. 
// ContactController에서 배열을 다루는 메서드를 가져온다. 
