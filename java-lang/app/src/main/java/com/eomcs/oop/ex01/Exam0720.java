package com.eomcs.oop.ex01;

// # import : 사용 후
//
// - import 명령은 package 명령 다음에 와야 한다.    //항상 package 명령이 제일 먼저 와야 한다! 
// - 클래스 선언 전에 와야 한다.
import com.eomcs.oop.ex01.sub.Y2;   //y2 클래스는 이 패키지 밑에 있어~ 그럼 컴파일러가 나 대신 이 경로를 자동으로 붙여줌!!

public class Exam0720 {
  public static void main(String[] args) {

    // 다른 패키지의 클래스를 사용할 때 마다
    // 패키지명을 적는다면 너무 코드가 너무 길어진다.
    //
    // 이를 해결하기 위해 자바는 import 라는 명령을 제공한다.
    // 클래스를 사용하기 전에 미리 해당 클래스가 어느 패키지에 있는지 지정하는 것이다.
    // 문법:
    //      import 패키지명.클래스명;
    //
    Y2 obj;    //컴파일러가 위 import의 경로를 컴파일 할 때 자동으로 붙여줌!!
    obj = new Y2();
  }
}
