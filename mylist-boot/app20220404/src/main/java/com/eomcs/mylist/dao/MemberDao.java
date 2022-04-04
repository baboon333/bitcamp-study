package com.eomcs.mylist.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.eomcs.mylist.domain.Member;

@Mapper  
public interface MemberDao {

  int insert(Member member);

  Member findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

  Member findByEmail(String email); // 한개 넘길 때는 굳이 이름을 Param으로 지정하지 않아도 된다.

  //  List<Member> findAll();
  //
  //  Member findByNo(int no);
  //
  //  int update(Member member);
  //
  //  int delete(int no);

}











