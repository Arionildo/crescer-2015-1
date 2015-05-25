$.ajax({
	url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50',
	type: 'GET',
}).done(function(y){
	y.items.forEach(function(x){
		
		console.log(x);

		/*
		var urlImagem = x.images[1].url;
		$('#albuns').append('<img  src='+ urlImagem +' />');
		*/
	});
});