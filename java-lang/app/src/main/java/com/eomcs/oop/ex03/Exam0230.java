// 인스턴스와 인스턴스 변수, 인스턴스 메서드 
package com.eomcs.oop.ex03;

public class Exam0230 {
  static class Calculator {
    // new 명령을 실행하면, 다음 변수 선언이 실행되어 Heap에 메모리를 만든다.
    int result;   // 정수 값을 담을 4바이트 메모리를 준비하라! 그 메모리의 이름을 result로 하자!  // 모든 변수선언은 명령문이다!
    // 로컬 변수와 다르게 인스턴스 변수와 스태틱 변수는 기본 값으로 초기화된다. 0!!

    // 주의!
    // => 이름에 인스턴스가 붙었다고 해서 인스턴스 메서드는 Heap에 만들어지는 것이 아니다!
    // => 클래스의 모든 코드는 Method Area 영역에 로딩 된다.
    public void plus(int value) {  //인스턴스 메서드는 기본적으로 내장 변수 this가 만들어진다.
      this.result += value;   //this에 저장된 주소로 찾아가서 그 인스턴스의 result 변수 값을 value와 합쳐서 다시 result 변수에 담아라!
    }
    public void minus(int value) {
      this.result -= value;
    }
  }

  public static void main(String[] args) {
    // Heap에 인스턴스 변수가 생성된다.
    // 인스턴스 메서드가 생성되는 것이 아니다!
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    // 인스턴스 메서드든 클래스 메서드든 모두 Method Area 영역에 올라간다.
    // 그리고 인스턴스를 가지고 그 메서드를 호출하는 것이다.

    // c1이 가리키는 인스턴스를 가지고 Method Area에 있는 plus()를 호출한다.
    c1.plus(123);  // this에 c1에 있는 주소값이 들어간다. value에는 123이 들어간다.
    // 메서드 호출이 끝나면 로컬 변수가 사라진다. 

    // c2가 가리키는 인스턴스를 가지고 Method Area에 있는 plus()를 호출한다.
    c2.plus(30);
  }
}







