$(function(){
	let parameter = (location.search).split('=',2)[1];	// get방식으로 넘어온 게시글번호
	showcontent(parameter);
});

function showcontent(boardpkno){
	$.ajax({
		url:"",
		data:{},
		success:function(args){
			
		}
	})
};
