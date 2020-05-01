<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function fn_detail(b_num){
	$("#b_num").val(b_num);
	$("#frmDetail").submit();
}
</script>
<form action="CB_TableDetilView" method="post" id="frmDetail">
	<input type="hidden" id="b_num" name="b_num">
	<input type="hidden" id="U_check" name="U_check" value="1"> 
	<input type="hidden" id= "id" name="id" value="${session_id }">
</form>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${arr }" var="arr" varStatus="status">
		
		<tr>
			<th style="width: 10%">${boardNum + status.index}</th>
			<c:if test="${arr.report_count > 6 }">
				<th style="width: 60%" >[신고누적]블라인드처리된 게시물 입니다.</th>
			</c:if>
			<c:if test="${arr.report_count < 6 }">
				<%-- <th style="width: 60%" ><a href="tableDetailView?b_num=${arr.b_num }" >${arr.b_category}${arr.b_subject }</a></th> --%>
				<th style="width: 60%" ><a href="javascript:fn_detail('${arr.b_num }')" >[${arr.b_category}]${arr.b_subject }</a></th>
			</c:if>
			<th class="opener"style="width: 15%">${arr.user_id }</th>
			<th style="width: 15%">${arr.reg_date }</th>
		</tr>
		
	</c:forEach>	
	</tbody>
	<tfoot>
		
	</tfoot>
</table>
<div style="text-align: center;">
	${pageHtml }
</div>
