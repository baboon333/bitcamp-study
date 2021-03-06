// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;


public class Exam0530 {

  static class MyCalculator {
    public static int plus(int a, int b) {
      return a + b;
    }

    public static int minus(int a, int b) {
      return a - b;
    }

    public static int multiple(int a, int b) {
      return a * b;
    }

    public static int divide(int a, int b) {
      return a / b;
    }
  }

  interface Calculator1 {
    double compute(int a, int b);
  }

  interface Calculator2 {
    float compute(int a, int b);
  }

  interface Calculator3 {
    short compute(int a, int b);
  }

  interface Calculator4 {
    void compute(int a, int b);
  }

  interface Calculator5 {
    Object compute(int a, int b); // plus의 리턴 값인 int를 Object로 자동으로 형변환하기 때문에 가능(오토박싱)
  }

  interface Calculator6 {
    String compute(int a, int b); // int를 String으로 못바꾸기 때문에 불가
  }

  public static void main(String[] args) {

    // 리턴 타입 int ===> double
    Calculator1 c1 = MyCalculator::plus; // OK! plus는 return 타입이 int이다. 근데 int가 double에 속하니 가능한 것
    // 위 문장은 다음 문장과 같다.
    //    Calculator1 c1 = new Calculator1() {
    //      @Override
    //      public double compute(int a, int b) {
    //        return MyCalculator.plus(a, b);
    //      }
    //    };
    System.out.println(c1.compute(100, 200));

    // 리턴 타입 int ===> float
    Calculator2 c2 = MyCalculator::plus; // OK! plus는 int를 리턴하는데 compute는 float을 리턴하는 메서드를 원하므로 상관없다.
    System.out.println(c2.compute(100, 200));



    // 리턴 타입 int ===> short
    //    Calculator3 c3 = MyCalculator::plus; // 컴파일 오류! plus는 int를 리턴하는데 compute가 int보다 작은 short를 리턴하니 안된다! short보다 더 큰 수를 리턴하니 불가능한 것이다.
    // 위 문장은 다음과 같다.
    //    Calculator3 c3 = new Calculator3() {
    //      @Override
    //      public short compute(int a, int b) {
    //        return MyCalculator.plus(a, b); // 컴파일 오류!
    //      }
    //    };


    // 리턴 타입 int ===> void
    Calculator4 c4 = MyCalculator::plus; // OK! 리턴한걸 버리면 되기 때문에 가능하다.
    // 위 문장은 다음과 같다.
    //    Calculator4 c4 = new Calculator4() {
    //      @Override
    //      public void compute(int a, int b) {
    //        MyCalculator.plus(a, b); // OK!
    //      }
    //    };
    c4.compute(100, 200); // plus() 메서드의 리턴 값은 무시한다.

    // 리턴 타입 int ===> Object
    Calculator5 c5 = MyCalculator::plus; // OK! // Object는 오토박싱때문에 가능하다!
    // 위 문장은 다음과 같다.
    //    Calculator5 c5 = new Calculator5() {
    //      @Override
    //      public Object compute(int a, int b) {
    //        return MyCalculator.plus(a, b); // OK! 
    //        //이유? plus()가 리턴한 int 값이 오토박싱 되기 때문이다.
    //      }
    //    };
    System.out.println(c5.compute(100, 200));

    // 리턴 타입 int ===> String
    //    Calculator6 c6 = MyCalculator::plus; // 컴파일 오류! int를 string으로 바꾸는건 오토박싱과 상관없다. 불가능하다.
    // 위 문장은 다음과 같다.
    //    Calculator6 c6 = new Calculator6() {
    //      @Override
    //      public String compute(int a, int b) {
    //        return MyCalculator.plus(a, b); // 컴파일 오류!
    //      }
    //    };


    // => 메서드 레퍼런스를 지정할 때 리턴 타입의 규칙:
    // 1) 같은 리턴 타입
    // 2) 암시적 형변환 가능한 타입
    // 3) auto-boxing 가능한 타입
    // 4) void
    // 결론,
    // 메서드 레퍼런스가 가리키는 실제 메서드를 호출한 후
    // 그 메서드가 리턴한 값이
    // 인터페이스에 정의된 메서드의 리턴 값으로 사용할 수 있다면
    // 문제가 없다.
    //
  }
}


