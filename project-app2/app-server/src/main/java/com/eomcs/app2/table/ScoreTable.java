package com.eomcs.app2.table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.eomcs.app2.vo.Score;

public class ScoreTable {
  static ArrayList<Score> scores = new ArrayList<>(); // 여기서 인스턴스가 생성되는 코드는 컴파일 될 때 static 블록 안으로 들어간다.

  static { // static 블록에 두면 클래스가 로딩될 때 실행되니!! 
    try (BufferedReader in = new BufferedReader(new FileReader("./score.csv"));) {
      String line;
      while ((line = in.readLine()) != null) {
        scores.add(Score.fromCSV(line));
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }
  }

  private static void save() {
    try (PrintWriter out = new PrintWriter(new FileWriter("./score.csv"));) {
      for (Score score : scores) {
        out.println(score.toCSV());
      }
    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류 발생!");
    }
  }

  public static int insert(Score score) {
    scores.add(score); 
    save();
    return 1;
  }

  public static Score[] selectList() {
    return scores.toArray(new Score[0]); // size를 0으로 줘도 toArray가 알아서 scores가 다 담길만한 새 배열을 만들어서 값을 담아서 리턴함
  }

  public static Score selectOne(int no) {
    return scores.get(no);
  }

  public static int update(int no, Score score) {
    scores.set(no, score);
    save();
    return 1;
  }

  public static int delete(int no) {
    scores.remove(no);
    save();
    return 1;
  }

}

















