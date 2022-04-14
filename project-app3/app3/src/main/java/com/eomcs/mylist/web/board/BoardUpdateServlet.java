package com.eomcs.mylist.web.board;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/update") 
public class BoardUpdateServlet extends HttpServlet {

  BoardService boardService;

  @Override
  public void init() throws ServletException {
    // BoardService 객체를 웹애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    boardService = (BoardService) 웹애플리케이션보관소.getAttribute("boardService");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    // 클라이언트가 보낸 문자열이 UTF-8로 인코딩 되어 있음을 설정한다.
    // 이 설정이 된 후에 getParameter() 호출해야 한다.
    // 그래야만 UTF-8 한글이 UTF-16 한글로 온전히 변환될 수 있다.
    req.setCharacterEncoding("UTF-8"); // 요청한 데이터가 utf-8이라고 알려줘야 한다.

    Board board = new Board();
    board.setNo(Integer.parseInt(req.getParameter("no"))); // 파라미터에서 no로 넘어온 값을 int로 바꿔 저장하라
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));

    Member loginUser = (Member) req.getSession().getAttribute("loginUser"); // 요청에 대해서 세션을 얻는데 거기서 loginUser라는 이름으로 저장된 member 객체를 꺼낼 것이다
    board.setWriter(loginUser); // 멤버 객체를 setWriter에 담을 것이다.

    boardService.update(board);

    resp.sendRedirect("list"); // 같은 board 밑에 list로 가라! 게시물 목록 페이지를 다시 요청하라고 클라이언트에게 명령한다.
  } 
}
