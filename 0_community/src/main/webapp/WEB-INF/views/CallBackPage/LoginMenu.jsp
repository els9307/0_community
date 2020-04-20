<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(function(){
		$("#myPage_Btn").click(function(){
			$("#frmInformation").submit();
		})
	})
</script>

<!-- 로그인부분 -->
<form action="CM_MyPage" method="post" id="frmInformation">
	<input type="hidden" name="user_id" value="${session_id }">
</form>
	<div style="text-align: right;">
	<div class="circle-img" style="text-align: left; width: 60px; height: 60px;">
		<c:if test="${session_id != null && session_id != '' }">
			<c:if test="${user.user_thumbimg != null && user.user_thumbimg != '' }">
				<img class="circle" src="${pageContext.request.contextPath}${user.user_thumbimg }">
			</c:if>
		</c:if>
	</div>
	<div class="login-join" style="text-align: right;">
		<c:if test="${session_id !=null}">
			<a href="Logout">로그아웃</a>
			<a href="#" id="myPage_Btn">내 정보</a>
		</c:if>
		<c:if test="${session_id == null}">
			<a href="CM_Login">로그인</a>
			<a href="CM_Join">회원가입</a>
		</c:if>
	</div>
	<div style="text-align: right;">
		<span>접속중인 아이디  : ${session_id }</span>
	</div>
</div>