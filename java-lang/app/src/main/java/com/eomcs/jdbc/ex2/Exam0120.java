// 게시물 관리 - 목록
package com.eomcs.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 다음과 같이 게시물 목록을 출력하라!
// 게시물 번호를 내림차순으로 정렬하라.
// ----------------------------
// 번호, 제목, 등록일, 조회수
// 2, aaa, 2019-1-1, 2
// 1, bbb, 2018-12-31, 3
// ----------------------------
public class Exam0120 {

  public static void main(String[] args) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111"); // mariadb는 기본이 3306이라 생략해도 된다!
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery( // ResultSet : 결과를 가져오는 도구! rs에 대해서 next()를 호출하면 서버에서 레코드를 한개 가져온다.
            "select * from x_board order by board_id desc")) { // x_board에서 데이터를 꺼내오는데 desc 내림차순으로 쭉 뽑아내겠다. board_id는 자동증가잖아!

      System.out.println("번호, 제목, 등록일, 조회수");
      while (rs.next()) { // next()를 호출할 때마다 서버에 하나의 레코드를 호출한다. 
        // 레코드에서 컬럼 값을 꺼낼 때 컬럼 번호를 지정하는 것 보다
        // 컬럼의 이름을 지정하는 것이 유지보수에 더 좋다.
        //
        System.out.printf("%d, %s, %s, %d\n", //
            rs.getInt("board_id"),
            rs.getString("title"), // title을 String으로 꺼내달라
            rs.getDate("created_date"),
            rs.getInt("view_count"));
      }
    }
  }
}


