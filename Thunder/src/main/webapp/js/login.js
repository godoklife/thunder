
let 난수 = null;
let phone ;

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
			alert("통신 성공");
			난수 = re;
		}
	});
}

function 인증확인() {
	alert(phone);
	$("#결과").html();
	
	let 인증번호  = $("#인증번호").val();

	if( 인증번호 == 난수 ){ alert("로그인성공");
	$.ajax({
		url:"login",
		data: {"phone" : phone},
		success: function(re){
			if(re==1){
				location.href = "/Thunder/main.jsp";
			}else{
				alert("실패");
				location.href = "/Thunder/main.jsp";
			}
		}
	}); 
	
	} //  세션부여  }
	else{ alert("인증번호가 다릅니다.");
	
}	
	alert( 인증번호 );
}