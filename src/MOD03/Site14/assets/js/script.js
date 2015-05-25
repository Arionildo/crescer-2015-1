function main() {
	$.ajax({
		url: 'http://karatekid.instaweb.com.br:4567/apresentar?nome=Arionildo',
		type: 'POST'
	});
}


//function apelido() {
	$.ajax({
		url: 'http://karatekid.instaweb.com.br:4567/apresentar?nome='+nome,
		type: 'POST'
	}).done(function(y){
		console.log(y)
		get();
	});
//}

function get() {
	$.ajax({
		url: 'http://karatekid.instaweb.com.br:4567/tarefas?nome='+nome,
		type: 'GET',
	}).done(function(y){
		a = y.atividades[0].atividade;
		b = y.atividades[1].atividade;
		c = y.atividades[2].atividade;
		ex01();
	});
}

function ex01() {
	$.ajax({
		url: 'http://karatekid.instaweb.com.br:4567'+a+'?nome='+nome,
		type: 'POST'
	}).done(function(y){
		console.log(y)
	});

	$.ajax({
		url: 'http://karatekid.instaweb.com.br:4567'+b+'?nome='+nome,
		type: 'POST'
	}).done(function(y){
		console.log(y)
	});

	$.ajax({
		url: 'http://karatekid.instaweb.com.br:4567'+c+'?nome='+nome,
		type: 'POST'
	}).done(function(y){
		console.log(y);
		end();
	});
}

function end() {
	$.ajax({
		url: 'http://karatekid.instaweb.com.br:4567/acabei?nome='+nome,
		type: 'POST'
	}).done(function(y){
		nome = y.nome;
		apelido();
	});
}

var nome = "佰伵伅亃佃乔伦佡伵亲";
var a = "";
var b = "";
var c = "";