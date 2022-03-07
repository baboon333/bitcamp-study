// 데이터를 처리하는 코드를 별도의 클래스로 캡슐화시킨다.
// => data 영속성(지속성)을 관리하는 클래스를 DAO(Data Access Object)라 부른다.
// => data 영속성(지속성)
//    - 데이터를 저장하고 유지하는 것.
//    - "데이터 퍼시스턴스(persistence)"라 부른다.
package com.eomcs.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
  public int delete(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement()) {

      // 첨부파일 삭제(자식테이블) -> 이렇게 하는 대신 on delete cascade 설정해도 된다. 
      stmt.executeUpdate("delete from x_board_file where board_id = " + no);

      // 게시글 삭제(부모테이블)
      return stmt.executeUpdate("delete from x_board where board_id=" + no);
    }
  }

  public List<Board> findAll() throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from x_board order by board_id desc")) {

      ArrayList<Board> list = new ArrayList<>();
      while (rs.next()) { // 서버에서 레코드를 하나 가져왔다면
        Board board = new Board();
        board.setNo(rs.getInt("board_id"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("contents"));
        board.setRegisteredDate(rs.getDate("created_date"));
        board.setViewCount(rs.getInt("view_count"));
        list.add(board); // 서버에서 데이터를 다 가져올 때까지 list에 담아라
      }
      return list;
    }
  }

  public int insert(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();) {

      String sql = String.format(
          "insert into x_board(title,contents) values('%s','%s')", 
          board.getTitle(),
          board.getContent());

      return stmt.executeUpdate(sql);
    }
  }

  public int update(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement()) {

      String sql = String.format(
          "update x_board set title='%s', contents='%s' where board_id=%d", 
          board.getTitle(),
          board.getContent(), // content를 board 객체에 있는 contents 값으로 바꿔라
          board.getNo());

      return stmt.executeUpdate(sql);
    }
  }

  public Board findBy(String no) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from x_board where board_id = " + no)) {

      if (!rs.next()) // next 했는데 true가 아니라면 null을 리턴하라
        return null;

      Board board = new Board();
      board.setNo(rs.getInt("board_id"));
      board.setTitle(rs.getString("title"));
      board.setContent(rs.getString("contents"));
      board.setRegisteredDate(rs.getDate("created_date"));
      board.setViewCount(rs.getInt("view_count"));

      return board;
    }
  }
}


