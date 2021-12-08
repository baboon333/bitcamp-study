package com.eomcs.lang.ex05;  //중요! 기술 필기 시험에서 손코딩으로 많이 나옴!!

//# 비트 연산자 : 응용 I
//
public class Exam0440 {
  public static void main(String[] args) {

    // i 변수에 들어있는 값을 순서대로 1바이트씩 잘라서
    // a,b,c,d 변수에 넣은 다음 각 변수의 값을 16진수로 출력하라!
    int i = 0x27a130ff;
    int a, b, c, d;

    System.out.println(i);
    System.out.println(Integer.toHexString(i));


    // [00100111_10100001_00110000_11111111] => 27a130ff

    a = i >> 24;  //24비트 이동
    // [00000000_00000000_00000000_00100111]_10100001_00110000_11111111

    b = i >> 16 & 0xff;       //앞은 날려버리고 원하는 값만 얻음
    //  [00100111_10100001_00110000_11111111] => 27a130ff
    //  [00000000_00000000_00100111_10100001]_00110000_11111111
    //   00000000_00000000_00100111_10100001  => 0x000027a1
    // & 00000000_00000000_00000000_11111111  => 0x000000ff
    // --------------------------------------
    //   00000000_00000000_00000000_10100001

    c = i >> 8 & 0xff;
    //  [00100111_10100001_00110000_11111111] => 27a130ff
    //  [00000000_00100111_10100001_00110000]_11111111
    //   00000000_00100111_10100001_00110000  => 0x0027a130
    // & 00000000_00000000_00000000_11111111  => 0x000000ff
    // --------------------------------------
    //   00000000_00000000_00000000_00110000

    d = i & 0xff;
    //  [00100111_10100001_00110000_11111111] => 27a130ff
    //  [00100111_10100001_00110000_11111111]
    //   00100111_10100001_00110000_11111111  => 0x27a130ff
    // & 00000000_00000000_00000000_11111111  => 0x000000ff
    // --------------------------------------
    //   00000000_00000000_00000000_11111111

    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(b));
    System.out.println(Integer.toHexString(c));
    System.out.println(Integer.toHexString(d));


  }
}
