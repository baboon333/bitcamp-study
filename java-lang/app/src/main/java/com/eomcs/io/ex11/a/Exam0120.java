// 인스턴스 입출력 - DataInputStream으로 인스턴스 읽기
package com.eomcs.io.ex11.a;

import java.io.DataInputStream; // Data Processing Stream Class = Decorator
import java.io.FileInputStream; // Data Sink Stream Class = Concrete Component

public class Exam0120 {

  public static void main(String[] args) throws Exception {

    FileInputStream fileIn = new FileInputStream("temp/member.data");
    DataInputStream in = new DataInputStream(fileIn);

    Member member = new Member();

    member.name = in.readUTF();  // read() 메서드 사용! 반드시 저장한 순서대로 읽어줘야 함! age가 name보다 먼저 나오면 안된다!
    member.age = in.readInt();
    member.gender = in.readBoolean();

    in.close();

    System.out.println(member);  // println 안에서는 이 넘어오는 값이 내부적으로 tostring() 메서드를 호출하기 때문에 걔가 리턴한 값을 얘가 출력하는 것이다. 잘 모르겠으면 들어가 봐!
  }
}


