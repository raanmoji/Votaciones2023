var vCandidatos = new Array(4);

vCandidatos[0] = 0;
vCandidatos[1] = 0;
vCandidatos[2] = 0;
vCandidatos[3] = 0;

function votapp(usuario,candidato) {
	candidato--;
	alert("Gracias por su voto");
	vCandidatos[candidato] += 1;
}

function resultados() {
	let total = 0;
	for (i = 0; i < 4; i++) {
		total += vCandidatos[i];
	}

	for (i = 0; i < 4; i++) {
		alert("Candidato "+(i+1)+": "+vCandidatos[i]+" votos - "+((vCandidatos[i]/total)*100)+"%");
	}
	location = "@{/votapp}";
}