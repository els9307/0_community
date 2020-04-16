<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(function(){
		$.ajax({
			type : "post",
			url : "IndexList",
			data : {user_id : "${session_id}"},
			success : function(data){
				$("#IndexList").html(data);
			}
		})
			$("#myPage_Btn").click(function(){
		$("#frmInformation").submit();
	})
	})
</script>
<!-- Main -->

	

			<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>Main Page</strong> 메인 </a>
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>
					</ul>
				</header>
				<!-- Content -->
				<div id="IndexList"></div>

		