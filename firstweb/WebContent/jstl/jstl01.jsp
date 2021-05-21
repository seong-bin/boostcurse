<%--
	jstl사용 위해 http://tomcat.apache.org/download-taglibs.cgi 에서
	.~~.-impl-~~.jar
	.~~.-spec-~~.jar
	.~~.-jstlel-~~.jar
	웨 세가지 파일 다운로드 받고 .../WEB-INF/ilb 안에 삽입
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<%-- url에서 지정한 코어태그 사용한다고 jsp에 알림 --%>
<c:set var="value1" scope="request" value="bae" />	<%-- 변수 생성 및 값 넣기 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
성 : ${value1} <br>
<c:remove var="value1" scope="request"/>	<%-- 변수 제거 --%>
성 : ${value1} <br>
</body>
</html>