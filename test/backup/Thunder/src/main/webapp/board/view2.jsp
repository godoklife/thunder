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
		<!-- 이미지 업로드창 모달의 백그라운드 방해되서 음영처리 z-index:1050 ->> 1로 수정했음 -->
		<!-- .fullscreen ->> background-color: #ffffff 추가 -->
</head>
<body>
<%@include file="/header.jsp"%><!--  부스트스랩이랑 제이쿼리 CDN밖에 안들어있음 -->

	<div id="test">
		<div id="test2">
			
			<div id="map" style="width:600px;height:480px; z-index:1;">
			</div>	<!-- 나중에 반응형으로 해상도 조절 요망. 클라이언트 리소스 무지막지하게 잡아먹음 -->
		</div>
		<div class="row" >
			<div class="col-md-8" id="snote_div">
			
			<div class="col-sm-3"><input id="board_title" type="text" placeholder="제목 입력"></div>
				<div class="col-sm-3"><input type="text" id="product_price" placeholder="판매 가격"></div>
				<div class="col-sm-3"><select>
						<option id="product_qulity" value="미개봉">미개봉</option>
						<option id="product_qulity" value="거의 새 것">거의 새 것</option>
						<option id="product_qulity" value="사용감 있음">사용감 있음</option>
					</select></div>
				<div class="col-sm-3"><input type="button" onclick="submit()" value="등록하기"></div>
				<div><input type="button" onclick="sample4_execDaumPostcode()" value="지도찾기"></div>
				<div id="summernote"></div>
				<input type="text" id="sample4_postcode" placeholder="우편번호" value="">
				<input type="text" id="sample4_roadAddress" placeholder="도로명주소" value="">
				<input type="text" id="sample4_jibunAddress" placeholder="지번주소" value="">
				<input type="text" id="sample4_detailAddress" placeholder="상세주소" value="">
				<input type="text" id="sample4_extraAddress" placeholder="참고항목" value="">
			</div>
		</div>
	</div>
	
<!-- 다음 우편번호 API -->	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	
<!-- 카카오맵 API -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f7357ce81adbf018af6a38f1c214342&libraries=services,clusterer,drawing"></script>
<!-- summernote js -->
<script src="/Thunder/js/summernote/summernote-lite.js"></script>	<!--  언어팩보다 먼저 불러올것 -->
<script src="/Thunder/js/summernote/summernote-ko-KR.js"></script>
<!-- 사용자 정의 js -->
<script type="text/javascript" src="/Thunder/js/view2.js"></script>



</body>
</html>