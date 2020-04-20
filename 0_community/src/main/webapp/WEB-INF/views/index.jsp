<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(function(){
		$.ajax({
			type : "post",
			url : "IndexList",
			data : {"check" : "1"},
			success : function(data){
				$("#IndexList").html(data);
			}
		})
		$.ajax({
			type : "post",
			url : "IndexList",
			data : {"check" : "2"},
			success : function(data){
				$("#IndexImg").html(data);
			}
		})
			$("#myPage_Btn").click(function(){
		$("#frmInformation").submit();
	})
		$("#DOG_Btn").click(function(){
			$("#index_opener").trigger("click");
			var category = $("#DOG").val();
			fn_Category(category);
		})
		$("#CAT_Btn").click(function(){
			$("#index_opener").trigger("click");
			var category = $("#CAT").val();
			fn_Category(category);
		}) 
		$("#ETC_Btn").click(function(){
			$("#index_opener").trigger("click");
			var category = $("#ETC").val();
			alert("ETC" + $("#ETC").val());
			fn_Category(category);
		}) 
		
function fn_Category(category){
			$("#Guide").hide();
			$.ajax({
				type : "post",
				url : "Category",
				data : {"b_category" : category},
				success : function(data){
					$("#categoryCallBack").html(data);
				}
			}) 
		}
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
<section>
<!-- Image -->

<header class="main">
	<!-- Image -->
	<h3>Best 이미지 </h3>
	<div class="box alt">
		<div class="row 50% uniform">
			<div id="IndexImg"></div>
		</div>
	</div>

</header>

<hr class="major" />

<!-- Elements -->
<div class="row 200%">
	<div class="6u 12u$(medium)">
		<!-- Lists -->
			<div class="row">
				<div class="6u 12u$(small)">
						<nav id="menu">
							<header class="major">
							</header>
							<ul>
								<li>
									<span class="opener" id="index_opener" style="background: gray; color: white;" >분류별</span>
									<ul>
										<li><a href="#" id="DOG_Btn"><input type="hidden" id="DOG" value="DOG">DOG</a></li>
										<li><a href="#" id="CAT_Btn"><input type="hidden" id="CAT" value="CAT">CAT</a></li>
										<li><a href="#" id="ETC_Btn"><input type="hidden" id="ETC" value="ETC">ETC</a></li>
									</ul>
								</li>
							</ul>
							
						</nav>
							<ul id="Guide">
								<li>카테고리 선택!</li>
							</ul>
						<div id="categoryCallBack"></div>
						
				</div>
				<div class="6u$ 12u$(small)">
				</div>
			</div>
</div>
											
											
<!-- 오른쪽 뷰  -->
	<div class="6u$ 12u$(medium)">
		<h4>인기글</h4>
		<div id="IndexList"></div>
	</div>
</div>

</section>