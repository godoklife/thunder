<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


	<!-- summernote-lite css -->
	<link href="/Thunder/css/summernote/summernote-lite.css" rel="stylesheet">
</head>
<body>
<%@include file="/header.jsp"%><!--  부스트스랩이랑 제이쿼리 CDN밖에 안들어있음 -->
<%	
	
//	if(session.getAttribute("user")!=null){	// 사용자가 로그인 상태라면
//		Member member = (Member)session.getAttribute("user");
//	}

%>
	<div id="test">
		<div id="test2">
			<button class="zindex2_btn" onclick="makehogang()"> 내꺼도 중고로 팔기! </button>
			
			<div id="map" style="width:3840px;height:2400px; z-index:1;">
			</div>	<!-- 나중에 반응형으로 해상도 조절 요망. 클라이언트 리소스 무지막지하게 잡아먹음 -->
		</div>
		<div class="zindex2_div left_position" id="snotediv">
		
		</div>
	</div>
	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f7357ce81adbf018af6a38f1c214342"></script>
<!-- summernote js -->
<script src="/Thunder/js/summernote/summernote-lite.js"></script>	<!--  언어팩보다 먼저 불러올것 -->
<script src="/Thunder/js/summernote/summernote-ko-KR.js"></script>
<!-- 사용자 정의 js -->
<script type="text/javascript" src="/Thunder/js/view.js"></script>

</body>
</html>