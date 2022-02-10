package com.eomcs.oop.ex11.overview.step3;

public class MyQueue extends MyList {

  public void offer(Object obj) {
    this.add(obj);
  }

  public Object poll() {
    if (size == 0) {
      return null;
    }
    return remove(0);
  }

  @Override
  public Iterator iterator() {
    return new QueueIterator(this); // this는 마이큐객체이다. 따라서 이터레이터가 데이터를 꺼낼 때 마이큐에 있는 걸 꺼내겠지
  }
}











