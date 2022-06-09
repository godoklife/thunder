let jsonArray;

$(function(){
	markedMap();
	
	//test();
})

function test(){
	$.ajax({
		url:"GetLatLng",
		data:{},
		success:function(args){
			if(args===null){
				alert("서버와 통신이 불가합니다. 잠시후에 시도해주세요. : 좌표값이 null");
				window.history.back();
				return;
			}
			jsonArray=args;
			console.log(jsonArray);
		}
	})
};

















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
	            position : new kakao.maps.LatLng(position.lat, position.lng),
	            clickable: true, // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
	            
	            
	        });
	    });
	
	    // 클러스터러에 마커들을 추가합니다
	    clusterer.addMarkers(markers);
	});
	
}
function resizeMap() {
    var mapContainer = document.getElementById('map');
    mapContainer.style.width = '100%';
    mapContainer.style.height = '100%'; 
}
function relayout() {    
    // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
    // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다 
    // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
    map.relayout();
}
