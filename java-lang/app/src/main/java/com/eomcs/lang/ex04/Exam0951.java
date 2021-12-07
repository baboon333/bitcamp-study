package com.eomcs.lang.ex04;

//# 형변환 - 명시적 형변환이 불가능한 경우, 특별한 메서드를 사용하면 가능하다.   //문자열을 숫자로 바꿀 때
// 
public class Exam0951 {
  public static void main(String[] args) {

    byte b = Byte.valueOf("100");  //byte라는 primitive type에 대응하는 class는 Byte(대문자다)!! 이 둘은 다른거다!! 그냥 class가 아니라 primitive type을 객체로 담을 수 있도록 포장하는 역할! 그래서 wrapper class라고 한다. 
    short s = Short.valueOf("32767");
    int i1 = Integer.valueOf("2122223333"); // 문자열 ==> int  / 얘는 valueOf랑 같은 뜻을 가지는 parseInt도 있다. 둘 중 편한거 써!!
    int i2 = Integer.parseInt("2122223333"); // 문자열 ==> int
    long l = Long.valueOf("9221111222233334444"); 
    float f1 = Float.valueOf("3.14f");
    float f2 = Float.parseFloat("3.14f");
    double d = Double.valueOf("9876.54321");
    boolean bool1 = Boolean.valueOf("TRUE");   // 문자열 ==> boolean
    boolean bool2 = Boolean.parseBoolean("TRUE");   // 문자열 ==> boolean  //1로도 해보고 0으로도 해보고 true로도 해봐!
    char c = "가".charAt(0);  //0번째꺼 뽑아내는거임. 대충 넘어가심

    System.out.println(b);
    System.out.println(s);
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(l);
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(d);
    System.out.println(bool1);
    System.out.println(bool2);
    System.out.println(c);
  }
}
