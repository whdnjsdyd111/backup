<%@page import="ch11.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>

<%-- 7 ~ 9 라인 : 수정된 정보를 가지고 데이터 저장빈 객체를 생성 --%>
<jsp:useBean id="member" class="ch11.LogonDataBean">
	<jsp:setProperty name="member" property="*" />
</jsp:useBean>

<%
	LogonDBBean manager = LogonDBBean.getInstance();

	// 회원 정보 수정 처리 메소드 호출 후 수정 상황값 반환
	int check = manager.updateMember(member);
	
	out.println(check);
%>