<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp</title>
</head>
<body>
	Hello
	<%
		System.out.println("jspService()");
	%>
	
	<%!
		//선언식
		// 메서드 선언 , 필드선언
		// jspService() 바깥에 선언 됨
		public void jspInit(){
			System.out.println("jspInit()");
		}
	%>	
	<%!
		public void jspDestroy(){
			System.out.println("jspDestroy()");
			
		}
	%>	
</body>
</html>