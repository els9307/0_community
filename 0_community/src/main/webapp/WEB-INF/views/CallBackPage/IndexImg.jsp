<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.IndexImgView{
		width: 300px;
		height: 200px;
		cursor: pointer;
	}
</style>
<script>
function fn_IndexImgClick(b_num){
	$("#frmDetile").submit();	
}
</script>

	<div class="box alt">
		<div class="row 50% uniform">
		<c:forEach items="${arr}" var="arr">
			<div class="4u">
			<form action="CB_TableDetilView" method="post" id="frmDetile">
				<span class="image fit">
					<input type="hidden" id="b_num" name="b_num" value="${arr.b_num }">
					<input type="hidden" name="U_check" value="1">
					<img src="${pageContext.request.contextPath}${arr.b_thumbimg }"  alt="" class="IndexImgView"
					onclick="javascript:fn_IndexImgClick('${arr.b_num}')"/>
				</span>
				</form>
			</div>
			<!-- Break -->
			</c:forEach>
		</div>
	</div>


