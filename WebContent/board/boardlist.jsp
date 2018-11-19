<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function openwriterForm() {
		window.open('writerForm.action', 'writerForm', 'width=400, top=200, height=400, left=400');
	}
</script>
</head>
<body>
<h1 align="center">[게시판]</h1>
	<table align="center" border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
			<tr>
			<s:iterator value="list" status="stat">
				<td>
					<s:property value="list[#stat.index].boardnum"/>
				</td>
				<td>
					<a href="/board/board/boardRead.action?boardnum=<s:property value="list[#stat.index].boardnum"/>">
					<s:property value="list[#stat.index].title"/>
					</a>
				</td>
				<td>
					<s:property value="list[#stat.index].id"/>
				</td>
				<td>
					<s:property value="list[#stat.index].inputdate"/>
				</td>
				<td>
					<s:property value="list[#stat.index].viewcount"/>
				</tr>
			</s:iterator>
	</table>
	<center>
		<s:if test="#session.id != null">
			<a href="javascript:openwriterForm()">글쓰기</a>
		</s:if>
		<a href="../index.jsp">처음화면</a>
	</center>
</body>
</html>