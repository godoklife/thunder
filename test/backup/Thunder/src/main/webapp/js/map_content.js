let map_content_json;

$(function(){
	let parameter = (location.search).split('=',2)[1];	// get방식으로 넘어온 게시글번호
	showcontent(parameter);
});

function showcontent(boardpkno){
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


function showmap(){
	console.log("저장된 좌표값 :"+map_content_json['productcoordinate']);
	kakaoMap(map_content_json['productcoordinate'])
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




















function kakaoMap(address){
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(address.split(', ',2)[0], address.split(', ',2)[1]),
		level: 3
	};
	var map = new kakao.maps.Map(container, options);
}