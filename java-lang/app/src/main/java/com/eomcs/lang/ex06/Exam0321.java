package com.eomcs.lang.ex06;

//# 흐름 제어문 - break와 continue 활용
//
public class Exam0321 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;


    // 1부터 100까지의 짝수의 합은?
    // => continue 사용 전
    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if ((count & 1) == 0) { // count & 1 ==> count & 0x01 ==> count % 2    //2진수에서 맨 끝에 숫자를 잘라내서 갖고와 1과 &연산하란 소리임!! 0이면 짝수고 1이면 홀수다! 왜냐면 맨 왼쪽 비트는 1이고 나머지는 다 2, 4, 8, 16 ...으로 2의 배수니까 짝수임! 그래서 맨 왼쪽 비트가 0이냐 1이냐에 따라 홀/짝이 결정되니 맨 끝 비트를 가져오는거임!! 왜 % 2 대신 & 1을 쓰냐면 이게 더 실행속도가 빠르기 때문이다!
        sum += count;
      }
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);

    System.out.println("------------------------");

    // => continue 사용 후
    count = 0;
    sum = 0;
    while (count < 100) {
      count++;
      if (count % 2 == 1)   //(count & 1) == 0) 얘도 홀짝인지 알아내는 코드! 얘가 더 빠름!! 비트를 다루는게 더 속도가 빠르기 때문. 나누기하는 것 보다 오른쪽으로 비트 하나 이동시키는게 더 빠른거임
        continue; // 다음 문장을 실행하지 않고 즉시 조건 검사(조건문)로 이동한다.
      sum += count;
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);
  }
}
