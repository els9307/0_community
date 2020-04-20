<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#categoryList{
		cursor: pointer;	
	}
</style>
<script>
function fn_categoryList(){
	$("#frmDetile2").submit();
}

</script>

	<ul>
		<c:forEach items="${arr }" var="arr">	
		<form action="CB_TableDetilView" method="post" id="frmDetile2">
		<input type="hidden" name="U_check" value="1">
		<input type="hidden" id="b_num" name="b_num" value="${arr.b_num }">
			<li id="categoryList" onclick="javascript:fn_categoryList()">${arr.b_subject }</li>
		</form>
		</c:forEach>
	</ul>
