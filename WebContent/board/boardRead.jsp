<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>게시판 글읽기</title>

<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var boardnum = ${ board.boardnum };
	$.ajax({
		url:'getReplyInBaord.action',
		type:'post',
		dataType:'json',
		data:{boardnum : boardnum},
		success:reOutput
	});
	$('#rebutton').on('click', formSubmit);
});
//글삭제시 확인 스크립트
function deleteCheck(boardnum){
	if(confirm("정말 삭제하시겠습니까?")){
		document.location.href = '<s:url value="/board/boardDelete.action?boardnum=" />' + boardnum;
	}
}
function formSubmit() {
	var retext = $('#retext').val();
	var boardnum = ${ board.boardnum };
	if(retext.length <= 3) {
		alert('내용을 입력하시오');
		return;
	}
	$.ajax({
		url:'replyInsert.action',
		type:'post',
		dataType:'json',
		data:$('#replyform').serialize(),
		contentType:'application/x-www-form-urlencoded; charset=UTF-8',
		success:reInsert
	});
}
function reInsert(json) {
	var logincheck = json.loginCheck;
	if(logincheck == false) {
		alert('로그인해주세요');
		window.open('../member/loginForm.action', 'loginWin', 'width=400,height=200,top=200,left=400');
		return;
	}
	alert('저장완료');
	$('#retext').val('');
	var boardnum = ${ board.boardnum };
	$.ajax({
		url:'getReplyInBaord.action',
		type:'post',
		dataType:'json',
		data:{boardnum : boardnum},
		success:reOutput
	});
}
function reOutput(json) {
	var loginid = '<s:property value="#session.id"/>';
	var str = '<table border="1">';
	var replynum = '';
	str += '<tr><td>내용</td><td>아이디</td><td>날짜</td><td>삭제</td>';
	for (var i = 0; i < json.replylist.length; i++) {
		str +='<tr><td>' + json.replylist[i].retext + '</td>';
		str +='<td>' + json.replylist[i].id + '</td>';
		str +='<td>' + json.replylist[i].inputdate + '</td>';
		if(loginid == json.replylist[i].id) {
			str +='<td>' + '<input type="button" class="delete" boardnum="'+ json.replylist[i].boardnum +'" replynum="' + json.replylist[i].replynum + '" value="X">' + '</td></tr>';
		}
		
	}
	str += '</table>';
	$('#replylist').html(str);
	$('.delete').click(replyDelete);
}

function replyDelete() {
	var replynum = $(this).attr('replynum');
	var boardnum = $(this).attr('boardnum');
	$.ajax({
		url:'deleteReplyInBaord.action',
		type:'post',
		dataType:'json',
		data:{replynum : replynum, boardnum : boardnum},
		success:reOutput
	});
}


</script>
	
</head>
<body>
<center>

<h2>[ 게시판 글읽기 ]</h2>

<table border="0" cellspacing="3" cellpadding="3" align="center" width="700">
<tr>
<th style="width:100px;">작성자 </th>
<td style="width:600px;">${board.id}</td>
</tr>
<tr>
<th>작성일 </th>
<td>${board.inputdate }</td>
</tr>
<tr>
<th>조회수 </th>
<td>${board.viewcount}</td>
</tr>
<tr>
<th>제목 </th>
<td>${board.title}</td>
</tr>
<tr>
<th>내용 </th> 
<td><pre>${board.content}</pre></td>
</tr>
<tr>
<th>파일첨부 </th> 
<td>
<s:if test="board.savedfile != null">
	<a href="<s:url value="/board/fileDownload.action?boardnum=" />${board.boardnum}">
		${board.originalfile} <img src="image/disk.gif" border="0" />
	</a>
</s:if>
</td>
</tr>
</table>

<!-- 본인 글인 경우에만 보이기 -->
<s:if test="#session.id == board.id">
	<!-- 현재글 삭제하기-->
	<a href="javascript:deleteCheck('${board.boardnum}')">삭제</a>
	<!-- 현재글 수정하기-->
	<a href="<s:url value="/board/goBoardEditForm.action?boardnum=" />${board.boardnum}">수정</a>
</s:if>

<!-- 목록보기-->
<a href="<s:url value="/board/boardlist.action" />">목록보기</a>

<br><br>

<!-- 리플 작성 폼 시작 -->
<form id="replyform">
	<input type="hidden" name="reply.id" value="${session.id }"><%-- <s:property value="#session.id"/> --%>
	<input type="hidden" name="reply.boardnum" value="${board.boardnum }">
	<input type="text" id="retext" name="reply.retext" style="width:500px;" />
	<input type="button" id="rebutton" value="저장" />
</form>
<!-- /리플 작성 폼 끝 -->


<br><br><br>
<div id="replylist"></div>
</center>
</body>
</html>
