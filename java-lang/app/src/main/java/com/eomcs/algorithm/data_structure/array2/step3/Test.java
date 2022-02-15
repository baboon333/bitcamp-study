package com.eomcs.algorithm.data_structure.array2.step3;

import com.eomcs.algorithm.data_structure.array2.Score;

public class Test {

  public static void main(String[] args) {
    ArrayList<Score> list = new ArrayList<Score>(); // ArrayList야 항목 타입으로 Score를 쓸거야! <Score>를 선언하기 전에는 get()의 리턴타입은 Object였다! 마우스 호버해서 확인해봐
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("임꺽정", 90, 90, 90));
    list.add(new Score("유관순", 80, 80, 80));
    list.add(new Score("안중근", 70, 70, 70));
    list.add(new Score("윤봉길", 80, 90, 100));

    for (int i = 0; i < list.size(); i++) {
      // 불편1 해결!
      // => 목록을 생성할 때 목록에서 다룰 항목의 타입을 Score로 선언한다.
      // => 그러면 get() 메서드의 리턴 타입은 Score가 된다.
      // => 따라서 따로 형변환 할 필요가 없다.
      //
      Score s = list.get(i); // ArrayList의 get()를 보면 return 타입이 Object이기 때문에! 사실은 get()가 리턴하는건 Score 객체가 맞으니까 컴파일러에게 알려줘야 한다.
      System.out.printf("%s: %d %f\n", s.name, s.sum, s.aver);
    }


  }

}
