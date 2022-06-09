let jsonArray;

$(function(){
	getboardlist(1)	// 일단 보드카테고리 하드코딩.
});

function getboardlist(boardcategory){
	let html=	'<tr>'+
					'<th width="10%">번호</th><th width="45%">제목</th><th width="17%">작성자</th><th width="8%">조회수</th><th width="20%">작성일</th>'+
				'</tr>';
	$.ajax({
		url:"GetBoardList",
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
				jsonArray=args;
				console.log(jsonArray.length);
				for(let blf=jsonArray.length-1; blf>=0; blf--){
					html+=	'<tr>'+
								'<td>'+jsonArray[blf]['boardcategoryno']+'</td>'+
								'<td class="boardlist_title"><a href="/Thunder/board/content.jsp?no='+jsonArray[blf]['boardpkno']+'">'+jsonArray[blf]['boardtitle']+'</a></td>'+
								'<td>'+jsonArray[blf]['memberno']+'</td>'+	// 제품명으로 바꿔야할듯
								'<td>'+jsonArray[blf]['boardviewcount']+'</td>'+
								'<td>'+jsonArray[blf]['boarddatetime']+'</td>'+
							'</tr>';
				}
				$("#showboardlist").html(html);
			}
		}
	});
};
