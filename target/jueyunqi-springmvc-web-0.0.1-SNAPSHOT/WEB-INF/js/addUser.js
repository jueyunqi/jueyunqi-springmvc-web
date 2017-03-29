$(document).ready(function(){
	$("#add").on("click",function(){
		var vv = JSON.stringify({"name":$("#name").val(),"passw":$("#passw").val()}) ;
		$.ajax({
			url: '/web001/add.htm',
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