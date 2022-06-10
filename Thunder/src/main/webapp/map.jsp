<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>

	<!--  모든 div의 스타일은 header.jsp의 css에 들어있읍니다. -->
	<div id="map">
		<!--  다음 지도 생성 구역 -->
	</div>
	
	<div id="right_sidebar"><!--   -->
		<!--  우측 매뉴 출력 구역 -->
	</div>
	
	
<!-- 카카오지도 API -->	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f7357ce81adbf018af6a38f1c214342&libraries=services,clusterer,drawing"></script>

<script type="text/javascript" src="/Thunder/js/map.js"></script>	
<script type="text/javascript" src="/Thunder/js/map_sidebar.js"></script>
<script type="text/javascript" src="/Thunder/js/map_content.js"></script>
</body>
</html>