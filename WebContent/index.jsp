<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행 관리 시스템</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div style = "background-color : green;">
	<h2>welcome</h2>
	<table border="1">
		<tr>
			<td>로그인</td>
			<td><a id="btn" href=#>로그인</a></td>
		</tr>
		<tr>
			<td>회원가입</td>
			<td><a id="a_join" href=#>바로가기</a></td>
		</tr>
	</table>
</div>
<script>
$('#btn').click(function(){
	location.assign('<%=request.getContextPath()%>/customer.do?page=login');
	alert('버튼클릭');
});
$('#a_join').click(function(){
	alert('a태그 클릭');
	location.assign('<%=request.getContextPath()%>/customer.do?page=join');
});
</script>
</body>
</html>