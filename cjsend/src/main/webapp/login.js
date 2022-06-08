let resultNum = null;

function 인증() {
	
	
	let html =
	'<input placeholder="인증번호 입력" id="인증번호">'+
    '<button onclick="인증확인()" >확인</button>';
	
	$("#결과").html( html );
	
	let phone  = $("#전화번호").val();
	
	$.ajax({
		url  : "send" , 
		data : { "phone" : phone } ,
		success : function( re ){
			alert("통신 성공");
			resultNum = re;
		}
	});
}

function 인증확인() {
	
	$("#결과").html();
	
	let 인증번호  = $("#인증번호").val();
	

	if( 인증번호 == resultNum ){ alert("로그인성공"); } //  세션부여  }
	else{ alert("인증번호가 다릅니다."); }
	alert( 인증번호 );
	
}