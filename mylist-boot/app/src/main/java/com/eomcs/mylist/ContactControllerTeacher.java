package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ContactControllerTeacher {

  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    String[] arr = new String[size]; 
    for (int i = 0; i < size; i++) { 
      arr[i] = contacts[i]; 
    }
    return arr; 
  }

  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    contacts[size++] = createCSV(name, email, tel, company);
    return size;
  }

  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }

    return contacts[index];
  }

  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    contacts[index] = createCSV(name, email, tel, company);
    return 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) { 
        for (int j = i + 1; j < size; j++) {
          contacts[j - 1] = contacts[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }

  // 기능: 
  // - 입력 받은 파라미터 값을 가지고 CSV 형식으로 문자열을 만들어 준다.
  //
  String createCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }

  // 기능:
  // - 이메일로 연락처 정보를 찾는다.
  // - 찾은 연락처의 배열 인덱스를 리턴한다.
  //
  int indexOf(String email) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) { 
        return i;
      }
    }
    return -1;
  }
}



