$(document).ready(function(){
	$("#update").on("click",function(){
		var vv = JSON.stringify({"id":$("#id").val(),"name":$("#name").val(),"passw":$("#passw").val()}) ;
		$.ajax({
			url: '/web001/update.htm',
			type: "post",
			data: vv,
			dataType:'text', 
			contentType:"application/json; charset=utf-8",
			success: function(result) {
				location.href = "/web001/query.htm";
			},
			error: function(result) {
				console.log(result);
	        }
		});
	});
});