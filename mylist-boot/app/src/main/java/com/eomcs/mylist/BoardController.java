package com.eomcs.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BoardController {

  @RequestMapping("/board/list")
  public Object list() {
    return ArrayList3.toArray(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {  // 보통 클래스는 대문자로 시작하고 메소드 이름은 소문자로! 변수명도 소문자로!

    board.setCreatedDate(new Date(System.currentTimeMillis()));  // new Date하고 ctrl+space 하면 이클립스에서 자동으로 import해준다! 맨 윗줄!
    ArrayList3.add(board);
    return ArrayList3.size;
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= ArrayList3.size) {
      return "";
    }
    Board board = ArrayList3.list[index];  //list가 object 배열이니! object가 상위 타입이므로 이걸 board 하위 타입에 담을 수 없다. 하위 클래스가 상위 클래스를 못 가리킨다.
    return ArrayList3.list[index];
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return 0;
    }

    return ArrayList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= ArrayList3.size) {
      return 0;
    }

    ArrayList.remove(index);
    return 1;
  }
}




