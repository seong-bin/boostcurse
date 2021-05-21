<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	<%-- url에서 지정한 코어태그 사용한다고 jsp에 알림 --%>
<%--
	코어태그  : 흐름제어태그 - redirect
	<c:redirect url="리다이렉트할URL">
		[ <c:redirect name="파라이터명" value="파라미터값" /> ]
	</c:redirect>
	
	*url - 리다이렉트 할 URL
	*<c:param> 리다이렉트할 페이지에 전송할 파라미터를 입력한다
 --%>
<c:redirect url="http://localhost:8089/firstweb/jstl/jstl05.jsp"></c:redirect>
