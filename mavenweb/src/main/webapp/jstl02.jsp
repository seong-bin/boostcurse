<%-- 
	- java에서 프러퍼티 라는 용어가 나오면 이 객체의 값을 변경하거나 읽어들이기 위한 geter seter 메소드를 생각하면 된다
	-set태그를 이용해 특정 객체의 메서드에 값을 전달 할 수도 있다
	ex)
	<c:set target="${some}" property="propertyName" value="anyValue" />
	some 객체가 자바빈일 경우 : some.setPropertyName("anyValue");
	some 객체가 맵(map)일 경우 : some.put("propertyName", "anyValue");
	target : <c:set>으로 지정한 변수 객체
	property : 프로퍼티 명
	value : 새로 지정할 프로퍼티 값
	
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<%-- url에서 지정한 코어태그 사용한다고 jsp에 알림 --%>
<%
	request.setAttribute("n", 10);
%>
<%-- <c:set var="n" scope="request" value="10"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	코어태그  : 흐름제어태그 - if 문법(else는 없음)
	<c:if test="조건">
	~
	</c:if>
 --%>
	<c:if test="${requestScope.n == 0}">
		n은 0과 같습니다
	</c:if>
	<c:if test="${requestScope.n == 10}">
		n은 10과 같습니다
	</c:if>
	<br>
	
<%--
	강의에서 jstl03.jsp 코드
	코어태그  : 흐름제어태그 - choose (if, else if, else)
	<c:choose>
		<c:when test="조건1">
			~
		</c:when>
		<c:when test="조건2">
			~
		</c:when>
		<c:otherwise>
			~
		</c:otherwise>
	</c:choose>
 --%>
<%-- 
<%
	request.setAttribute("score", 83);
%> 
--%>
<c:set var="score" scope="request" value="83"/>
<c:choose>
	<c:when test="${score>=90}">
		A 입니다.
	</c:when>
	<c:when test="${score>=80}">
		B 입니다.
	</c:when>
	<c:when test="${score>=70}">
		C 입니다.
	</c:when>
	<c:when test="${score>=60}">
		D 입니다.
	</c:when>
	<c:otherwise>
		F 입니다.
	</c:otherwise>
</c:choose>

</body>
</html>