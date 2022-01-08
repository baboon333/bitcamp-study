/*package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;

@RestController 
public class ContactController {

  // Contact 객체 목록을 저장할 메모리 준비
  // => Object[] list = new Object[5];
  // => int size = 0;
  ArrayList contactList;  // 인스턴스 변수 = 초기화 문장

  public ContactController() throws Exception { //throws Exception 이거는 나중에 설명!
    contactList = new ArrayList();
    System.out.println("ContactController() 호출됨!");

    FileReader in = new FileReader("contacts.csv");  // 파일의 경로를 주라

    StringBuilder buf = new StringBuilder();  // 버퍼 생성
    int c;  //한문자씩 읽는거임  c: character 줄여서 이렇게 잘 말함!
    while (true) {  // true이니 무한으로 반복

      c = in.read();  // 파일에서 한 문자를 읽는다.

      if (c == -1)  // 더이상 파일에서 읽을 문자가 없다면 반복문을 종료한다. (파일의 데이터를 이미 다 읽었으면 -1이 나온다(read() 설명 보면 나온다)! 그리고 if문에 의해 while문이 종료된다!)
        break;

      if (c == '\n') {  //만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact 객체에 담는다.
        contactList.add(Contact.valueOf(buf.toString())); // 파일에서 읽은 데이터를 담을 객체를 준비한다.
        buf.setLength(0); // 다음 데이터를 읽기 위해 buffer를 초기화시킨다. 

      } else { // 문자를 읽을 때 마다 버퍼에 임시 보관한다.  // 줄바꿈이 아니면! csv파일에서 그 한줄은 줄바꿈이 없잖아! 버퍼에 한줄씩 잘라내어 객체에 담아 저장하는 것!
        buf.append((char) c);  // buffer에 쌓아놔!  //  (char) c : 문자에 대한 고유 번호야!라고 알려줘야 함
      }
    }

    in.close();
  }


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
  }*/