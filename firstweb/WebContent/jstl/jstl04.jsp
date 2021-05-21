<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>	<%-- List improt 구문 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<%-- url에서 지정한 코어태그 사용한다고 jsp에 알림 --%>
<%
	List<String> list = new ArrayList<>();
	list.add("Hello");
	list.add("World");
	list.add("!!!!!");
	
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	코어태그  : 흐름제어태그 - forEach 문법
	<c:forEach var"변수" items="아이템" [begin="시작번호"] [end="끝번호"]>
	~
	${변수}
	~
	</c:c:forEach>
	*var - EL에서 사용 할 변수명
	*items - 배열, List, Iterator, Enumeration, Map 등의 Collection
	*begin - items에서 지정만 목록에서 값을 읽어올 시작 인덱스값
	*end - 인덱스 끝 값
	
	*item이 Map인 경우 변수에 저장되는 객체는 Map.Entry. 변수값을 사용할 때는
	 ${변수.key}와 ${변수.value}를 사용해서 맵에 저장된 항목의 <키,값>매핑에 접근 할 수 있다
 --%>
	<c:forEach var="item" items="${requestScope.list}" >
		${item}
		<br>
	</c:forEach>
</body>
</html>