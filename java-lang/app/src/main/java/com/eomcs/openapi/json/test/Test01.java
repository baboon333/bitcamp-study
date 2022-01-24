package com.eomcs.openapi.json.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test01 {

  public static void main(String[] args) throws Exception {
    String jsonStr = "{\"name\":\"소보루\",\"maker\":\"안데르센\"}";

    ObjectMapper mapper = new ObjectMapper();

    Bread obj = mapper.readValue(jsonStr, Bread.class); // // readValue에게 어떤 객체를 만들어야 하는지 2번째 파라미터로 알려줘야 함!! Phone을 만들어줘(Phone.class) 하면 Phone 객체를 만들어주는 거임! JSON 객체로 넘겨줘야 되는데 타입을 알려줘야지~

    System.out.println(obj);

  }

}
