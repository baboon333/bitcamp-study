package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    System.out.println("BookController() 호출됨!");

    try{
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.ser2"))); // 주 객체에 데코레이터 객체를 연결 // 실무에서는 이렇게 안에다 바로 써준다

      // 1) 객체가 각각 따로 serialize 되었을 경우, 다음과 같이 객체 단위로 읽으면 되고,
      //    while (true) {
      //      try {
      //        Book book = (Book) in.readObject();
      //        bookList.add(book);
      //
      //      } catch (Exception e) {
      //        break;
      //      }
      //    }

      // 2) 목록이 통째로 serialize 되었을 경우, 한 번에 목록을 읽으면 된다.
      bookList = (ArrayList) in.readObject(); // 단 기존의 생성한 ArrayList 객체는 버린다.  // () 이걸로 얘가 리턴하는건 ArrayList 임을 명시하자

      in.close();

    } catch (Exception e) {
      System.out.println("독서록 데이터를 로딩하는 중 오류 발생!");
    }
  }

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {
    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList.size()) {
      return "";
    }
    return bookList.get(index);
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.remove(index) == null ? 0 : 1;
  }

  @RequestMapping("/book/save")
  public Object save() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.ser2"))); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.

    // 1) 다음과 같이 목록에 들어 있는 객체를 한 개씩 순차적으로 serialize 할 수도 있고,
    //  Object[] arr = bookList.toArray();
    //  for (Object obj : arr) {
    //      out.writeUTF(obj);
    //  }

    // 2) 다음과 같이 목록 자체를 serialize 할 수도 있다.
    out.writeObject(bookList);

    out.close();
    return bookList.size();
  }
}




