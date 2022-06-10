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
	<div class="container">
		<table class="table">
			<tr>
				<td width="25%">번호 : <span id="bcno"></span></td>
				<td width="25%">작성자 : <span id="bwter"></span></td>
				<td width="25%">작성일 : <span id="bdate"></span></td>
				<td width="25%">조회수 : <span id="bcnt"></span></td>
			</tr>
			<tr>
				<td width="25%">판매상태 : <span id="pactv"></span></td>
				<td width="25%">물품상태 : <span id="pqty"></span></td>
				<td width="25%">판매가격 : <span id="ppri"></span></td>
				<td width="25%">판매지역 : <span id="ploc"></span></td>
			</tr>
			<tr>
				<td colspan="4">	<!--  colspan : 열 병합 // rowspan : 행 병합 -->
					<div id="bctn" class="boardview_content">
						
					</div>
				</td>
			</tr>
			<tr>
				 <td colspan="4">
				 	<button onclick="showmap()">위치 확인하기!</button>
				 	<button onclick="del_content()">글 삭제</button>
				 </td>
			</tr>
		</table>
	</div>
	
	<div id="map" style="width:600px;height:480px; z-index:1;">
	</div>	<!-- 나중에 반응형으로 해상도 조절 요망. 클라이언트 리소스 무지막지하게 잡아먹음 -->

<!-- 카카오맵 API -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f7357ce81adbf018af6a38f1c214342&libraries=services,clusterer,drawing"></script>


<script type="text/javascript" src="/Thunder/js/content.js"></script>
</body>
</html>