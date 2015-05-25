function validaImagem(){
	var img = document.getElementsByName("imagem")[0].value;
	var nomeArquivo = img.value;
	var valida = false;
	var extensoesValidas = [ '.jpg', '.jpeg', '.png' ];
	for (var i = 0, len = extensoesValidas.length; i < len; i++) {
		var ext = extensoesValidas[i];
		var apenasAExtensao = nomeArquivo.substring(nomeArquivo.length-ext.length, nomeArquivo.length).toLowerCase();
							
		if (apenasAExtensao === ext.toLowerCase()) {
			valida = true;
			break;
		}
	}
	
	if (valida === false) {
		alert('Extensão inválida!');
		img.value = null;
	}
	
	return valida;
}}