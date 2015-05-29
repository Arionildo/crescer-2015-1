function avaliar(){
	$.ajax({
		url: "/consulta",
		type: "POST",
		success: function(){
        	alert("funfô!");
    	}
	});
}