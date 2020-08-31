<%@page import="ch12.BoardDBBean"%>
<%@page import="ch12.BoardDataBean"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js">
</script>
<script type="text/javascript" src="list.js"></script>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<%
		String id = "";
		int pageSize = 3;	// 한 페이지에 표시할 글의 수
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");	// 날짜 데이터 표시 형식 지정
		
		String pageNum = request.getParameter("pageNum");	// 화면에 표시할 페이지 번호
		if(pageNum == null)	// 페이지 번호가 없으면 1페이지의 내용이 화면에 표시
			pageNum = "1";
		
		int count = 0;	// 전체 글의 수
		int currentPage = Integer.parseInt(pageNum);	// 숫자로 파싱
		
		List<BoardDataBean> articleList = null;	// 글목록을 저장
		BoardDBBean dbPro = BoardDBBean.getInstance();
		count = dbPro.getArticleCount();	// 전체 글 수 얻어냄
		
		if(count == (currentPage - 1) * pageSize)
			currentPage -= 1;
		
		int startRow = (currentPage - 1) * pageSize + 1;	// 현재 페이지에서의 시작글 번호
		
		try {
			if(count > 0)	// 테이블에 저장된 글이 있으면, 테이블에서 글목록을 가져옴
				articleList = dbPro.getArticles(startRow, pageSize);
			
			if(articleList.isEmpty())	// 테이블에 저장된 글이 없으면, 전 체 글 수: 0
				count = 0;
		} catch(Exception e) {}
	%>
	
	<div id="list_head" class="box2">
		<h3 class="inline">글목록(전체 글: <%= count %>)</h3>
		<button id="new">글쓰기</button>
	</div>
	
	<% if(count == 0) {	// 게시판에 글이 없는 경우 %>
			<div id="list_article" class="box2">
				<ul>
					<li><p>게시판에 저장된 글이 없습니다.
				</ul>
			</div>
	<%	} else {	// 게시판에 글이 있는 경우 %>
			<div id="list_article" class="box2">
				<%
					// 글목록을 반복 처리
					for(int i = 0; i < articleList.size(); i++) {
						BoardDataBean article = articleList.get(i);
				%>
						<ul class="article">
							<li class="layout_f">
							<%
								String writer = article.getWriter();
								out.println(writer.substring(0, 4) + "****");
							%>
							<li class="layout_f">
							<%
								int wid = 0;
								if(article.getRe_level() > 0) {
									wid = 5 * (article.getRe_level());
							%>
								<img src="level.gif" width="<%= wid %>">
								<img src="re.gif">
							<%	} else { %>
								<img src="level.gif" width="<%= wid %>" height="16">
							<%	} %>
							
							<% 
								int num = article.getNum(); 
								int ref = article.getRef();
								int re_step = article.getRe_step();
								int re_level = article.getRe_level();
							%>
							<%=	article.getSubject() %>
							<p class="date"><%= sdf.format(article.getReg_date()) %><br>
							<pre><%= article.getContent() %></pre><br>
							<%
								try {
									id = (String) session.getAttribute("id");
								} catch(Exception e) {}
							%>
							<% if(id.equals(writer)) { %>
								<button id="edit"
									name="<%= num + "," + pageNum %>" onclick="edit(this)">수정</button>
								<button id="ㅇ딛ㅅㄷ"
									name="<%= num + "," + pageNum %>" onclick="del(this)">삭제</button>
							<%	} else { %>
								<button id="reply"
									name="<%= num + "," + ref + "," + re_step + "," + re_level + "," + pageNum %>" 
									onclick="reply(this)">댓글쓰기</button>
							<%	} %>
						</ul>
				<%
					}
				%>
			</div>
	<%
		}
	%>
	
	<%-- 페이지 이동 처리 --%>
	<div id="jump" class="box3">
	<%
		if(count > 0) {
			int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			int startPage = 1;
			
			if(currentPage % pageSize != 0)
				startPage = (int) (currentPage / pageSize) * pageSize + 1;
			else
				startPage = ((int) (currentPage / pageSize) - 1) * pageSize + 1;
			
			int pageBlock = 3;	// 페이지들의 블록 단위 지정
			int endPage = startPage + pageBlock - 1;
			
			if(endPage > pageCount) {
	%>
				<button id="juP" name="<%= startPage - pageBlock %>"
					onclick="p(this)" class="w2">이전</button>
				&nbsp;
	<%
			}
			
			for(int i = startPage; i <= endPage; i++) {
				if(currentPage == i) {
	%>
					<button id="ju" name="<%= i %>"
						onclick="p(this)" class="w1"><%= i %></button>
			<%	} else { %>
					<button id="ju" name="<%= i %>"
						onclick="p(this)" class="w"><%= i %></button>
			<%	} %>
				&nbsp;
	<%
			}
			
			if(endPage < pageCount) {
	%>
				&nbsp;
				<button id="juN" name="<%= startPage + pageBlock %>"
					onclick="p(this)" class="w2">다음</button>
	<%
			}
		}
	%>
	</div>
			
</body>
</html>