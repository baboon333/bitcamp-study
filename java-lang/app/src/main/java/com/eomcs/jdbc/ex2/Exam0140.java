// 게시판 관리 - 변경
package com.eomcs.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

// 다음과 같이 게시물을 변경하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 제목? xxx
// 내용? xxxxx
// 변경하였습니다.
// (또는)
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0140 {

  public static void main(String[] args) throws Exception {

    String no = null;
    String title = null;
    String contents = null;

    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.print("번호? ");
      no = keyScan.nextLine();

      System.out.print("제목? ");
      title = keyScan.nextLine();

      System.out.print("내용? ");
      contents = keyScan.nextLine();
    }

    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement()) {

      // update 문장은 executeUpdate()를 사용하여 서버에 전달한다.
      String sql = String.format(
          "update x_board set title='%s',contents='%s' where board_id=%s",
          title, contents, no);
      int count = stmt.executeUpdate(sql); // 변경된 데이터의 개수를 리턴한다.

      if (count == 0) { // 업데이트에 적용된 데이터가 없다. 즉, where board_id=%s 조건에 해당되는 게시물이 존재하지 않는다. // 0은 업데이트 못했다. 1이상은 업데이트 했다. 음수는 없음!
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      } else {
        System.out.println("변경하였습니다.");
      }
    }
  }
}


