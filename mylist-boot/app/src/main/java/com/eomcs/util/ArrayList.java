package com.eomcs.util;

public class ArrayList implements java.io.Serializable {

  // 인스턴스 필드(변수)
  // => 인스턴스 필드는 new 명령을 통해 생성한다.
  Object[] list = new Object[5];
  int size = 0;


  // 인스턴스 주소를 앞쪽에서 받으려면 static 키워드를 붙이면 안된다.
  // 즉 non-static 메서드로 정의해야 한다.  //static 지우기
  // 그리고 메서드가 호출될 때 받은 인스턴스를 사용하려면 내장 변수 this를 이용해야 한다.
  public void add(Object obj) {
    if (this.size == this.list.length) { 
      this.list = grow();
    }
    this.list[this.size++] = obj;
  }

  Object[] grow() {  //얘는 내부적으로 쓰는거니 공개(public) 안해줘도 된다. 밖에서 사용할 것만 public으로!
    Object[] arr = new Object[this.newLength()];
    this.copy(arr);
    return arr;
  }

  int newLength() {
    return this.list.length + (this.list.length >> 1);
  }

  void copy(Object[] target) {  //this는 변수이다! 그 메소드를 호출할 때 넘겨준 값이 들어있다. 모든 non-static 메서드가 this를 갖고 있다. 
    int length = this.list.length;
    if (target.length < list.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = this.list[i];
    }
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.size]; 
    for (int i = 0; i < this.size; i++) { 
      arr[i] = this.list[i]; 
    }
    return arr; 
  }

  public Object remove(int index) {
    if (index < 0 || index >= this.size) { // 값이 저장된 위치가 무효한 인덱스라면 
      return null;
    }
    Object old = this.list[index];
    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.size--;
    return old;
  }

  public Object set(int index, Object obj) {
    if (index < 0 || index >= this.size) { // 값이 저장된 위치가 무효한 인덱스라면 
      return null;
    }
    Object old = this.list[index];
    this.list[index] = obj;
    return old;
  }

  public int size() {  //우클릭/source/generate getter setter/ get size만 생성함. 그리고 size()로 바꿈. 기존에서 자바에서 제공하는 메소드 ArrayList를 모방해서 하고 있는건데 거기서 size를 리턴해주는 메소드를 그냥 size()라고 해서 따라한거임.
    return this.size;  //size라는 메소드를 호출할 때 주소가 넘어오니까 그 주소에 있는 size를 넘겨주겠다.  // this 생략 가능하지만 안붙여도 되는게 아니라 생략하도록 허락해준거임! 컴파일러가 컴파일할 때 자동으로 this가 붙어짐!! 다른 개발자가 작성안해놨으면 작성 안해도 된게 아니라 생략한거라는걸 알아둬!
  }

  public Object get(int index) {
    return this.list[index];
  }

}