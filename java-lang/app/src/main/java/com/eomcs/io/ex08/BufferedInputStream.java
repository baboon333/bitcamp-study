package com.eomcs.io.ex08;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream {
  InputStream in;  // 추상클래스의 레퍼런스를 받는다는건 그 객체가 아닌 자식 객체도 가리킬 수 있으니! 레퍼런스의 타입이 추상클래스, 인터페이스여도 쫄지마! 그걸 상속받은 클래스를 담는다는 거임! 그럼 왜 InputStream을 했냐? piped~, file~, 등등을 다 가리킬 수 있으니 훨씬 유연하다!

  byte[] buf = new byte[8192];
  int size; // 배열에 저장되어 있는 바이트의 수
  int cursor; // 바이트 읽은 배열의 위치

  public BufferedInputStream(InputStream in) {
    this.in = in;
  }

  public int read() throws IOException {
    if (cursor == size) { // 버퍼에 저장되어 있는 데이터를 모두 읽었다는 의미
      if ((size = in.read(buf)) == -1) { // 파일에서 데이터를 읽으려 했는데 데이터가 없다.
        return -1;
      }
      cursor = 0;
    }
    return buf[cursor++] & 0x000000ff;  // 버퍼에 보관된 데이터를 리턴해준다.(read가 호출될 때마다! 버퍼에 있는게 다 사라질 때 까지)
  }

  public int read(byte[] buf) throws IOException {
    int i = 0;
    for (; i < buf.length; i++) {
      // 1바이트를 읽어서 파라미터로 받은 바이트 배열에 채운다.
      int b = this.read();
      if (b == -1) {
        // 바이트 배열을 다 채우기도 전에 읽을 데이터가 없다면 읽기를 멈춘다.
        break;
      }
      buf[i] = (byte) b;
    }
    return i; // 지금까지 읽은 데이터의 수를 리턴한다.
  }

  public void close() throws IOException {
    in.close();
  }
}


