package com.eomcs.app1;

import java.util.ArrayList;

public class Command {
  String name;
  ArrayList params = new ArrayList(); // 명령어를 제외하고 나머지를 배열로 받겠다.

  public Command(String name, String[] values) {
    this.name = name;
    for (String value : values) {
      this.params.add(value); // this.는 생략할 수 있다
    }
  }

  public String getName() {
    return this.name;
  }

  public String getString(int paramIndex) {
    return (String) this.params.get(paramIndex);
  }

  public int getInt(int paramIndex) {
    return Integer.parseInt((String) this.params.get(paramIndex));
  }

  public int getParamSize() {
    return this.params.size();
  }
}
