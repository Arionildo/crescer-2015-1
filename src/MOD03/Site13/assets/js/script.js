function ex00() {
	$.ajax({
		url: 'http://illuminati.instaweb.com.br:6789/autentica',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(a)
	}).done(function(y){
		console.log(y)
	});
}

function ex01() {
	$.ajax({
		url: 'http://illuminati.instaweb.com.br:6789/exercicios?token=d495d70947ae',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(b)
	}).done(function(y){
		console.log(y)
	});
}

function ex02() {
	$.ajax({
		url: 'http://illuminati.instaweb.com.br:6789/exercicios?token=d495d70947ae',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(c)
	}).done(function(y){
		console.log(y)
	});
}

function ex03() {
	$.ajax({
		url: 'http://illuminati.instaweb.com.br:6789/exercicios?token=d495d70947ae',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(d)
	}).done(function(y){
		console.log(y)
	});
}

function ex04() {
	$.ajax({
		url: 'http://illuminati.instaweb.com.br:6789/exercicios?token=d495d70947ae',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(e)
	}).done(function(y){
		console.log(y)
	});
}

function ex05() {
	$.ajax({
		url: 'http://illuminati.instaweb.com.br:6789/exercicios?token=d495d70947ae',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(f)
	}).done(function(y){
		console.log(y)
	});
}

function ex06() {
	$.ajax({
		url: 'http://illuminati.instaweb.com.br:6789/exercicios?token=d495d70947ae',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(g)
	}).done(function(y){
		console.log(y)
	});
}

function weeeeAreTheChampiooonsMyfrieeend() {
	$.ajax({
		url: 'http://illuminati.instaweb.com.br:6789/exercicios?token=d495d70947ae',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(h)
	}).done(function(y){
		console.log(y);
		console.log("WEEE'LL KEEP ON FIIGHTING... TILL THE EEEEND");
		console.log("Casa suja, chão chujo");
	});
}

/*
$.ajax({
	url: 'http://illuminati.instaweb.com.br:6789/exercicios?token=d495d70947ae',
	type: 'GET'
}).done(function(y){
	console.log(y)
});
*/


//VARIÁVEIS
var a = { "nome": "Arionildo" };
var b = { "resposta": "10" };
var c = { "resposta": "186" };
var vetor = [59,29,24,55,1,92,39,78,52,32,5,88,89,56,29,
    19,8,97,74,38,15,68,70,29,24,60,14,41,64,45,86,1,79,43,
    72,80,1,44,98,40,32,47,53,25,21,51,86,7,65,30,68,32,44,
    88,45,78,49,29,41,13,48,66,41,98,58,86,5,61,72,56,99,5,
    90,37,21,30,0,59,6,70,94,3,54,45,37,69,41,55,86,15,
    17,80,75,34,24,93,90,86,83,42];
var d = { "resposta": somaVetor01() };
var vetor02 = [78,40,61,"EU NÃO SOU UM NÚMERO RSRSRS",
    84,90,52,73,48,47,82,60,97,"EU NÃO SOU UM NÚMERO RSRSRS",
    35,95,75,92,58,"EU NÃO SOU UM NÚMERO RSRSRS",63,
    "EU NÃO SOU UM NÚMERO RSRSRS",97,"EU NÃO SOU UM NÚMERO RSRSRS",
    "EU NÃO SOU UM NÚMERO RSRSRS",84,"EU NÃO SOU UM NÚMERO RSRSRS",
    46,72,88,49,77,49,73,85,30,"EU NÃO SOU UM NÚMERO RSRSRS",
    "EU NÃO SOU UM NÚMERO RSRSRS","EU NÃO SOU UM NÚMERO RSRSRS",
    58,74,43,31,"EU NÃO SOU UM NÚMERO RSRSRS",69,48,88,
    31,74,52,91,47,75,44,"EU NÃO SOU UM NÚMERO RSRSRS",
    "EU NÃO SOU UM NÚMERO RSRSRS",69,54,69,40,32,68,
    "EU NÃO SOU UM NÚMERO RSRSRS",53,93,45,56,
    "EU NÃO SOU UM NÚMERO RSRSRS","EU NÃO SOU UM NÚMERO RSRSRS",
    69,"EU NÃO SOU UM NÚMERO RSRSRS","EU NÃO SOU UM NÚMERO RSRSRS",
    57,44,"EU NÃO SOU UM NÚMERO RSRSRS",42,
    "EU NÃO SOU UM NÚMERO RSRSRS",38,82,48,95,30,
    "EU NÃO SOU UM NÚMERO RSRSRS",42,95,81,36,
    "EU NÃO SOU UM NÚMERO RSRSRS","EU NÃO SOU UM NÚMERO RSRSRS",
    "EU NÃO SOU UM NÚMERO RSRSRS",58,"EU NÃO SOU UM NÚMERO RSRSRS",
    51,"EU NÃO SOU UM NÚMERO RSRSRS","EU NÃO SOU UM NÚMERO RSRSRS",
    "EU NÃO SOU UM NÚMERO RSRSRS",32,45,
    "EU NÃO SOU UM NÚMERO RSRSRS",65];
