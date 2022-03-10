package com.eomcs.mylist.dao;

// RuntimeException은 unchecked exception이다.
// - 즉 이 타입의 예외를 던질 경우 메서드 선언부에 어떤 예외를 던지는지 선언할 필요가 없다.  
// - 컴파일러는 RuntimeException 예외에 대해서는 올바르게 처리하였는지 검사하지 않는다.
// - 그래서 RuntimeException 계열의 예외를 unchecked exception이라 부른다. 
//
// Dao 객체에서 예외 상황이 발생했을 때 그 예외를 다루기 쉽도록 RuntimeException에 담아
// 
public class DaoException extends RuntimeException {
  private static final long serialVersionUID = 1L;



}
