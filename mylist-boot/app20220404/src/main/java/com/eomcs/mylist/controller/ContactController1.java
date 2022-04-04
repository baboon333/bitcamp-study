/*package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;


//1) 생성자에서 FileReader 객체를 준비한다.
//2) 파일에서 문자를 읽어 출력한다.
//3) 파일을 더이상 읽을 수 없으면 반복문을 종료한다.
//4) 파일에서 읽은 문자를 버퍼에 담았다가 줄바꿈 코드를 만나면 출력한다. 
//5) 한 줄 출력한 다음에 버퍼를 비운다.
//6) 한 줄의 CSV 데이터를 읽어 분석한 후 Contact 객체에 담아서 목록에 추가한다.
//7) CSV 데이터로 Contact 객체를 초기화시키는 일을 Contact 객체의 생성자로 옮긴다.
//8) Contact 클래스의 valueOf() 스태틱 메서드를 사용하여 CSV 데이터로 객체를 생성한다.
//9) while문 정리!
//
@RestController 
public class ContactController1 {

  // Contact 객체 목록을 저장할 메모리 준비
  // => Object[] list = new Object[5];
  // => int size = 0;
  ArrayList contactList;  // 인스턴스 변수 = 초기화 문장

  public ContactController1() throws Exception { //throws Exception 이거는 나중에 설명!
    contactList = new ArrayList();
    System.out.println("ContactController() 호출됨!");

    FileReader in = new FileReader("contacts.csv");  // 파일의 경로를 주라

    StringBuilder buf = new StringBuilder();  // 버퍼 생성
    int c;  //한문자씩 읽는거임  c: character 줄여서 이렇게 잘 말함!
    while (true) {  // true이니 무한으로 반복

      c = in.read();  // 파일에서 한 문자를 읽는다.

      if (c == -1)  // 더이상 파일에서 읽을 문자가 없다면 반복문을 종료한다. (파일의 데이터를 이미 다 읽었으면 -1이 나온다(read() 설명 보면 나온다)! 그리고 if문에 의해 while문이 종료된다!)
        break;

      if (c == '\n') {  //만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact 객체에 담는다.
        contactList.add(Contact.valueOf(buf.toString())); // 파일에서 읽은 데이터를 담을 객체를 준비한다.
        buf.setLength(0); // 다음 데이터를 읽기 위해 buffer를 초기화시킨다. 

      } else { // 문자를 읽을 때 마다 버퍼에 임시 보관한다.  // 줄바꿈이 아니면! csv파일에서 그 한줄은 줄바꿈이 없잖아! 버퍼에 한줄씩 잘라내어 객체에 담아 저장하는 것!
        buf.append((char) c);  // buffer에 쌓아놔!  //  (char) c : 문자에 대한 고유 번호야!라고 알려줘야 함
      }
    }

    in.close();
  }

  @RequestMapping("/contact/list")
  public Object list() {
    return contactList.toArray(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    contactList.add(contact);
    return contactList.size();
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactList.get(index);
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }

    return contactList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    contactList.remove(index);
    return 1;
  }

  @RequestMapping("/contact/save")
  public Object save() throws Exception {
    FileWriter out = new FileWriter("contacts.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.  contacts.csv에 저장하라고 지정해준 것!

    Object[] arr = contactList.toArray();
    for (Object obj : arr) {   //배열에서 각각의 연락처 주소를 꺼낸 다음에 
      Contact contact = (Contact) obj;  // 형변환 해야지 getName 이런 메서드 호출할 수 있으니!
      out.write(contact.toCsvString() + "\n");  //"\n"은 toCsvString()아닌 여기에 있어야한다! grasp 패턴의 information expert
    }  //String 클래스의 format 메서드 사용함(스태틱 메서드)


    out.close();  // 보드마카 뚜껑 닫듯이 꼭 끝내줘야 한다!
    return arr.length;
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList.size(); i++) {
      Contact contact =  (Contact) contactList.get(i);
      if (contact.getEmail().equals(email)) { 
        return i;
      }
    }
    return -1;
  }
}
 */
