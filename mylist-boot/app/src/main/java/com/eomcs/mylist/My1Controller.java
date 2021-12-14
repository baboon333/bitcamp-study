package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class My1Controller{ 

  String[] games = new String[10];
  int length = 0;

  @RequestMapping("/my1/list")
  public Object list() {
    String[] arr = new String[length];
    for (int i = 0; i < length; i++) {
      arr[i] = games[i];
    }
    return arr;
  }

  @RequestMapping("/my1/add")
  public Object add(String name, String genre, String level, String time, String number) {
    String game = name + "," + genre + "," + level + "," + time + "," + number;
    games[length++] = game;
    return length;
  }

  @RequestMapping("/my1/get")
  public Object get(String name) {
    for (int i = 0; i < length; i++) {
      if (games[i].split(",")[0].equals(name)) {
        return games[i];      
      }
    }
    return "";
  }

  @RequestMapping("/my1/update")
  public Object update(String name, String genre, String level, String time, String number) {
    String game = name + "," + genre + "," + level + "," + time + "," + number;
    for (int i = 0; i < length; i++) {
      if (games[i].split(",")[0].equals(name)) {
        games[i] = game;
        return 1;
      }
    }
    return 0;
  }

  @RequestMapping("/my1/delete")
  public Object delete(String name) {
    for (int i = 0; i < length; i++) {
      if (games[i].split(",")[0].equals(name)) {
        for (int j = i + 1; j < length; j++) {
          games[j - 1] = games[j];   
        }
        length--;  
        return 1;
      }
    }
    return 0;
  }
}