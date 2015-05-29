function avaliar(){
	$.ajax({
		url: "/consulta",
		type: "GET",
		success: function(){
        	alert("funfô!");
    	}
	});
}