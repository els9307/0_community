<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


			<section>		
				<div class="row 200%">
					<div class="6u 12u$(medium)">
						<!-- Lists -->
						<div class="row">
							<div class="6u 12u$(small)">
							</div>
							<div class="6u$ 12u$(small)">
								<h4>Best 인기글</h4>
								<ol>
									<c:forEach items="${index }" var="index">
									<li>${index.b_subject }</li>
									</c:forEach>
								</ol>

							</div>
						</div>
					</div>
					<div class="6u$ 12u$(medium)">
						<!-- Image -->
						<h3>인기 이미지</h3>
						<div class="box alt">
							<div class="row 50% uniform">
							<c:forEach items="${index }" var="index">
								<div class="4u"><span class="image fit"><img src="${pageContext.request.contextPath}${index.b_thumbimg }" alt="" /></span></div>
							</c:forEach>
							</div>
						</div>
<!-- 						<div class="box alt">
							<div class="row 50% uniform">
								<div class="4u"><span class="image fit"><img src="images/pic01.jpg" alt="" /></span></div>
								<div class="4u"><span class="image fit"><img src="images/pic02.jpg" alt="" /></span></div>
								<div class="4u$"><span class="image fit"><img src="images/pic03.jpg" alt="" /></span></div>
								Break
								<div class="4u"><span class="image fit"><img src="images/pic03.jpg" alt="" /></span></div>
								<div class="4u"><span class="image fit"><img src="images/pic01.jpg" alt="" /></span></div>
								<div class="4u$"><span class="image fit"><img src="images/pic02.jpg" alt="" /></span></div>
								Break
								<div class="4u"><span class="image fit"><img src="images/pic02.jpg" alt="" /></span></div>
								<div class="4u"><span class="image fit"><img src="images/pic03.jpg" alt="" /></span></div>
								<div class="4u$"><span class="image fit"><img src="images/pic01.jpg" alt="" /></span></div>
							</div>
						</div> -->
					</div>
				</div>
		</section>