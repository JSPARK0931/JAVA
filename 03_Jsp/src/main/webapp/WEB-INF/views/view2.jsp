<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% out.println("안녕하세요"); %> --%>
<div> 이름 : ${member.name} </div>
<div> 나이 : ${member.age} </div>
<div> 주소 : ${member.addr} </div>

<a href="form">이전페이지</a>

</body>
</html>