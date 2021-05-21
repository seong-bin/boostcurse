<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<%-- url에서 지정한 코어태그 사용한다고 jsp에 알림 --%>
<%--
	코어태그  : 흐름제어태그 - import 문법(지정한 url에 연결하여 결과를 지정한 변수에 저장)
	<c:import url="URL" var="변수명" scope="범위" [charEncoding="캐릭터인코딩"]>
		[ <c:param name="파라이터명" value="파라미터값" /> ]
	</c:import>
	
	*url - 결과를 읽어올 URL
	*var - 읽어온 결과를 저장할 변수명
	*scope - 변수를 저장할 영역
	*charEncoding - 읽어온 결과를 저장할 때 사용할 캐릭터 인코딩
	*<c:param> 태그는 url 속성에 지정한 사이트에 연결할 때 전송할 파라미터를 입력한다
 --%>
<%-- <c:import url="http://localhost:8089/firstweb/jstl/jspValue.jsp" var="urlValue" scope="request">	
</c:import> --%>
<c:import url="https://www.naver.com" var="urlValue" scope="request">	
</c:import>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${urlValue}
</body>
</html>