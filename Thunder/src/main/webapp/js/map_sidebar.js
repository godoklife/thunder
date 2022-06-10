let jsAr;

function pagechange( boardpkno ){
	$("#right_sidebar").animate({width:"50vw"},200);
	showContent(boardpkno);
	//$("#right_sidebar").load( '/Thunder/board/content.jsp?no='+boardpkno);
};

$(function(){
	getboardlist(1)	// 일단 보드카테고리 하드코딩.
});

function getboardlist(boardcategory){
	let html=	'<tr>'+
					'<th width="10%">번호</th><th width="45%">제목</th><th width="17%">작성자</th><th width="8%">조회수</th><th width="20%">작성일</th>'+
				'</tr>';
	$.ajax({
		url:"board/GetBoardList",
		data:{"boardcategory":boardcategory},
		success:function(args){
			console.log(args.length);
			if(args.length==0){
				html+=	'<tr>'+
							'<td style="text-align:center!important;" colspan="5"> 게시글이 없습니다. 첫번째 글의 영예를 차지해 보세요!</td>'+
						'</tr>';
				$("#showboardlist").html(html);
				return;		
			}else{
				jsAr=args;
				console.log(jsAr.length);
				for(let blf=jsAr.length-1; blf>=0; blf--){
					html+=	'<tr>'+
								'<td>'+jsAr[blf]['boardcategoryno']+'</td>'+
								//'<td class="boardlist_title" onclick="showct('+jsAr[blf]['boardpkno']+')">'+jsAr[blf]['boardtitle']+'</a></td>'+
								'<td class="boardlist_title" onclick="pagechange('+jsAr[blf]['boardpkno']+')">'+jsAr[blf]['boardtitle']+'</a></td>'+
								'<td>'+jsAr[blf]['memberno']+'</td>'+	// 제품명으로 바꿔야할듯
								'<td>'+jsAr[blf]['boardviewcount']+'</td>'+
								'<td>'+jsAr[blf]['boarddatetime']+'</td>'+
							'</tr>';
				}
				$("#showboardlist").html(html);
			}
		}
	});
};

function showct(boardpkno){
	$.ajax({	// 조회수 증가 처리용 비동기통신
		url:"board/Viewcnt",
		data:{"boardpkno":boardpkno}
	})
	//window.location.href="/Thunder/board/content.jsp?no="+boardpkno;
	
};

function showContent(boardpkno){
	let cntHtml='';
	$("#right_html").html(cntHtml);	// 우측사이드바 비워주기
	
	cntHtml+=	'<table class="table">'+
				'</table>';
	$.ajax({
		url:"",
		data:{}
	})
	
};


