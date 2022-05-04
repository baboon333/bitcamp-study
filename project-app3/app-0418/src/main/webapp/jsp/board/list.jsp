<%@page import="com.eomcs.mylist.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.eomcs.mylist.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>MyList!</title>
  <link href="/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">

<div id="header">
<jsp:include page="/jsp/header.jsp"></jsp:include>
</div>

<div id="sidebar">
<jsp:include page="/jsp/sidebar.jsp"></jsp:include>
</div>

<div id="content">
<h1>게시글</h1>
<a href="form.jsp">새 게시글</a>
<table id="x-board-table" border="1">
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>조회수</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>
<%
BoardService boardService = (BoardService) application.getAttribute("boardService");

int pageNo = 1; // 기본은 1page이다.
int pageSize = 5; // 기본은 1page에 5개이다.
int totalPageSize = 0; // 토탈 페이지가 기본 1page는 있어야 한다.


try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
  pageSize = Integer.parseInt(request.getParameter("pageSize"));
//pageSize 유효성 검증
if (pageSize < 5 || pageSize > 100) { // 이거 보다 더 달라고 하면 서버가 힘들어진다~ 디도스 공격이 이런거임!
    pageSize = 5;
  }
} catch (Exception e ){} // pageSize=aaa이렇게 문자열로 들어오는 것과 같은 에러가 떴을 때를 대비
    
//게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
int boardSize = boardService.size();
totalPageSize = boardSize / pageSize; // 예) 게시글 개수 / 페이지당 개수 = 16 / 5 = 3  
if ((boardSize % pageSize) > 0) { // 이 상황이면 페이지 수를 하나 늘린다.
  totalPageSize++;
}

try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
  pageNo = Integer.parseInt(request.getParameter("pageNo"));
  if (pageNo < 1 || pageNo > totalPageSize) {// pageNo 유효성 검증// 전체 페이지수가 5인데 6을 달라고 하면 안되잖아!
  pageNo = 1;
}
} catch (Exception e) {}

List<Board> boards = boardService.list(pageSize, pageNo); // 몇개씩 잘라서 몇페이지를 줘라
for (Board board : boards) {
%>
  <tr>
    <td><%=board.getNo()%></td>
    <td><a href='view.jsp?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
    <td><%=board.getWriter().getName()%></td>
    <td><%=board.getViewCount()%></td>
    <td><%=board.getCreatedDate()%></td>
  </tr>
<%
}
%>
</tbody>
</table>
<div>
<%if (pageNo > 1) {%>
<a href="list.jsp?pageNo=<%=pageNo - 1%>&pageSize=<%=pageSize%>">[이전]</a>
<%} else {%>
[이전]
<%} %>
<%=pageNo%>
<%if (pageNo < totalPageSize) { %>
<a href="list.jsp?pageNo=<%=pageNo + 1%>&pageSize=<%=pageSize%>">[다음]</a>
<%} else {%>
[다음]
<%} %>
</div>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

</div>
</body>
</html>
