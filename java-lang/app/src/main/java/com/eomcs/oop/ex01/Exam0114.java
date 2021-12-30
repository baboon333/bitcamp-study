package com.eomcs.oop.ex01;

// # 클래스 사용 : 5) 메서드 활용 II
//
// 내가 객체를 직접 생성하지 않고 메서드를 통해서 생성하는게 훨씬 편하다!
public class Exam0114 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {

    // 클래스를 이용하면 성적 정보와 같은 여러 개의 값을 한 번에 리턴 받을 수 있다.
    Score s = createScore("홍길동", 100, 100, 100);  //아규먼트

    printScore(s);   //로컬변수가 사라지는거지 new로 만든 객체가 사라지는 거임!!! new 라는 명령으로 만들어지는 메모리는 모두 heap에 만들어지는데 JVM Stack에 만들어지는 것만 사라지는거고 heap에 만들어지는건 안사라짐.
  }

  static void printScore(Score s) {  //return 값이 없을 때는 void

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }

  // 클래스를 이용하면 성적 정보를 하나로 묶어 리턴할 수 있다.
  // - Score 인스턴스를 생성하여 리턴한다.
  // - 더 정확하게 표현하면, Score 인스턴스를 생성한 후 그 주소를 리턴한다.
  // 객체를 만들어주는 메서드: 팩토리 메서드
  static Score createScore(String name, int kor, int eng, int math) {  //여기 이 파라미터나 밑에 s나 둘다 로컬변수다! 메소드 호출이 끝나면 사라질 변수!! 로컬변수는 jvm stack에 만들어진다.   // static Score createScore : createScore는 Score 혹은 하위 객체를 리턴한다는 의미임.  //아규먼트를 받는 로컬변수가 파라미터 
    Score s = new Score();  //new 하면 Heap 메모리에 만들어진다.

    s.name = name;
    s.kor = kor;
    s.eng = eng;
    s.math = math;
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3;

    return s; // s에 저장된 인스턴스의 주소를 리턴한다.
    // 강사님! 로컬 변수는 메서드 호출이 끝난 다음에 삭제된다고 했는데
    // 위에서 생성한 s 변수도 삭제되고, 
    // 파라미터 name, kor, eng, math도 삭제되는게 아닌가요?
    // => 예 삭제됩니다.
    // => 모든 로컬 변수는 메서드 호출이 끝나면 스택 메모리에서 삭제됩니다.
    //
    // 하나 더요?
    // Score 인스턴스도 삭제되는게 아닌가요?
    // => 삭제되지 않습니다. 인스턴스는 힙(heap) 메모리에 생성됩니다.
    //    어떤 메서드에서 인스턴스를 생성하든지 간에 
    //    힙에 생성된 것은 메서드 호출이 끝나더라도 삭제되지 않습니다.
    //    오직 스택(stack) 메모리에 생성된 로컬 변수만이 삭제됩니다.
  }
}








