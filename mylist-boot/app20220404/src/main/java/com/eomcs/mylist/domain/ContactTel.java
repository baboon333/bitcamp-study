package com.eomcs.mylist.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ContactTel {
  int no;
  int contactNo;
  int telTypeNo;
  String tel;
}
