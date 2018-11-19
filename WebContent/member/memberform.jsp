<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>joinmember</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#button').click(join);
	});
	
	function join() {
		var id = $('#id').val();
		var password = $('#password').val();
		if(id.length == 0 || password.length == 0) {
			alert('값을 입력하시오');
			return;
		}
		$.ajax({
			url:'memberJoin.action',
			type:'post',
			dataType:'json',
			data:$('#memberform').serialize(),
			contentType:'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(json) {
				alert('회원가입했습니다.');
				window.close();
				opener.location.href='<s:url value="/index.action"/>';
			}
		});
	}
</script>
</head>
<body>
<form id="memberform">
	<input type="text" id="id" name="vo.id"><br>
	<input type="password" id="password" name="vo.password"><br>
	<input type="button" id="button" value="가입">
</form>
</body>
</html>