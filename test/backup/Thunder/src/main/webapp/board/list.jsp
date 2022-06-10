<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  해더 영역 -->
	<%@include file="../header.jsp" %>
	<div class = "container">
		<h4> 게시물출력부 </h4>
		
		
		
		
		<div class="row mb-2">
			<div class="col-md-1">
				<a href="/Thunder/main.jsp"><button class="form-control">main.jsp</button></a>
			</div>
			<div class="col-md-1">
				<a href="#"><button class="form-control">인기글</button></a>
			</div>
			
				
			
				<div class="col-md-1 offset-9">
					<button disabled="disabled" class="form-control" style="background-color: gray;">글쓰기</button>
				</div>
			
		</div>
		<table id="showboardlist" class="table table-hover text-center">
			
		
		</table>

		<!--  ----------------- 페이지 남바 입력 구역 -----------------  -->
		<div class="col-md-6 offset-3 d-flex justify-content-center">
			<ul class="pagination">
				
			</ul>
		</div>
		<!--  ----------------- 검색바 입력 구역 -----------------  -->
		<form action = "boardlist.jsp?pagenum"ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇ"" class= "col-md-4 offset-4 d-flex justify-content-center">
			<div class="col-md-3">	<!--  키워드 선택 버튼 -->
				<select class="form-select" name="key">	<!-- 검색할 필드 선택 -->
					<option value="btitle"> 제목 </option>
					<option value="bcontent"> 내용 </option>
					<option value="mid"> 작성자 </option>
				</select>
			</div>
			<div class="col-md-7">	<!-- 입력바 -->
				<input type="text" class="form-control" name="keyword">	<!-- 검색할 해당 필드의 값 -->
			</div>
			<div class="col-md-2">
				<input type="submit" class="form-control" value="검색">
			</div>
		</form>
	</div>
<script type="text/javascript" src="/Thunder/js/list.js"></script>
</body>
</html>