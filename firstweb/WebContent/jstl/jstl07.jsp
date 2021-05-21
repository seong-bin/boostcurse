<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<%-- url에서 지정한 코어태그 사용한다고 jsp에 알림 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="t" value="<script type='text/javascript'>alert(1);</script>" />
<%-- ${t} --%>
<c:out value="${t}" escapeXml="true" />
<%-- <c:out value="${t}" escapeXml="false" /> --%>
</body>
</html>