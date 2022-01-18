// 데이터 출력 - long 값 출력
package com.eomcs.io.ex04;

import java.io.FileOutputStream;

public class Exam0310 {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("temp/test3.data");

    // 우리나라 1년 예산
    long money = 400_0000_0000_0000L; // = 0x00016bcc41e90000

    // long 메모리의 모든 바이트를 출력하려면,
    // 각 바이트를 맨 끝으로 이동한 후 write()로 출력한다.
    // 왜? write()는 항상 변수의 마지막 1바이트만 출력하기 때문이다.
    out.write((int)(money >> 56)); // 00000000|00000000|016bcc41e90000  //56bit 이동...
    out.write((int)(money >> 48)); // 00000000|00000001|6bcc41e90000    // out.write((int)(money >> 48));  여기서 (int) 해주는 이유는 write()는 long 못받기 때문!! 따라서 int로 형변환 해줘야~ 그럼 어차피 앞에 4byte는 날아감
    out.write((int)(money >> 40)); // 00000000|0000016b|cc41e90000
    out.write((int)(money >> 32)); // 00000000|00016bcc|41e90000
    out.write((int)(money >> 24)); // 00000000|016bcc41|e90000
    out.write((int)(money >> 16)); // 00000001|6bcc41e9|0000
    out.write((int)(money >> 8));  // 0000016b|cc41e900|00
    out.write((int)money);         // 00016bcc|41e90000|

    out.close();

    System.out.println("데이터 출력 완료!");

  }  // 다른 방법 없어! 

}
