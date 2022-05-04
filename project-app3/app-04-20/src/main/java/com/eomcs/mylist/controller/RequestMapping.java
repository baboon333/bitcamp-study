package com.eomcs.mylist.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE}) // 메서드에만 붙일 수 있다.
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
  String value(); // 페이지 컨트롤러의 path를 저장할 프로퍼티
  String defaultValue() default ""; // 해당 이름의 요청 파라미터 값이 없ㅇ르 때 사용할 기본 값을 설정하는 프로퍼티
}
