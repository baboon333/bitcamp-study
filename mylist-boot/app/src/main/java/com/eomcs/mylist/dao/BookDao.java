package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Book;

public interface BookDao {

  int countAll();

  Object[] findAll();

  void insert(Book book);

  Book findByNo(int no);

  int update(int no, Book book);

  int delete(int no);
}











