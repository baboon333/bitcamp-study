// 생성자 활용 예 - 자바에서 제공하는 클래스(String) 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

import java.nio.charset.Charset;

public class Exam0112 {

  public static void main(String[] args) throws Exception {
    System.out.println(Charset.defaultCharset());  //UTF-8

    // 한글 문자 코드의 바이트 배열을 가지고 String 인스턴스 초기화시키기.
    byte[] bytes = {
        (byte)0xb0, (byte)0xa1, // 가  (EUC-KR 코드)
        (byte)0xb0, (byte)0xa2, // 각  (EUC-KR 코드)
        (byte)0xb6, (byte)0xca, // 똘  (EUC-KR 코드)
        (byte)0xb6, (byte)0xcb  // 똥  (EUC-KR 코드)
    };
    String s1 = new String(bytes); //String 객체 - utf-16  // new String(bytes, "EUC-KR")이런 식으로 바이트 배열이 어떤 규칙으로 작성되었는지 파라미터로 습관적으로 알려줘야! 그니까 그냥 byte[]만 받는 생성자 쓰지마! String(byte[])! 
    // 바이트 배열에 들어 있는 문자 코드가 어떤 문자집합(charset)에 맞춰 작성되었는지 알려주지 않으면
    // String 클래스는 JVM이 가정하는 문자집합으로 작성되었을 거라고 생각하고 Unicode로 변환한다.
    // 근데 지금은 이클립스에서 실행하고 있으니 UTF-8이라고 가정하는데 바이트 배열이 EUC-KR로 인코딩 되었으니 한글이 깨져서 출력되는 것이다.

    System.out.println(s1);
    System.out.println("-----------------------------------");
    // 결과: 
    // => 한글 출력이 깨진다.
    //
    // 이유?
    // => String 클래스는 파라미터로 넘겨 받은 바이트 배열을 가지고
    //    유니코드(UCS2) 문자열로 변환할 때
    //    바이트 배열이 OS의 기본 문자 코드로 되어 있다고 간주한다. (콘솔창에서)
    // => OS 마다 기본으로 사용하는 문자 코드표(Character Set)가 다르다.
    //    Windows : MS949 (윈도우에서 실행하면 문자집합을 MS949라 생각한다.)
    //    Unix/Linux/macOS : UTF-8
    //    이클립스에서 실행할 경우: OS에 상관없이 UTF-8이라고 가정한다.
    // => 그런데 위 예제의 바이트 배열은 EUC-KR 코드이다.
    //    그래서 String 클래스는 바이트 배열을 제대로 해석하지 못한 것이다.
    // => 따라서 이클립스에서는 한글이 깨지지만 콘솔창에서는 깨지지 않는다. (MS949는 EUC-KR+a이기 때문에 되는 것)

    //
    // 해결책?
    // => String 클래스의 생성자를 호출할 때
    //    바이트 배열과 인코딩 정보를 함께 받는 생성자를 사용하라!
    // => 즉 bytes 배열에 EUC-KR의 코드 값이 들어 있다고 알려준다.
    //    그러면 JVM은 바이트 배열에 들어 있는 값을 제대로 유니코드 바꿀 것이다.
    // 
    String s2 = new String(bytes, "EUC-KR"); // 안알려주면 UTF-8이라고 생각한다. 
    System.out.println(s2);

  }
}
















