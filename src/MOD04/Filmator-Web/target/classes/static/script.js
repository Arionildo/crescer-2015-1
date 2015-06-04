function main(filmeCorrespondente){
	var usuario = $('#usuario').val();
	var filme = $(filmeCorrespondente).closest('p').siblings().first().attr('id');
	var nota = $(filmeCorrespondente).val();
	var objNota = {
			"usuario": usuario,
			"filme": filme,
			"nota": nota
		}
	var jsonNota = JSON.stringify(objNota);
	avaliar(jsonNota);
}

function avaliar(nota){
	$.ajax({
		url: "/avaliar",
		type: "POST",
		contentType: "application/json",
		data: nota
	}).done(function(){
		console.log("Feito! "+ nota);
	});
}