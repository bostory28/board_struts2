<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardwriteform</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#button').click(function() {
			var title = $('#title').val();
			var content = $('#content').val();
			var file = $('#file').val();
			var id = $('#id').val();
			$.ajax({
				url:'writeBoard.action',
				type:'post',
				dataType:'json',
				data:{title:title, content:content, file:file, id:id},
				success:function() {
					window.close();
					opener.location.href='boardlist.action';
				}
			});
		});
	});
</script>
</head>
<body>
	<form id="writeform">
		<input type="hidden" id="id" value="${session.id }">
		title : <input type="text" id="title"><br>
		content : <input type="text" id="content"><br>
		file : <input type="text" id="file"><br>
	</form>
	<input type="button" id="button" value="등록"> 
</body>
</html>