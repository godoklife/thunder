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

	
	<div id="map" style="width:100vw;height:100vh; z-index:1; "></div>
	<!--  vh:viewport height, 부모와 상관없이 크기를 %단위로 설정.  -->
	
	
	
	
<!-- 카카오지도 API -->	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f7357ce81adbf018af6a38f1c214342&libraries=services,clusterer,drawing"></script>

<script type="text/javascript" src="/Thunder/js/map.js"></script>	
</body>
</html>