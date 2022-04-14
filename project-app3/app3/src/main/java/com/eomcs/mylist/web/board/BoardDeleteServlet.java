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
@WebServlet("/board/delete") 
public class BoardDeleteServlet extends HttpServlet {

  BoardService boardService;

  @Override
  public void init() throws ServletException { // 서비스 객체 준비
    // BoardService 객체를 웹애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    boardService = (BoardService) 웹애플리케이션보관소.getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Board board = new Board();
    board.setNo(Integer.parseInt(req.getParameter("no")));

    Member loginUser = (Member) req.getSession().getAttribute("loginUser"); // 세션에서 member 정보를 가져온다
    board.setWriter(loginUser);

    boardService.delete(board);

    resp.sendRedirect("list"); // 삭제가 되었으면 list로 돌아가라
  }
}
