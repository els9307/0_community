<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
	<header class="major">
		<h2>Ante interdum</h2>
	</header>
	<c:forEach items="${list }" var="list">
	<div class="mini-posts">
		<article>
			<a href="#" class="image"><img src="${pageContext.request.contextPath}${list.b_thumbimg }" alt="" /></a>
			<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
		</article>
		<article>
			<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
			<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
		</article>
		<article>
			<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
			<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
		</article>
	</div>
	</c:forEach>
	<ul class="actions">
		<li><a href="#" class="button">More</a></li>
	</ul>
</section>