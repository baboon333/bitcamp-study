/*package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

@RestController 
public class TodoController1 {

  // Todo 객체 목록을 저장할 메모리를 준비한다.
  ArrayList todoList;

  public TodoController1() throws Exception {
    todoList = new ArrayList();
    System.out.println("TodoController() 호출됨!");

    FileReader in = new FileReader("todos.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while (true) {

      c = in.read();

      if (c == -1)
        break;

      if (c == '\n') {
        todoList.add(Todo.valueOf(buf.toString()));
        buf.setLength(0);

      } else {
        buf.append((char) c);
      }
    }

    in.close();
  }

  @RequestMapping("/todo/list")
  public Object list() {
    return todoList.toArray(); 
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    todoList.add(todo);
    return todoList.size();
  }

  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    }

    Todo old = (Todo) todoList.get(index);  // 기존의 체크 정보는 그대로 가져가야 한다.
    todo.setDone(old.isDone());  //값을 꺼낼 때는 GET() 값을 설정할 때는 SET()  //근데 TRUE/FALSE일 때는 get 대신 isdone!!!

    return todoList.set(index, todo) == null ? 0 : 1;
  }

  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= todoList.size()) {
      return 0;  // 인덱스가 무효해서 설정하지 못했다.
    }

    ((Todo) todoList.get(index)).setDone(done);
    return 1; // 해당 항목의 상태를 변경했다.
  }

  @RequestMapping("/todo/delete")
  public Object delete(int index) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    }

    todoList.remove(index);
    return 1;
  }

  @RequestMapping("/todo/save")
  public Object save() throws Exception {
    FileWriter out = new FileWriter("todos.csv");

    Object[] arr = todoList.toArray();
    for (Object obj : arr) {
      Todo todo = (Todo) obj;
      out.write(todo.toCsvString() + "\n");
    }


    out.close();
    return arr.length;
  }
}
 */