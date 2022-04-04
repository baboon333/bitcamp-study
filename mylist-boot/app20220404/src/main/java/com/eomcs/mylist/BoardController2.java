/*package com.eomcs.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController2 {

  // Board 객체 목록을 저장할 메모리를 준비한다. 
  ArrayList boardList = new ArrayList(); //ArrayList 설계도에 따라서 boardList를 만들어주렴


  @RequestMapping("/board/list")
  public Object list() {
    return ArrayList.toArray();
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {  // 보통 클래스는 대문자로 시작하고 메소드 이름은 소문자로! 변수명도 소문자로!

    board.setCreatedDate(new Date(System.currentTimeMillis()));  // new Date하고 ctrl+space 하면 이클립스에서 자동으로 import해준다! 맨 윗줄!
    ArrayList.add(board);
    return boardList.size;
  }

  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= boardList.size) {
      return "";
    }
    Board board = (Board) boardList.list[index];  //list가 object 배열이니! object가 상위 타입이므로 이걸 board 하위 타입에 담을 수 없다. 하위 클래스가 상위 클래스를 못 가리킨다. 그렇기 때문에 (Board)라고 해줘야 함.
    board.viewCount++;
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size) {  
      return 0;
    }
    Board old = (Board) boardList.list[index];  //boardList가 가리키는 거기 배열의 list 배열을 써라
    board.viewCount = old.viewCount;// 기존 값을 새 보드객체에 담아둬야 함. 조회수와 최초로 게시글을 올린 날짜
    board.createdDate = old.createdDate;
    return ArrayList.set(index, board) == null ? 0 : 1;  //update가 안됐다는 의미에서 클라이언트에게 0을 리턴해준다. 이렇게 알려줘야 서버 쪽에서 변경을 했는지 안했는지 알기 때문에! 
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size) {
      return 0;
    }
    return ArrayList.remove(boardList, index) == null ? 0 : 1;
  }
}
 */
