/*package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ContactController4 {

  @RequestMapping("/contact/list")
  public Object list() {
    return ArrayList.toArray(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    ArrayList.add(contact);
    return ArrayList.size;
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return "";
    }

    return ArrayList.contacts[index];
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = ArrayList.indexOf(contact.email);
    if (index == -1) {
      return 0;
    }

    return ArrayList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return 0;
    }

    ArrayList.remove(index);
    return 1;
  }
}*/
