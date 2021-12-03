// 리터럴: 문자 리터럴
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam5")           //이 경로는 걍 내가 맘대로 적어도 되는거임. 패키지명 따라갈 필요 없음. 패키지명과 경로 헷갈리지마라~근데 패키지명과 경로를 똑같이 하면 나중에 예제 따라가기 쉬우니까 그냥 이렇게 강사님이 경로 주신거임
public class Exam5 {

  @GetMapping("/test1")
  public String test1() {
    return "문자1: " + 'A' + '가'; // 문자리터럴은 양쪽에 싱글 코테이션으로 적는다! //이렇게 return하면 요청한 브라우저에게 가는 것!요청한 브라우저인 @GetMapping("/test1")
  }

  @GetMapping("/test2")
  public String test2() {
    return "문자2: " + '\u0041' + '\uac00'; // 문자에 대한 유니코드 값을 지정해도 된다. 
  }

  @GetMapping("/test3")
  public String test3() {
    return "문자2: " + 0x41 + "," + 0xac00; // 문자 코드를 정수 값으로 지정한다. //이렇게 하면 문자열이랑 더해질 때는 10진수로 바껴서 표현된다. 2진수로 적든 16진수로 적든 사람이 보는건 10진수이기 때문에 10진수 형태의 문자로 바꾼 후 총 하나의 문자열로 나타낸다. 정수일 경우 합쳐질 때 10진수 형태로 만들어져서 합쳐진다.
    //대신 문자를 가리키는 코드임을 표시해야 한다.  //이렇게 16진수로 표시하면 몇 바이튼지 알 수 있으니!! 16진수는 1숫자 당 4비트 잖아~~ //문자가 가리키는 문자를 나타내고 싶으면 (char)이렇게 알려줘야지 아니면 어떻게 알아~(char) 써주면 캐릭터가 가리키는 번호임을 알 수 있다. 데이터의 종류에 대해서 컴파일러에게 알려주는 거임
  }

  @GetMapping("/test4")
  public String test4() {
    return "문자2: " + (char)65 + "," + (char)44032; // 문자의 코드 값은 그냥 정수 값이다.

  }

  @GetMapping("/test5")
  public String test5() {
    return "문자2: " + '\u4eba' + '\u00a9' + '\u03c0' + '\u03a3'; // 키보드에서 입력 불가능한 특수 문자를 가리킬 때 주로 유니코드를 사용한다.
  }
}
// 자바랭이랑 엄씨에스 자바랭이랑 같은 경로인데도 내 파일이 실행되는 이유는 한피씨당 하나의 서버만 실행되는데 내가 자바랭에서 app 실행했으면 그 실행한 파일의 exam 1, 2만 가서 읽을 수 있는 거기 때문이다!
//같은 주소라도 어느 패키지에서 app을 실행시켜서 서버를 열어줬느냐에 따라서 구분 지음





