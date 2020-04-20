<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function fn_detail(b_num){
	$("#b_num").val(b_num);
	$("#frmDetail").submit();
}
</script>
<h4>댓글</h4>
<c:forEach items="${arr }" var="arr">
<dl>
	<dt>${arr.c_writer }</dt>
	<dd>
		<p>${arr.c_comment }</p>
	</dd>
</dl>
</c:forEach>