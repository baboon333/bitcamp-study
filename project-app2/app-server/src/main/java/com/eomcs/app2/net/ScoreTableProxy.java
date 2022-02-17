package com.eomcs.app2.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.app2.vo.Score;

public class ScoreTableProxy {

  Socket socket; // 변수 선언은 위로 빼준다.
  ObjectOutputStream out;
  ObjectInputStream in;

  public ScoreTableProxy(String host, int port) throws Exception {
    socket = new Socket(host, port);
    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
  }

  public void close() {
    try {out.close();} catch (Exception e) {}
    try {in.close();} catch (Exception e) {}
    try {socket.close();} catch (Exception e) {}
  }


  public int insert(Score score) { // static이 아니라 인스턴스 메서드로 바꾼다.
    try {
      out.writeUTF("insert");
      out.writeObject(score);
      out.flush();

      String status = in.readUTF();
      if (status.equals("success")) {
        int count = in.readInt(); // java의 DBMS에서 항상 int 값을 리턴하므로 그냥 흉내내서 만든거임
      } else {
        throw new ScoreTableException(in.readUTF());
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }



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

















