package com.eomcs.lang.ex03;

//# 이스케이프 문자(escape character) = 문자 제어 코드
//- 화면에 출력하는 문자가 아니라 문자 출력을 제어하는 문자이다.
//- 제어 문자
//  \n - Line Feed(LF), 0x0a        웹 브라우저에서도 적용이 된다.
//  \r - Carrage Return(CR), 0x0d   웹 브라우저에서 적용 안됨. 커서(cursor)를 처음(맨 왼쪽)으로 돌리는 문자
//  \f - Form Feed, 0x0c            웹 브라우저에서 안씀
//  \t - Tab, 0x09                  웹 브라우저에서 씀. 두칸 공백
//  \b - Backspace, 0x08            커서를 한칸씩 뒤로 옮김
//  \' - Single Quote, 0x27         많이 씀
//  \" - Double Quote, 0x22         많이 씀
//  \\ - Backslash, 0x5c            많이 씀. 그냥 역슬래시인데 하나이면 위에 제어코드들이랑 헷갈리니까 하나를 더 써줘야 역슬래시라고 인식을 한다. 
//
public class Exam0700 {
  public static void main(String[] args) {
    System.out.println("Hello,world!"); 
    System.out.println("Hello,\nworld!"); // 줄바꿈 문자
    System.out.println("Hello,\rabc"); // 커서(cursor)를 처음으로 돌리는 문자
    // 커서란? 문자를 출력할 위치를 가리키는 것. //브라우저나 이클립스에서 아무 소용이 없음. 콘솔창(명령창)에서만 적용!

    System.out.println("Hello,\b\b\bworld!"); // 커서를 뒤로 한 칸 이동시키는 문자
    System.out.println("Hello,\tworld!"); // 탭 공간을 추가시키는 문자
    System.out.println("Hello,\fworld!"); // 
    System.out.println("Hello,\"w\"orld!"); // " 문자를 출력시키는 문자. 역슬래시 생략 불가
    System.out.println("Hello,'w'orld!"); //"" 안에서 ' 문자는 그냥 적는다. 역슬래시 생략
    System.out.println('\''); // ' 문자를 출력시키는 문자. 역슬래시 생략 불가.(헷갈리니까)
    System.out.println('"'); // '' 안에서 " 문자는 그냥 적는다. 역슬래시 생략가능
    System.out.println("c:\\Users\\user\\git"); // \ 문자를 출력시키는 문자
  }
}

