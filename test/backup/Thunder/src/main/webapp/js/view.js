$(function(){
	kakaoMap();
})


function kakaoMap(){
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
}




function makehogang(){
	// 로그인 검사는 나중에 만들자.
	let html=	'<div class="col-sm-3"><input id="board_title" type="text" placeholder="제목 입력"></div>'+
				'<div class="col-sm-3"><input type="text" id="product_price" placeholder="판매 가격"></div>'+
				'<div class="col-sm-3"><select>'+
						'<option id="product_qulity" value="미개봉">미개봉</option>'+
						'<option id="product_qulity" value="거의 새 것">거의 새 것</option>'+
						'<option id="product_qulity" value="사용감 있음">사용감 있음</option>'+
					'</select></div>'+
				'<div class="col-sm-3"><input type="button" onclick="submit()" value="등록하기"></div>'+
				'<div><input type="button" onclick="sample4_execDaumPostcode()" value="지도찾기"></div>'+
				'<div id="summernote"></div>'+
				'<input type="hidden" id="sample4_postcode" placeholder="우편번호" value="">'+
				'<input type="hidden" id="sample4_roadAddress" placeholder="도로명주소" value="">'+
				'<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소" value="">'+
				'<input type="hidden" id="sample4_detailAddress" placeholder="상세주소" value="">'+
				'<input type="hidden" id="sample4_extraAddress" placeholder="참고항목" value="">';
					
	$('#snote_div').html(html);
	show_snote();
}
$("#sample4_postcode").change(function(){
	alert("asdasdasd");
})


function show_snote(){
	// 이유는 모르겠으나 엔터키가 '잘' 안먹음. 고쳐야함...
	$('#summernote').summernote({
		lang:'ko-KR',
		tabsize: 2,
		minHeight: 600,
		maxHeight: 600,
		callbacks:{
			onImageUpload: function(files){
				for(var i=0; i<files.length; i++)
				uploadSummernoteImageFile(files[i],this);
			},
			onPaste: function(e){
				var clipboardData = e.originalEvent.clipboardData;
				if(clipboardData && clipboardData.items && clipboardData.items.length) {
					var item = clipboardData.items[0];
					if(item.kind==='file' && item.type.indexOf('image/')!==-1){
						e.preventDefault();
					}
				}
			}
		}
	});
	function uploadSummernoteImageFile(file, editor) {
		data = new FormData();
		data.append("file", file);
		console.log(file);
		$.ajax({
			data : data,
			type : "POST",
			enctype : "multipart/form-data",
			url : "SummernoteImgUpload",	// 그냥 모든 board 공용 서블릿으로 써도 될거같은데?? 확인해보기
			contentType : false,
			processData : false,
			success : function(args) {
				var json = args
            	//항상 업로드된 파일의 url이 있어야 한다.
            	console.log(json);
				$(editor).summernote('insertImage', json['url']);
			}
		});
	};
};

// 써머노트 이외의 구역을 클릭하면 닫는 메서드
$(document).mouseup(function(e){
	var div= $("#snote_div");
	let html=div.html();
	if((html.indexOf('summernote'))==-1){	// 써머노트가 실행되기 전이면 더이상 명령을 실행하지 않음
		return;
	};
	
	if(div.has(e.target).length!==0){		// 마우스가 써머노트div 바깥을 누르면 리턴 패스
		return;
	};
	if(confirm("글 등록을 종료하시겠습니까?")){		// 사용자가 확인버튼 누르면 div를 비움
		let clearHtml="";
		div.html(clearHtml);	
	}
});

// 게시글 저장, 유효성 검사 아직 없음.
function submit(){
	let boardtitle = $('#board_title').val();
	if(boardtitle==""){alert("제목을 입력하세요.");return;}
	
	
	let productqulity = $('#product_qulity').val();
	let productprice = $('#product_price').val();
	let productcoordinate = "";
	let productactive=1;
	
	let memberno = 1;	// 임시지정
	var summernoteContent = $('#summernote').summernote('code');
	console.log("작성한 내용 : "+summernoteContent);
	alert("콘솔로그를 확인하시오.");
	
	$.ajax({
		url:"SaveSummernote",
		data:{"summernoteContent":summernoteContent,
				"boardtitle":boardtitle,
				"boardcategory":1,
				"productqulity":productqulity,
				"productprice":productprice,
				"productcoordinate":productcoordinate,
				"productactive":productactive,
				"memberno":memberno
				},
		type:"POST",
		enctype:"UTF-8",
		success:function(args){
			if(args==1){
				alert("정상적으로 등록했습니다.");
				window.history.back();	// 뒤로가기가 아니라 작성글 보기로 수정할것
			}else if(args==0){
				alert("등록에 실패했습니다.");
			}
		}
	})
};
