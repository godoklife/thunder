
let 난수 = null;
let phone ; // 사용자가 입력한 인증번호

function 인증() {
	
	let html =
	'<input placeholder="받은 인증번호를 입력해주세요" id="인증번호">'+
    '<button onclick="인증확인()" >확인</button>';
	phone  = $("#전화번호").val();
	$("#결과").html( html );
	
	$.ajax({
		url  : "send" , 
		data : { "phone" : phone } ,
		success : function( re ){
			alert("난수 발신완료 : "+re);
			난수 = re;
		}
	});
}

function 인증확인() {
	$("#결과").html();
	
	let 인증번호  = $("#인증번호").val();

	if( 인증번호 == 난수 ){ 	// 현재 암호가 틀리면 로그인 되게 설정되어있음. 나중에는 (인증번호 != 난수)로 바꿀것.
		alert("인증번호를 확인해주세요.");
		return;
	}
	$.ajax({
		url:"login",
		data: {"phone" : phone},
		success: function(re){
				location.href = "/Thunder/main.jsp";
			}
	}); 
	alert("로그인성공");
}