<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<Style>
.circle {width:60px; height:60px; border-radius:200px; margin:0 auto; overflow:hidden;}
.circle img {height:auto; width:200px;}
.circle-img{display: inline-block;}
.login-join{display: inline-block;}
</Style>
<script>
 $(document).ready(function(){
	var id = "${session_id}";

/*  	if(id != '' && id != null){
		$.ajax({
			type : "post",
			url : "LoginMenu",
			data : {"id" : id},
			success : function(data){
				$("#LoginMenu").html(data);
			}
		})
	}else{
		$.ajax({
			type : "get",
			url : "LoginMenu",
			success : function(data){
				$("#LoginMenu").html(data);
			}
		})
	} */
}) 
</script> 
	<!-- Sidebar -->
	</div>
</div>
					<div id="sidebar">
						<div class="inner">

							<!-- Search -->
								<section id="search" class="alt">
									<form method="post" action="#">
										<input type="text" name="query" id="query" placeholder="Search" />
									</form>

<%-- <div class="circle-img" style="text-align: left; width: 60px; height: 60px;">
	<c:if test="${session_id != null && session_id != '' }">
		<img class="circle" src="${pageContext.request.contextPath}${USER.user_thumbimg }">
		${session_id }
	</c:if>
</div>
<div class="login-join" style="text-align: right;">
	<c:if test="${session_id !=null}">
		<a href="Logout">로그아웃</a>

			
			<a href="#" id="myPage_Btn">내 정보</a>
	
	</c:if>
	
	<c:if test="${session_id == null}">
		<a href="C_Login">로그인</a>
		<a href="C_Join">회원가입</a>
	</c:if>
</div> --%>
								</section>
							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										<li><a href="/app">Homepage</a></li>
										<li><a href="CM_TableList" id="">게시판</a></li>
										<li><a href="elements.html">이미지 게시판</a></li>
										
<!-- 										<li><a href="#">Etiam Dolore</a></li>
										<li><a href="#">Adipiscing</a></li>
										<li>
											<span class="opener">Another Submenu</span>
											<ul>
												<li><a href="#">Lorem Dolor</a></li>
												<li><a href="#">Ipsum Adipiscing</a></li>
												<li><a href="#">Tempus Magna</a></li>
												<li><a href="#">Feugiat Veroeros</a></li>
											</ul>
										</li>
										<li><a href="#">Maximus Erat</a></li>
										<li><a href="#">Sapien Mauris</a></li>
										<li><a href="#">Amet Lacinia</a></li> -->
									</ul>
								</nav>

							<!-- Section -->
<%-- <section>
	<header class="major">
		<h2>Best Img</h2>
	</header>
	<div class="mini-posts">
		<c:forEach items="${list }" var="list">
		<article>
			<a href="#" class="image"><img src="${pageContext.request.contextPath}${list.b_thumbimg }" alt="" /></a>
			<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
		</article>
		</c:forEach>
		<!-- <article>
			<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
			<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
		</article>
		<article>
			<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
			<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
		</article> -->
	</div>
	<ul class="actions">
		<li><a href="#" class="button">More</a></li>
	</ul>
</section> --%>

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>

						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>


	</body>
</html>