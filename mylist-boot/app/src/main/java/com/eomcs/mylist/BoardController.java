package com.eomcs.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BoardController {

  // Board 객체 목록을 저장할 메모리를 준비한다.
  ArrayList boardList = new ArrayList();

  @RequestMapping("/board/list")
  public Object list() {
    return boardList.toArray();  // 인스턴스 메소드는 그 메소드가 사용할 주소를 이렇게 앞쪽에서 넘겨주고 ArrayList에서는 this 빌트인 변수를 사용한다.
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {  //ArraylIST 메서드를 호출할 때 인스턴스 주소를 파라미터로 넘기지 않는다!
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardList.add(board);
    return boardList.size;
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= boardList.size) {
      return "";
    }
    Board board = (Board) boardList.list[index];
    board.viewCount++; 
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size) {
      return 0;
    }

    Board old = (Board) boardList.list[index];
    board.viewCount = old.viewCount;
    board.createdDate = old.createdDate;

    return boardList.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size) {
      return 0;
    }
    return boardList.remove(index) == null ? 0 : 1;
  }
}