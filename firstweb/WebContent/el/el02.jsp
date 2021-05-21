<!-- 부스트코스 백앤드 jstl&el 1) el-3 강의 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>	<%-- isELIgnored이 true이면 el 무시됨(문자 그대로 출력됨) --%>
<!DOCTYPE html>
<%
	request.setAttribute("k", 10);
	request.setAttribute("m", true);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
k : ${k} <br>
k + 5 : ${k + 5} <br>
k - 5 : ${k - 5} <br>
k * 5 : ${k * 5} <br>
k /5 : ${k div 5} <br>	<%--HTML에서 /를 못알아 볼 수있으니 EL의 나누기 예약어인 div 사용 --%>

k : ${k} <br>
m : ${m} <br>

k > 5 : ${k > 5} <br>
k < 5 : ${k < 5} <br>
k <= 5 : ${k <= 5} <br>
k >= 5 : ${k >= 5} <br>
m : ${m} <br>
!m : ${!m} <br>
</body>
</html>