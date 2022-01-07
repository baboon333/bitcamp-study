package com.eomcs.mylist.domain;

import java.sql.Date;

public class Book {  // public을 붙인 이유는 controller에서 써야하니 다른 패키지에서도 써야 하니 공개로 한 것!! 아님 공개 못함!
  String title;
  String author;
  String press;
  int pages;
  int price;
  Date readDate;
  String feed;

  public Book() {
    System.out.println("Book() 호출됨!");
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getFeed() {
    return feed;
  }
  public void setFeed(String feed) {
    this.feed = feed;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public java.sql.Date getReadDate() {
    return readDate;
  }
  public void setReadDate(java.sql.Date readDate) {
    this.readDate = readDate;
  }

  @Override
  public String toString() {
    return "Book [title=" + title + ", feed=" + feed + ", viewCount=" + viewCount
        + ", readDate=" + readDate + "]";
  }
}


// 게시글 crud 참고해서 코드 작성해봐
// 독서록 crud 만들어봐!
// 백엔드를 먼저 만들어놓고 프론트엔드를 만들어! 이렇게 구분해서 작업하는게 어느 입장인지 확실히 이해 할 수 있어 좋다.
