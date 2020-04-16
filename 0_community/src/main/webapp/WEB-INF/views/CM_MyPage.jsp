<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function(){

	$("#UserUpdate_Btn").click(function(){
		var passWord = $("#user_pwd").val();
		if(passWord != "" && passWord != null){
			$("#check").val("Y");
		}else{
			$("#check").val("N");
		}
		$("#frmUserUpdate").submit();
		alert("다시 로그인 해 주세요.");
	})
	$("#gdsImg").change(function(){
 		if(this.files && this.files[0]) {
  			var reader = new FileReader;
  			reader.onload = function(data) {
   			$(".select_img img").attr("src", data.target.result).width(300);        
  			}
  			reader.readAsDataURL(this.files[0]);
 		}
	});
})

</script>


<!-- Header -->
<header id="header">
	<a href="index.html" class="logo"><strong>MY PAGE</strong>마이페이지</a>
	<ul class="icons">
		<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
		<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
		<li><a href="#" class="icon fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
		<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
		<li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>
	</ul>
</header>
<!-- Form -->
	<h3>회원정보 수정</h3>
	<form method="post" action="UserUpdate" id="frmUserUpdate" enctype="multipart/form-data">
	<input type="hidden" id="check" name="check">
		<div class="row uniform">
			<div class="6u 12u$(xsmall)">
				<h3>아이디</h3>
				<input type="text" name="user_id" id="user_id" value="${user.user_id }" placeholder="Name" readonly="readonly"/>
			</div>
			<div class="mini-posts">
				<label for="gdsImg">이미지</label>
				 <div class="select_img"><img src="${pageContext.request.contextPath}${user.user_thumbimg }" /></div>
				<input type="file" id="gdsImg" name="file" />
			<%-- 	<%=request.getRealPath("/") %> --%>
			</div>
			<div class="6u$ 12u$(xsmall)">
				<h3>이메일</h3>
				<input type="email" name="user_email" id="user_email" value="${user.user_email }" placeholder="Email" />
			</div>
			<div class="6u 12u$(xsmall)">
				<h3>이름</h3>
				<input type="text" name="user_name" id="user_name" value="${user.user_name }" placeholder="Name" />
			</div>
			<div class="6u$ 12u$(xsmall)">
				<h3>닉네임</h3>
				<input type="text" name="user_nickname" id="user_nickname" value="${user.user_nickname }" placeholder="Email" />
			</div>
			
			<div class="6u 12u$(xsmall)">
				<h3>비밀번호</h3>
				<input type="password" name="user_pwd" id="user_pwd" value="" placeholder="password" />
				<input type="password" name="user_pwd_check" id="user_pwd_check" value="" placeholder="password_Check" />
			</div>
			<!-- Break -->
			<div class="12u$">
				<ul class="actions">
					<li><input type="button" value="정보수정하기" id="UserUpdate_Btn" class="special" /></li>
					<li><input type="reset" value="회원탈퇴" /></li>
				</ul>
			</div>
		</div>
	</form>
									
			