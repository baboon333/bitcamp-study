package com.eomcs.app2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.app2.table.ScoreTable;
import com.eomcs.app2.vo.Score;

public class ServerApp {

  ScoreTable scoreHandler = new ScoreTable();

  public static void main(String[] args) {
    new ServerApp().service();
  }

  public void service() {
    try (ServerSocket serverSocket = new ServerSocket(3306);) {

      while (true) {
        Socket socket = serverSocket.accept();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        while (true) {
          String command = in.readUTF();
          if (command.equals("quit")) {
            break;
          }

          try {
            switch (command) { // 클라이언트와 객체를 주고 받자
              case "insert":
                Score score = (Score)in.readObject();
                int count = ScoreTable.insert(score); // 클라이언트가 csv 형식으로 데이터를 보내면 그걸 insert하고 몇개를 insert했는지 출력한다
                out.writeUTF("success"); // 니가 원하는데로 인서트하는거 성공했어~
                out.writeInt(count); // 몇개 인서트했는지 알려줌
                break;
              case "selectList":
                Score[] scores = ScoreTable.selectList();
                out.writeUTF("success");
                out.writeObject(scores); // 배열을 꺼내서 바로 클라이언트에게 출력한다
                break;
              case "selectOne": // 클라이언트에서 데이터를 하나만 달라고 요청이 들어오면?
                int no = in.readInt();
                score = ScoreTable.selectOne(no);
                out.writeUTF("success");
                out.writeObject(score);
                break;
              case "update":
                no = in.readInt();
                score = (Score) in.readObject();
                count = ScoreTable.update(no, score); // 클라이언트가 객체를 하나 보냈어. 너가 이걸 변경해줘
                out.writeUTF("success");
                out.writeInt(count);
                break;
              case "delete":
                no = in.readInt();
                count = ScoreTable.delete(no);
                out.writeUTF("success");
                out.writeInt(count);
                break;
              default:
                out.writeUTF("fail");
                out.writeUTF("해당 명령을 지원하지 않습니다.");
            }
          } catch (Exception e) {
            out.writeUTF("fail");
            out.writeUTF("실행 오류" + e.getMessage());
          }
        }

      }
    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
    }

    System.out.println("종료!");
  }
}




















