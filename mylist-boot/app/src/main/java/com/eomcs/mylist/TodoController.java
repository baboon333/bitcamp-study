package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

  @RequestMapping("/todo/list")
  public Object list() {
    return ArrayList2.toArray();
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    ArrayList2.add(todo);
    return ArrayList2.size;
  }

  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if (index < 0 || index >= ArrayList2.size) {
      return 0;
    }

    return ArrayList2.set(index, todo) == null ? 0 : 1;  //update가 안됐다는 의미에서 클라이언트에게 0을 리턴해준다. 이렇게 알려줘야 서버 쪽에서 변경을 했는지 안했는지 알기 때문에! 
  }

  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= ArrayList2.size) {
      return 0;  // 무효한 인덱스라면 설정못했다는 의미로 1을 리턴함  // 인덱스가 무효해서 설정하지 못했다.
    }

    ((Todo) ArrayList2.list[index]).done = done;
    return 1; // 인덱스번째 done을 위의 done으로 값을 설정한다. 1이라는 것은 설정했다! // 해당 항목의 상태를 변경했다.
  }

  @RequestMapping("/todo/delete")
  public Object delete(int index) {
    if (index < 0 || index >= ArrayList2.size) {
      return 0;
    }

    ArrayList2.remove(index);
    return 1;
  }
}
