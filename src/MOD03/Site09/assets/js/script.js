'use strict';

//EXERCÍCIO 01
function brewdog(firstStr, secondStr) {
	var menor = firstStr.length < secondStr.length ? firstStr : secondStr;
	var maior = firstStr.length >= secondStr.length ? firstStr : secondStr;
	var cont = 0;

	menor = menor.split("");
	maior = maior.split("");

	menor.forEach(
		function(a) {
			if (maior.indexOf(a) < 0) cont++;
		});

	maior.forEach(
		function(b) {
			if (menor.indexOf(b) < 0) cont++;
		});

	return cont;
}

brewdog("bacon", "beico");

var vetor = [
	{parametro: ["american ipa", "american ipa"], esperado: 0},
	{parametro: ["russian imperial stout", "russian imperial vodka"], esperado: 5},
	{parametro: ["1002012", "dfgdf12"], esperado: 5},
	{parametro: ["k4rol1n", "k4thr1n"], esperado: 3},
	{parametro: ["a1df222266%334op", "ssdfjfdkjgsdfgofdgudf9g8dufsg"], esperado: 26}
	];

vetor.forEach(
	function(a) {
		var resultado = brewdog(a.parametro[0], a.parametro[1]);
		console.assert(resultado === a.esperado,
						"Erro! Item Atual: ", a.parametro,
						"Esperado: ", a.esperado,
						"Obtido: ", resultado);
	});
//---------------------------------------------------


//EXERCÍCIO 02
function Emprestimo(valor, juros, parcelas) {
	this.valor = valor;
	this.juros = juros;
	this.parcelas = parcelas || 3;

	this.valorParcela = function() {
		var p = Math.ceil(this.valor /
				(((Math.pow(1 + this.juros, this.parcelas)) - 1) /
				((Math.pow(1 + this.juros, this.parcelas)) * this.juros)) * 100) / 100;
		return p;
	}

	this.valorTotalJuros = function() {
		return Math.round(((this.valorParcela() * this.parcelas) - this.valor) * 100) / 100;
	}
}

var emp01 = new Emprestimo(1000, 0.03, 4);
var emp02 = new Emprestimo(500, 0.05);

emp01.valorParcela();
emp02.valorTotalJuros();

var testeEmprestimo01 = [
    { emprestimo: new Emprestimo(1000, 0.03, 4),  esperado: 269.03 },
    { emprestimo: new Emprestimo(1800, 0.05, 8),  esperado: 278.5 },
    { emprestimo: new Emprestimo(500, 0.05),      esperado: 183.61 }
  ].forEach(
    function(b) {
      var resultado = b.emprestimo.valorParcela();
      console.assert(resultado === b.esperado, 'Errooooou! CT:', b.emprestimo, 'Esperado:', b.esperado, 'Obtido:', resultado);
    }
  );

var testeEmprestimo02 = [
    { emprestimo: new Emprestimo(1800, 0.13, 8),  esperado: 1200.8 },
    { emprestimo: new Emprestimo(1000, 0.03, 4),  esperado: 76.12 },
    { emprestimo: new Emprestimo(500, 0.05),      esperado: 50.83 }
  ].forEach(
    function(c) {
      var resultado = c.emprestimo.valorTotalJuros();
      console.assert(resultado === c.esperado, 'Errooooou! CT:', c.emprestimo, 'Esperado:', c.esperado, 'Obtido:', resultado);
    }
  );
//---------------------------------------------------


//EXERCÍCIO 03
function palindromo(p) {
	var palavra = correcaoDeAcentos(p);
	palavra = palavra.replace(/[^A-Za-z;]/g, '');
	var listaExcecao = ["iluminatti", "ledesma", "dante", "verdemusgo", "bacon"];
	var palavraInvertida = palavra.split("").reverse().join("");
	return ((listaExcecao.indexOf(palavra) > -1) || (palavra === palavraInvertida));
}

function correcaoDeAcentos (s){
    var r=s.toLowerCase();
    r = r.replace(/[àáâãäå]/gi,"a");
    r = r.replace(/ç/gi,"c");
    r = r.replace(/[èéêë]/gi,"e");
    r = r.replace(/[ìíîï]/gi,"i");
    r = r.replace(/[òóôõö]/gi,"o");
    r = r.replace(/[ùúûü]/gi,"u");
    return r;
};

palindromo("ana");
palindromo("ôvo");

var testePalindromo = [
    { teste: 'ovo',                                         esperado: true },
    { teste: 'ôvo',                                         esperado: true },
    { teste: 'arara',                                       esperado: true },
    { teste: 'rodador',                                     esperado: true },
    { teste: 'O tRoTe ToRtO',                               esperado: true },
    { teste: 'bacon',                                       esperado: true },
    { teste: 'A miss é péssima!',                           esperado: true },
    { teste: 'VERDE musgo!!',                               esperado: true },
    { teste: 'Nova Schin, cervejão!',                       esperado: false },
    { teste: 'camigoal',                                    esperado: false },
    { teste: 'ledesma@@@@@@@@',                             esperado: true },
    { teste: '!!d@ante!?!?',                                esperado: true },
    { teste: '1@ilu$$$m1in$$$$$$$$$$4att$$$$$$$$1i!!!!!',   esperado: true }
  ].forEach(
    function(d) {
      var resultado = palindromo(d.teste);
      console.assert(resultado === d.esperado, 'Errooooou! CT:', d.emprestimo, 'Esperado:', d.esperado, 'Obtido:', resultado);
    }
  );
//---------------------------------------------------