var e = { "resposta": somaVetor02() };
var vetor03 = [39,53,0,12,52,5,57,85,66,83,70,30,20,14,
85,69,46,81,83,57,50,1,29,12,86,34,56,70,30,59,70,42,69,
59,63,81,19,3,69,91,64,10,83,9,79,67,97,37,32,10,31,19,
13,62,77,92,9,55,82,93,13,33,37,9,15,33,16,1,2,32,85,14,
36,1,60,52,48,39,10,29,43,81,27,12,62,35,35,82,86,58,55,
97,76,15,16,56,97,38,41,37];
var f = { "resposta": somaVetor03() };
var vetor04 = [{"data":57},{"data":25},{"data":50},
{"data":34},{"data":0},{"data":98},{"data":35},
{"data":54},{"data":17},{"data":8},{"data":57},
{"data":29},{"data":72},{"data":16},{"data":1},
{"data":12},{"data":87},{"data":22},{"data":20},
{"data":65},{"data":73},{"data":54},{"data":93},
{"data":68},{"data":73},{"data":36},{"data":66},
{"data":44},{"data":1},{"data":67},{"data":39},
{"data":80},{"data":40},{"data":27},{"data":25},
{"data":28},{"data":51},{"data":89},{"data":78},
{"data":48},{"data":31},{"data":20},{"data":55},
{"data":55},{"data":67},{"data":59},{"data":8},
{"data":60},{"data":84},{"data":19},{"data":87},
{"data":66},{"data":14},{"data":86},{"data":75},
{"data":27},{"data":35},{"data":9},{"data":32},
{"data":72},{"data":44},{"data":94},{"data":88},
{"data":67},{"data":24},{"data":83},{"data":58},
{"data":42},{"data":0},{"data":68},{"data":3},
{"data":80},{"data":37},{"data":15},{"data":30},
{"data":22},{"data":98},{"data":91},{"data":41},
{"data":64},{"data":29},{"data":86},{"data":10},
{"data":17},{"data":69},{"data":89},{"data":0},
{"data":53},{"data":42},{"data":34},{"data":10},
{"data":35},{"data":8},{"data":32},{"data":78},
{"data":16},{"data":63},{"data":52},{"data":88},
{"data":27}];
var g = { "resposta": somaVetor04() };
var vetor05 = [{"data":35,"status":"INCLUIDO"},
{"data":46,"status":"INCLUIDO"},
{"data":95,"status":"INCLUIDO"},
{"data":38,"status":"INCLUIDO"},
{"data":26,"status":"EXCLUIDO"},
{"data":69,"status":"INCLUIDO"},
{"data":29,"status":"EXCLUIDO"},
{"data":5,"status":"EXCLUIDO"},
{"data":67,"status":"INCLUIDO"},
{"data":41,"status":"INCLUIDO"},
{"data":60,"status":"INCLUIDO"},
{"data":8,"status":"EXCLUIDO"},
{"data":33,"status":"INCLUIDO"},
{"data":67,"status":"INCLUIDO"},
{"data":78,"status":"INCLUIDO"},
{"data":5,"status":"EXCLUIDO"},
{"data":53,"status":"INCLUIDO"},
{"data":84,"status":"INCLUIDO"},
{"data":36,"status":"INCLUIDO"},
{"data":7,"status":"EXCLUIDO"},
{"data":21,"status":"EXCLUIDO"},
{"data":95,"status":"INCLUIDO"},
{"data":10,"status":"EXCLUIDO"},
{"data":91,"status":"INCLUIDO"},
{"data":76,"status":"INCLUIDO"},
{"data":41,"status":"INCLUIDO"},
{"data":86,"status":"INCLUIDO"},
{"data":55,"status":"INCLUIDO"},
{"data":30,"status":"EXCLUIDO"},
{"data":19,"status":"EXCLUIDO"},
{"data":69,"status":"INCLUIDO"},
{"data":94,"status":"INCLUIDO"},
{"data":81,"status":"INCLUIDO"},
{"data":77,"status":"INCLUIDO"},
{"data":21,"status":"EXCLUIDO"},
{"data":56,"status":"INCLUIDO"},
{"data":19,"status":"EXCLUIDO"},
{"data":26,"status":"EXCLUIDO"},
{"data":71,"status":"INCLUIDO"},
{"data":49,"status":"INCLUIDO"},
{"data":30,"status":"EXCLUIDO"},
{"data":69,"status":"INCLUIDO"},
{"data":88,"status":"INCLUIDO"},
{"data":92,"status":"INCLUIDO"},
{"data":27,"status":"EXCLUIDO"},
{"data":71,"status":"INCLUIDO"},
{"data":64,"status":"INCLUIDO"},
{"data":98,"status":"INCLUIDO"},
{"data":30,"status":"EXCLUIDO"},
{"data":18,"status":"EXCLUIDO"},
{"data":67,"status":"INCLUIDO"},
{"data":45,"status":"INCLUIDO"},
{"data":62,"status":"INCLUIDO"},
{"data":82,"status":"INCLUIDO"},
{"data":67,"status":"INCLUIDO"},
{"data":5,"status":"EXCLUIDO"},
{"data":95,"status":"INCLUIDO"},
{"data":63,"status":"INCLUIDO"},
{"data":36,"status":"INCLUIDO"},
{"data":74,"status":"INCLUIDO"},
{"data":84,"status":"INCLUIDO"},
{"data":20,"status":"EXCLUIDO"},
{"data":27,"status":"EXCLUIDO"},
{"data":84,"status":"INCLUIDO"},
{"data":48,"status":"INCLUIDO"},
{"data":51,"status":"INCLUIDO"},
{"data":66,"status":"INCLUIDO"},
{"data":50,"status":"INCLUIDO"},
{"data":40,"status":"INCLUIDO"},
{"data":77,"status":"INCLUIDO"},
{"data":80,"status":"INCLUIDO"},
{"data":77,"status":"INCLUIDO"},
{"data":30,"status":"EXCLUIDO"},
{"data":94,"status":"INCLUIDO"},
{"data":33,"status":"INCLUIDO"},
{"data":10,"status":"EXCLUIDO"},
{"data":2,"status":"EXCLUIDO"},
{"data":17,"status":"EXCLUIDO"},
{"data":94,"status":"INCLUIDO"},
{"data":25,"status":"EXCLUIDO"},
{"data":30,"status":"EXCLUIDO"},
{"data":34,"status":"INCLUIDO"},
{"data":39,"status":"INCLUIDO"},
{"data":82,"status":"INCLUIDO"},
{"data":89,"status":"INCLUIDO"},
{"data":22,"status":"EXCLUIDO"},
{"data":94,"status":"INCLUIDO"},
{"data":88,"status":"INCLUIDO"},
{"data":81,"status":"INCLUIDO"},
{"data":67,"status":"INCLUIDO"},
{"data":92,"status":"INCLUIDO"},
{"data":5,"status":"EXCLUIDO"},
{"data":93,"status":"INCLUIDO"},
{"data":38,"status":"INCLUIDO"},
{"data":67,"status":"INCLUIDO"},
{"data":40,"status":"INCLUIDO"},
{"data":90,"status":"INCLUIDO"},
{"data":45,"status":"INCLUIDO"},
{"data":66,"status":"INCLUIDO"},
{"data":39,"status":"INCLUIDO"}];
var h = { "resposta": somaVetor05() };

function somaVetor01(){
	var soma = 0;
	vetor.forEach(function(x){
		soma+=x;
	})
	return soma;
}

function somaVetor02(){
	var soma = 0;
	vetor02.forEach(function(x){
		if (typeof x === 'number')soma+=x;
	})
	return soma;
}

function somaVetor03(){
	var soma = 0;
	vetor03.forEach(function(x){
		if (x % 3 === 0)soma+=x;
	})
	return soma;
}

function somaVetor04(){
	var soma = 0;
	vetor04.forEach(function(x){
		soma+=x.data;
	})
	return soma;
}

function somaVetor05(){
	var soma = 0;
	vetor05.forEach(function(x){
		if (x.status === "INCLUIDO")soma+=x.data;
	})
	return soma;
}