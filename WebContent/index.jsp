<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board</title>
<script type="text/javascript">
	//로그인 창 열기
	function openLoginForm() {
		window.open('member/loginForm.action', 'loginWin', 'width=400,height=200,top=200,left=400');
	}
	function openMemberForm() {
		window.open('member/memberForm.action', 'memberWin', 'width=400,height=200,top=200,left=400');
	}
	function openMemberUpdateForm() {
		var id = '${session.id}';
		window.open('member/memberupdateform.action?id=' + id, 'memberWin', 'width=400,height=200,top=200,left=400');
	}
	function out() {
		var id = '${session.id }';
		location.href="member/out.action?id=" + id;
		alert('탈퇴했습니다.');
	}
	function logout() {
		location.href="member/logout.action";
		alert('로그아웃했습니다.');
	}
</script>
</head>
<body>
<h1>[ board1 ]</h1>
<%-- <s:url value="/board/member.memberForm.action"/> --%>
<s:if test="#session.id != null">
	<s:property value="#session.id"/>님이 로그인중..<br>
	<a href="javascript:openMemberUpdateForm()">회원정보수정</a><br>
	<a href="javascript:out()">회원탈퇴</a><br>
	<a href="javascript:logout()">로그아웃</a><br>
</s:if>
<s:else>
	<a href="javascript:openMemberForm()">회원가입</a><br>
	<a href="javascript:openLoginForm()">로그인</a><br>
</s:else>
<a href="<s:url value="/board/boardlist.action"/>">게시판</a><br>
<!-- url태그는 절대경로를 써도 알아서 환경에 맞게 설정해 준다. -->
</body>
</html>