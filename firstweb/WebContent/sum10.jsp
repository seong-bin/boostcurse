<!-- 페이지 지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sum10</title>
</head>
<body>

<!-- 스크립틀릿. 자바코드 작성 가능 -->
<% 
    int total = 0;
    for(int i = 1; i <= 10; i++){
        total = total + i;
    }
%>

<!-- 표현식. 응답 결과로 주고싶으면 아래 형식처럼 -->
1부터 10까지의 합 : <%=total %>

</body>
</html>
<!-- 모든 jsp는 Servlet으로 바뀌어서 동작 함 -->
<!-- 위 꺽쇠 퍼센트 기호들은 서블릿을로 바뀔 때 어떻게 바뀔지 알려주기 위한 지시자 -->