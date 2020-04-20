<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#IndexListSubJect{
		cursor: pointer;
	}
</style>
<script>
$(document).ready(function(){
	$("#IndexListSubJect").click(function(){
		$("#frmDetile1").submit();
	})
})
</script>

<ul class="alt">
	<c:forEach items="${arr }" var="arr">
		<form action="CB_TableDetilView" method="post" id="frmDetile1">
		<input type="hidden" id="b_num" name="b_num" value="${arr.b_num }">
		<input type="hidden" name="U_check" value="1">
			<li id="IndexListSubJect">${arr.b_subject }</li>
		</form>
	</c:forEach>
</ul>