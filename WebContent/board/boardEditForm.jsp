<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>editBaord</title>
</head>
<body>
	<form id="editform" action="editBaord.action">
		<input type="hidden" id="boardnum" name="board.boardnum" value="${board.boardnum }">
		title : <input type="text" id="title" name="board.title" value="${board.title}"><br>
		content : <input type="text" id="content" name="board.content" value="${board.content}"><br>
		<input type="submit" id="button" value="수정"> 
	</form>
</body>
</html>