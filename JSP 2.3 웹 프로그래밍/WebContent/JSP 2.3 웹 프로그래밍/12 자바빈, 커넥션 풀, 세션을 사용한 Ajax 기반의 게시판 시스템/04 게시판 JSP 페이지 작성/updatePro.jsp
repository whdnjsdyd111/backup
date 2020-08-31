<%@page import="ch12.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>

<%-- BoardDataBean 클래스의 객체 article을 생성 : 향후 이 객체에 접근 시 article. --%>
<jsp:useBean id="article" scope="page" class="ch12.BoardDataBean">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>

<%
	BoardDBBean dbPro = BoardDBBean.getInstance();
	
	// 글수정 처리한 후 결과를 check 변수에 저장
	int check = dbPro.updateArticle(article);
	
	// 이 페이지를 호출한 update.js로 처리 결과값 check를 반환
	out.println(check);
%>