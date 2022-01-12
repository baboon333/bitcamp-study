// final 사용법: 상수 필드 만들기
package com.eomcs.oop.ex06.e;

class F {
  // 상수 필드는 인스턴스 마다 개별적으로 관리하지 않기 때문에
  // 보통 스태틱 필드(클래스 필드)로 만든다.  // 인스턴스를 만들 때마다 생성하지말고 클래스가 로딩될 때 한번만 만들어지게!
  // 공개할 경우 public 으로 선언한다.
  //
  public static final int v1 = 100;

  // 스태틱 상수 필드는 스태틱 블록에서 초기화시킬 수 있다.
  public static final int v2;
  static {  // v1 = 100;이건 어차피 여기 안으로 들어오지만 코드는 쓸데없이 이렇게 쓰지말고 위에다 저렇게 한번에 선언과 초기화시켜~
    v2 = 200;
  }

}

public final class Exam0340 {
  public static void main(String[] args) {
    System.out.println(F.v1);
    System.out.println(F.v2);
  }
}
