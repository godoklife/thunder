let address="";
let productcoordinate="";
$(function(){
	kakaoMap(address);
	show_snote();
})


function show_snote(){
	// 이유는 모르겠으나 엔터키가 '잘' 안먹음. 고쳐야함... 
		// 여기로 옮기니 또 잘 되네>???
	$('#summernote').summernote({
		lang:'ko-KR',
		tabsize: 2,
		minHeight: 600,
		maxHeight: 600,
		callbacks:{
			onImageUpload: function(files){
				for(var i=0; i<files.length; i++){
					uploadSummernoteImageFile(files[i],this);
				}
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


// 게시글 저장, 유효성 검사 아직 없음.
function submit(){
	let boardtitle = $('#board_title').val();
	if(boardtitle==""){alert("제목을 입력하세요.");return;}
	
	
	let productqulity = $('#product_qulity').val();
	let productprice = $('#product_price').val();
	let productactive=1;
	
	let memberno = 1;	// 임시지정
	var summernoteContent = $('#summernote').summernote('code');
	console.log("작성한 내용 : "+summernoteContent);
	
	$.ajax({
		url:"SaveSummernote",
		data:{"summernoteContent":summernoteContent,
				"boardtitle":boardtitle,
				"boardcategory":1,
				"productqulity":productqulity,
				"productprice":productprice,
				"productcoordinate":productcoordinate,	// 전역변수로 선언되어있음
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






// 카카오맵 API
function kakaoMap(address){
	if(address==""){
		address="경기 안산시 상록구 이동 622-10";
	}
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch(address, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		productcoordinate = result[0].y+", "+result[0].x;
		console.log("수신한 좌표값 : "+productcoordinate);
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});
}


// 다음 우편번호 API
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            kakaoMap(roadAddr);
        }
    }).open();
}
