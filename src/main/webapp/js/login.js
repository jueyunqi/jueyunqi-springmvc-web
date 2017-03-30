$(document).ready(function(){
	var webRoot = $("#web_root").val();
	$("#login").on("click",function(){
		var name = $("#name").val();
		var passwd = $("#passwd").val();
		if(!(0 < name.length && 0 < passwd.length)){
			return;
		}
		
		var vv = JSON.stringify({"name":name,"passwd":passwd}) ;
		$.ajax({
			url: webRoot+'/login.htm',
			type: "post",
			data: vv,
			dataType:'text', 
			contentType:"application/json; charset=utf-8",
			success: function(result) {
				location.href = webRoot+"/index.htm";
			},
			error: function(result) {
				console.log(result);
	        }
		});
	});
});