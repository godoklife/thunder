var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴


function makehogang(){
	// 로그인 검사는 나중에 만들자.
	let html=	'<div id="summernote"></div>';
	$('#snotediv').html(html);
	show_snote()
	
	
}

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
