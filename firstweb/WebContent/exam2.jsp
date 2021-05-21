<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>exam2</title>
</head>
<body>
<%-- jsp 주석(자바로 변환될 때 포함 안됨 --%>
<%
	for(int i=1; i<=5; i++){
%>
<h<%=i %>>아름다운 한글</h<%=i %>>
<%
	}
%>
</body>
</html>