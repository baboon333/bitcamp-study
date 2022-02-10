package com.eomcs.oop.ex11.overview.step5;

public class Test3 {
  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.offer("홍길동");
    myQueue.offer("임꺽정");
    myQueue.offer("유관순");
    myQueue.offer("안중근");
    myQueue.offer("윤봉길");
    myQueue.offer("김구");

    Iterator iterator = myQueue.iterator(); // 마이큐에 대해서 이터레이터를 호출한다.인스턴스 메서드는 그 주소를 파라미터가 아니라 앞부분에 주니까 myQue 주소가 넘어가는거임 따라서 이 안의 함수에 this에 이 주소가 들어가는 것이다. 
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}