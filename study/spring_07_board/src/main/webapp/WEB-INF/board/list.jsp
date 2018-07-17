<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" name="frm" method="get" action="write.sb">
		<input type="submit" id="btnWrite" value="글쓰기" />
	</form>

	<div id="bodywrap">
		<!-- list 출력 -->
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
			</tr>
			
			<c:forEach var="dto" items="${aList}">
				<tr>
					<td>${dto.num}</td>
					<td><a href="view.sb?currentPage=${pv.currentPage}&num=${dto.num}">${dto.subject}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.readcount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<!-- 이전(PREV) -->
	<c:if test="${pv.startPage>1}">
		<c:choose>
			<c:when test="${pv.searchKey != null && pv.searchKey ne all}">
				<a href="list.sb?currentPage=${pv.startPage-pv.blockPage}&searchKey=${pv.searchKey}&searchWord=${pv.searchWord}"><span>PREV</span></a>
			</c:when>
			<c:otherwise>
				<a href="list.sb?currentPage=${pv.startPage-pv.blockPage}"><span>PREV</span></a>
			</c:otherwise>
		</c:choose>
	</c:if>

	<!-- 페이지 -->
	<c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
		<c:choose>
			<c:when test="${page == i}">
				<span>${i}</span>
			</c:when>
			<c:when test="${pv.searchKey == null && pv.searchKey ne all}">
				<a href="list.sb?currentPage=${i}"><span>${i}</span></a>
			</c:when>
			<c:otherwise>
				<a href="list.sb?currentPage=${i}&searchKey=${pv.searchKey}&searchWord=${pv.searchWord}"><span>${i}</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<!-- 다음(NEXT) -->
	<c:if test="${pv.endPage<pv.totalPage}">
		<c:choose>
			<c:when test="${pv.searchKey != null && pv.searchKey ne all}">
				<a
					href="list.sb?currentPage=${pv.startPage+pv.blockPage}&searchKey=${pv.searchKey}&searchWord=${pv.searchWord}"><span>NEXT</span></a>
			</c:when>
			<c:otherwise>
				<a href="list.sb?currentPage=${pv.startPage+pv.blockPage}"><span>NEXT</span></a>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>
