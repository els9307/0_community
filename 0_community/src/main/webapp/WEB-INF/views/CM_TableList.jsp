<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
function page(pageNum,word){
	$.ajax({
		type : "post",
		url : "CM_TableList",
		data : {"word" : $("#word").val(),
				"pageNum" : pageNum},
		success : function(data){
			$("#TableList_CB").html(data);
		}
	})
}

 	$(document).ready(function(){
		$.ajax({
			type : "post",
			url : "CM_TableList",
			success : function(data){
				$("#TableList_CB").html(data);
			}
		})
		
		$("#search").click(function(){
			$.ajax({
				type : "post",
				url : "CM_TableList",
				data : {"word" : $("#word").val()},
				success : function(data){
					$("#TableList_CB").html(data);
				}
			})
		})
	})
</script>
<!-- Main -->
<div id="main">
	<div class="inner">
		<!-- Header -->
		<header id="header">
			<a href="index.html" class="logo">
				<strong>게시판</strong>
			</a>
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>
			</ul>
		</header>
		<!-- Table -->
		<div class="table-wrapper">
			<div id="TableList_CB"></div>
		</div>
		<div style="text-align: right;">
			<input type="text" id="word" name="word" style="width: 15%;height:30%; display: inline;">
			<input type="button" id="search" class="button special small" value="검색" >
		</div>
		<div style="text-align: right;">
			<a href="CM_TableInsert" class="button small"  >글쓰기</a>
		</div>
	</div>
</div>

