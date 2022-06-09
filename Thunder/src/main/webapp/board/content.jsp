<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/header.jsp"%><!--  부스트스랩이랑 제이쿼리 CDN밖에 안들어있음 -->
	<%session.getAttribute("boardpkno")%>
	<div class="container">
		<table class="table">
			<tr>
				<td width="25%">번호 : </td>
				<td width="25%">작성자 : </td>
				<td width="25%">작성일 : </td>
				<td width="25%">조회수 : </td>
			</tr>
			<tr>
				<td width="25%">판매상태 : </td>
				<td width="25%">물품상태 : </td>
				<td width="25%">판매가격 : </td>
				<td width="25%">판매지역 : </td>
			</tr>
			<tr>
				<td colspan="4">	<!--  colspan : 열 병합 // rowspan : 행 병합 -->
					<div class="boardview_content">
						
						<img src="" width=100%><br>
					</div>
				</td>
			</tr>
			<tr>
					<td colspan="4"><a href="Filedown?bfile=">다운받을 이미지주소위치</a></td>
			</tr>
		</table>
	</div>


<script type="text/javascript" src="/Thunder/js/content.js"></script>
</body>
</html>