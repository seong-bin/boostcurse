<!-- 부스트코스 백앤드 jstl&el 1) el-2 강의 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("p1", "page scope value");			//pageScope에 값 넣기
	request.setAttribute("r1", "request scope value");			//requestScope에 값 넣기
	session.setAttribute("s1", "session scope value");			//sessionScope에 값 넣기
	application.setAttribute("a1", "application scope value");	//applicationScope에 값 넣기
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	pageScope
	<br>
	JSP로 출력 - pageContext.getAttribute : <%=pageContext.getAttribute("p1") %>
	<br>
	EL로 출력 - pageScope.p1 : ${pageScope.p1}
	<br>
	EL로 출력 - p1 : ${p1}	( key명이 유일하다면 간단히 사용 가능. 유일하지 않다면 작은 scope부터 찾음 )
	<br><br>
	
	requestScope
	<br>
	JSP로 출력 - request.getAttribute : <%=request.getAttribute("p1") %>
	<br>
	EL로 출력 - pageScope.r1 : ${requestScope.r1}
	<br><br>
	
	sessionScope
	<br>
	JSP로 출력 - session.getAttribute : <%=session.getAttribute("p1") %>
	<br>
	EL로 출력 - sessionScope.s1 : ${sessionScope.s1}
	<br><br>
	
	applicationScope
	<br>
	JSP로 출력 - application.getAttribute : <%=application.getAttribute("p1") %>
	<br>
	EL로 출력 - applicationScope.a1 : ${applicationScope.aq}

</body>
</html>