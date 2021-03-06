package com.eomcs.mylist.dao;

import java.io.File;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository  
public class JsonBookDao extends AbstractBookDao {

  String filename = "books.json";

  public JsonBookDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      bookList.addAll(mapper.readValue(new File(filename), Book[].class));

    } catch (Exception e) {
      System.out.println("독서록 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), bookList.toArray());
  }
}











