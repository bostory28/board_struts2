<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberupdateform</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#update').on('click', update);
	});
	function update() {
		$.ajax({
			url:'memberupdate.action',
			type:'post',
			datatype:'json',
			data:$('#memberupdateform').serialize(),
			contentType:'application/x-www-form-urlencoded; charset=UTF-8',
			success:function() {
				alert('수정되었습니다.');
				window.close();
				opener.location.href='<s:url value="/index.jsp"/>';
			}
		});
	}
</script>
</head>
<body>
<form id="memberupdateform">
	<input type="text" id="id" readonly="readonly" name="vo.id" value="${vo.id }"><br>
	<input type="password" id="password" name="vo.password" value="${vo.password }"><br>
	<input type="button" id="update" value="수정">
</form>
</body>
</html>