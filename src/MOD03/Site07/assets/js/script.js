var vetor = ["a", "r", "r", "a", "i", "i", "i"];
var p = document.getElementById("vetor").value;
p = "";

function main() {
	aux("vetor", "Log Vetor(): "+ logVetor);

	aux("pop", "pop(): "+ vetor.pop());
	logVetor();
	aux("slice", "slice(2) - Parâmetro(Passos a dar até cortar): "+ vetor.slice(2));
	logVetor();
	aux("splice", "splice(3, 0, 'O', 'I', 'E') - Parâmetro(Passos a dar, Quantos cortar, Quantos adicionar): "+ vetor.splice(3, 0, 'O', 'I', 'E'));
	logVetor();
}

function aux(id, text) {
	document.getElementById(id).innerHTML = text;
}

function logVetor(){
	//p += "\n"+ vetor;
	vetor = ["a", "r", "r", "a", "i", "i", "i"];
}