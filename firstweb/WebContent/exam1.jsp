<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>exam1</title>
</head>
<body>
	id : <%= getId() %>
	<%!
		String id = "u001";	//전역변수 선언
		public String getId(){	//메소드 선언
			return id;
		}
	%>
</body>
</html>