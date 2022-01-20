// java.io.Serializable 처럼 사용되는 인터페이스 : java.lang.Cloneable 인터페이스
package com.eomcs.io.ex11.b;

public class Exam0231 {

  static class Score { // 클래스 만들 때 수퍼 클래스 안붙여주면 extends java.lang.Object가 붙는다!
    String name;

    // 복제 기능을 수행하려면 Object에 있는 clone()을 오버라이딩 해야 한다.
    @Override
    public Score clone() throws CloneNotSupportedException {  // clone()은 protected인데 오버라이드할 때 접근 범위를 넓히는 건 괜찮으니 public으로 해준다. 리턴 타입을 Object 에서 Score로 바꿔준다. 빵 중에 하나인 소보로로 리턴하는 건 가능하니! 리턴타입을 이것의 서브 타입으로 바꿔도 된다.
      return (Score) super.clone();
    }
  }

  public static void main(String[] args) throws Exception {

    Score obj = new Score();

    System.out.println(obj instanceof Cloneable);

    Score copy = obj.clone(); // 런타임(run-time) 오류!
    // Object에서 상속 받은 clone()을 호출하려면
    // 해당 클래스에 대해 복제 기능을 활성화해야 한다. -> 근데 Score 객체가 복제 기능이 없다!
    // 방법? java.lang.Cloneable 인터페이스를 구현하라!
  }

}
