let jsonArray;	// 지도에 뿌릴 좌표가 담긴 제이슨
let json;		// 게시글이 담긴 제이슨
var mapContainer = document.getElementById('map');
let html="";
$(function(){
	markedMap();	// 지도 그리기 메서드 호출
	makeSidebarTable();	// 오른쪽 사이드바 그리기 호출
});

window.addEventListener('resize',resizeMap());	
	// 브라우저 창이 바뀌면 다음 지도 크기도 리사이징. 반복실행 제한 추가해야필요.(현재 제한 미지정.->> 리소스 무지막지하게 먹음)

// 지도 '클릭'하면 사이드바 크기만 줄어드는 메서드
$(document).mouseup(function(e){
	var r_bar= $("#right_sidebar");
	let r_bar_html=r_bar.html();
	if((r_bar_html.indexOf('boardview_content'))!=-1){	// 써머노트가 실행되기 전이면 더이상 명령을 실행하지 않음
		
		$("#right_sidebar").animate({width:"25vw"},200);
		
	};
	
});

function makeSidebarTable(){
		
		 html=	'<div class="row" id="tv">'+
						'<table id="showboardlist" class="table table-hover text-center">'+
						'</table>'+
					'</div>';
		$("#right_sidebar").html(html);			
};

/////////////////////////////////
// map_sidebar.js에서 이사옴

function pagechange( boardpkno ){
	$("#right_sidebar").animate({width:"50vw"},200);
	$("#right_sidebar").load( '/Thunder/board/content.jsp');
	
	showct(boardpkno);
	showContent(boardpkno);
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
};

function showContent(boardpkno){

				
	$.ajax({
		url:"board/ViewContent",
		data:{"boardpkno":boardpkno},
		success:function(args){
			if(args===null){
				alert("존재하지 않는 글 입니다!");
				window.history.back();
				return;
			}
			map_content_json=args;
			console.log(map_content_json);
			$("#bcno").html(map_content_json['boardcategoryno']);
			$("#bwter").html(map_content_json['memberno']);
			$("#bdate").html(map_content_json['boarddatetime']);
			$("#bcnt").html(map_content_json['boardviewcount']);
			$("#pactv").html(map_content_json['productactive']);
			$("#pqty").html(map_content_json['productqulity']);
			$("#ppri").html(map_content_json['productprice']);
			$("#ploc").html(map_content_json['productcoordinate']);	
				// 이건 다음지도 함수 통해 리턴받은 값을 출력해야 할거 같은데??
				
			$("#bctn").html(map_content_json['boardcontent']);
			//$("#bmap").html(map_content_json['boardcategoryno']); 아직 미구현, 지도표시
		}
	})
};

function del_content(){	// 인수로 세션의 회원번호나 전화번로 받아서 검증해야함.

	//if(서버세션에 있는 회원전화번호!=map_content_json['memberphone']){return;}
	if(confirm("정말 글을 삭제하시겠습니까?")){
		$.ajax({
			url:"board/DeleteContent",
			data:{"boardpkno":map_content_json['boardpkno']},
			success:function(args){
				console.log(args);
				if(args===true){
					alert("삭제했습니다.");
					window.history.back();	// 뒤 페이지로가기
				}else if(args===false){
					alert("예외가 발생했습니다. 로그 확인 필요.");
				}
			}
		})
	}
};
//////////////////////////////////////////////////////////////////////////////













function markedMap(){
	var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(37.3092103, 126.852859), // 지도의 중심좌표 
    level : 8 // 지도의 확대 레벨 
});
	   
	// 마커 클러스터러를 생성합니다 
	var clusterer = new kakao.maps.MarkerClusterer({
	    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
	    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
	        minLevel: 10 // 클러스터 할 최소 지도 레벨 
	});
	 
	// 데이터를 가져오기 위해 jQuery를 사용합니다
	// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
	$.get("GetLatLng", function(data) {
	    // 데이터에서 좌표 값을 가지고 마커를 표시합니다
	    // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
	    var markers = $(data.positions).map(function(i, position) {
      var marker = new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position.lat, position.lng)
                
            });
            
              kakao.maps.event.addListener(marker, 'click', function() {  
					console.log("사용자가 클릭한 boardpkno : "+position.boardpkno);
					pagechange(position.boardpkno);
				});
            
	        return marker;
	    });
	
	    // 클러스터러에 마커들을 추가합니다
	    clusterer.addMarkers(markers);
	});
	
};

function resizeMap() {
    mapContainer.style.width = '75vw';
    mapContainer.style.height = '100vh'; 
};

function relayout() {    
    
    // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
    // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다 
    // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
    map.relayout();
};
