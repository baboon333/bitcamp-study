package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam0110 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);  // 키보드를 스캐너와 연결
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt(); // 사용자가 숫자를 치고 엔터 칠 때까지 기다린다. 숫자만 리턴한다
    keyScan.close();  // 더 이상 키스캔은 필요없으니 닫아버린다

    int starLen = 1;
    while (starLen <= len) {
      // 별 앞에 공백 출력    //맨 위 별이 가운데 있어야되니!
      int spaceCnt = 1;
      int spaceLen = (len - starLen) / 2;  //만약 9개면 가운데 1개를 기준으로 양쪽에 4개씩 할 수 있으니
      while (spaceCnt <= spaceLen) {
        System.out.print(" ");   // 반복하면서 공백을 찍는다
        spaceCnt++;
      }

      // 별 출력
      int starCnt = 1;
      while (starCnt <= starLen) {
        System.out.print("*");
        starCnt++;
      }

      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;
    }
  }
}