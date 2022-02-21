// 바이너리 파일을 텍스트 형식으로 저장하기
package com.eomcs.io.ex15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Exam0110 {
  public static void main(String[] args) throws Exception {

    Encoder encoder = Base64.getEncoder(); // Base64 안의 중첩 클래스 Encoder

    File file = new File("./temp/ok_cute.jpg");
    FileInputStream in = new FileInputStream(file); // 바이너리 데이터를 읽어서
    FileWriter out = new FileWriter("./temp/photo.txt");

    byte[] buf = new byte[(int) file.length()];
    int len = in.read(buf);
    System.out.printf("읽은 바이트 수: %d\n", len);

    // 바이트 배열에 저장된 바이너리 데이터를 텍스트로 변환하기
    String encodedStr = encoder.encodeToString(Arrays.copyOf(buf, len)); // 버퍼에 들어있는 걸 한번에 바꿈

    // 텍스트로 변환된 데이터를 파일로 출력하기
    out.write(encodedStr); // 출력하기

    in.close();
    out.close();
  }

}














