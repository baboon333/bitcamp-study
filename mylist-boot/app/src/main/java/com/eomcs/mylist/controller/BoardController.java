package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {

  // Board 객체 목록을 저장할 메모리를 준비한다.
  ArrayList boardList = new ArrayList();

  public BoardController() {
    // 컴파일 하면 이렇게 boardList = new ArrayList(); 삽입된다. 따라서 위에서는 그냥 ArrayList boardList; 이렇게만 해줘도 된다! // 인스턴스 필드 초기화 문장은 생성자의 앞 부분에 삽입된다.
    System.out.println("BoardController() 호출됨!");
  }

  @RequestMapping("/board/list")
  public Object list() {
    return boardList.toArray();  // 인스턴스 메소드는 그 메소드가 사용할 주소를 이렇게 앞쪽에서 넘겨주고 ArrayList에서는 this 빌트인 변수를 사용한다.
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {  //ArraylIST 메서드를 호출할 때 인스턴스 주소를 파라미터로 넘기지 않는다!
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardList.add(board);
    return boardList.size();
  }

  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= boardList.size()) {
      return "";
    }
    Board board = (Board) boardList.get(index);
    board.setViewCount(board.getViewCount() + 1);  //getViewCount() : 대신 값을 꺼내주는 메소드를 통해!  // setViewCount: 값을 저장할 때는 setter 메소드를 이용하라

    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }

    Board old = (Board) boardList.get(index);
    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());

    return boardList.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }
    return boardList.remove(index) == null ? 0 : 1;
  }
}