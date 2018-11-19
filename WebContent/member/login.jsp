<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#loginbt').click(check);
	});
	
	function check() {
		var id = document.getElementById('id').value;
		var password = document.getElementById('password').value;
		if(id.length == 0 || password.length == 0) {
			alert('아이디 또는 패스워드를 입력하지 않았습니다.');
			return;
		}
		$.ajax({
			url:'login.action',
			type:'post',
			dataType:'json',
			data:{id:id, password:password},
			success:loginOK
		});
	}
	function loginOK(data) {
		if(data.logincheck == true) {
			alert('로그인되었습니다.');
			window.close();
			opener.location.href='<s:url value="/index.jsp"/>'; 
		} else {
			alert('아이디 또는 비밀번호가 잘못되었습니다.');
		}
	}
</script>
</head>
<body>
<s:url></s:url>
<h1>[로그인]</h1>
<form name="form">
<div>
	<div style="float: left; width: 110px; text-align: right;">
		ID : 
	</div>
	<div style="width: 300px">
		<input type="text" id="id">
	</div>
</div>
<div>
	<div style="float: left; width: 110px; text-align: right">
		PASSWORD :
	</div>
	<div style="width: 300px">
 		<input type="password" id="password">
 	</div>
</div>
<div style="width: 286px; text-align: right;">
	<input type="button" id="loginbt" value="Login">
</div>
</form>
</body>
</html>