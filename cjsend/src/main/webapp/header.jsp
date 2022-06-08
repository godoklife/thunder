<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 사용자 정의 CSS -->
<link href="/mohae/css/header1.css" rel="stylesheet">
<link href="/mohae/css/main.css" rel="stylesheet">
<!--  부트스트랩 CSS CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
		<section class="navigation">
			<div class="nav-container">
				<div class="brand">
					<a href="/mohae/main1.jsp">모해모해</a>
				</div>
				<nav>
					<div class="nav-mobile">
						<a id="nav-toggle" href="#!"><span></span></a>
					</div>
					<ul class="nav-list">
						<li><a href="#!">모해모해??</a></li>
						<li><a href="#!">모해</a>
							<ul class="nav-dropdown">
								<li><a href="#!">와줘</a></li>
								<li><a href="#!">해줘</a></li>
							</ul></li>
						<li><a href="#!">커뮤니티</a>
							<ul class="nav-dropdown">
								<li><a href="/mohae/board/board.jsp">자유게시판</a></li>
								<li><a href="#!">여행후기</a></li>
							</ul>
						</li>	
						<li><a href="#!">고객센터</a>
							<ul class="nav-dropdown">
								<li><a href="/mohae/board/notice.jsp">공지사항</a></li>
								<li><a href="/mohae/board/qna.jsp">QnA</a></li>
								<li><a href="#!">실시간 상담</a></li>
							</ul>
						</li>
						<li>
							<a href="/mohae/member/login.jsp">로그인</a>
						</li>	
						
					</ul>
				</nav>
			</div>
		</section>

<!-- jquery 최신 cdn -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 부트스트랩 cdn -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/mohae/js/header1.js"></script>

</body>
</html>