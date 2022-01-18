// 버퍼 사용 전 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf"); // 몇번 트랙에 몇번 섹터에 있는지 알아내야 함!

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초  // 반복문이 돌기 전 시간을 기록해둔다

    int callCount = 0;
    while ((b = in.read()) != -1) {
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);
    System.out.println(callCount);

    in.close();
  }

}
