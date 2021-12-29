package com.eomcs.mylist;

public class ArrayList {
  static Object[] contacts = new Object[5];
  static int size = 0;

  static void add(Object obj) {  // add라는 메서드가 호출될 때 넘어오는 모든 객체를 다 받겠다. 
    if (size == list.length) {     //배열이 꽉 찼다면,
      list = grow(); // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    list[size++] = obj;
  }

  static Object[] grow() {
    Object[] arr = new Object[newLength()];
    copy(list, arr);  //오리지널 배열을 새로운 배열로 복사
    return arr;
  }

  static int newLength() {
    return list.length + (list.length >> 1);  //기존 배열에서 50% 증가한 길이
  }

  static void copy(Object[] source, Object[] target) {
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < source.length; i++) {
      target[i] = source[i]; 
    }
  }

  static Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i =0; i < size; i++) {
      arr[i] = list[i];
    }
    return arr;
  }

  static Object remove (int index) {  //이 안을 손코딩하세요! 이런게 코테로 나옴
    Object old = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i - 1] = list[i];   
    }
    size--; 
    return old;
  }

  static Object set(int index, Object contact) {
    if (index < 0 || index >= size) {
      return null;
    }
    Object old = list[index]; 
    list[index] = obj;    
    return old;                     
  }
}



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
