//EXERCÍCIO 01
var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 5 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var manchester = {
  nome: 'Manchester United Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 20 },
    { desc: 'Continentais', qtd: 3 },
    { desc: 'Mundiais', qtd: 1 }
  ]
};

var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 13 },
    { desc: 'Continentais', qtd: 0 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 18 },
    { desc: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var array = [chelsea, manchester, arsenal, liverpool];
//----------------------------------------------------


//EXERCÍCIO 02
function ordenaPorNacionais(arr) {
	var nacionais = arr.map(
		function(i) {
			return i.titulos[0].qtd;
		});
	nacionais.sort(function(a, b){return b-a});
	return nacionais;
}

function ordenaPorContinentais(arr) {
	var continentais = arr.map(
		function(i) {
			return i.titulos[1].qtd;
		});
	continentais.sort(function(a, b){return b-a});
	return continentais;
}

function ordenaPorMundiais(arr) {
	var mundiais = arr.map(
		function(i) {
			return i.titulos[2].qtd;
		});
	mundiais.sort(function(a, b){return b-a});
	return mundiais;
}

ordenaPorNacionais(array);
ordenaPorContinentais(array);
ordenaPorMundiais(array);
//----------------------------------------------------


//EXERCÍCIO 03
function somarPorNacionais(arr) {
	var soma = 0;
	var nacionais = arr.map(
		function(i) {
			return i.titulos[0].qtd;
		});
	nacionais.forEach(
		function(a) {
			soma+=a;
		});
	return soma;
}

function somarPorContinentais(arr) {
	var soma = 0;
	var continentais = arr.map(
		function(i) {
			return i.titulos[1].qtd;
		});
	continentais.forEach(
		function(a) {
			soma+=a;
		});
	return soma;
}

function somarPorMundiais(arr) {
	var soma = 0;
	var mundiais = arr.map(
		function(i) {
			return i.titulos[2].qtd;
		});
	mundiais.forEach(
		function(a) {
			soma+=a;
		});
	return soma;
}

function somarPorTodosTitulos(arr) {
	var vetor = arr.map(
		function(a) {
			var soma =
				a.titulos[0].qtd +
				a.titulos[1].qtd +
				a.titulos[2].qtd;
			return soma;;
		});

	return vetor;
}

somarPorNacionais(array);
somarPorContinentais(array);
somarPorMundiais(array);
somarPorTodosTitulos(array);
//----------------------------------------------------


//EXERCÍCIO 04
function apenasOsMelhores(arr) {
	var melhoresNacionais = [];
	arr.forEach(
		function(a) {
			if (a.titulos[0].qtd >= 18) melhoresNacionais.push(a);
		});

	return melhoresNacionais;
}

apenasOsMelhores(array);
//----------------------------------------------------


//EXERCÍCIO 05
function apenasOsMelhoresParaJSON(arr) {
	return JSON.stringify(arr);
}

function apenasOsMelhoresRecebendoJSON(str) {
	return JSON.parse(str);
}

var melhores = apenasOsMelhores(array);
var strJson = apenasOsMelhoresParaJSON(melhores);

apenasOsMelhoresParaJSON(melhores);
apenasOsMelhoresRecebendoJSON(strJson);
//----------------------------------------------------