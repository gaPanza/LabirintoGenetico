package util;

import util.AlgoritmoGenetico;
import util.Population;

public class GenerateGenes {
	public static void main(String[] args) {
		// Criar Algoritmo Genetico
		AlgoritmoGenetico ag = new AlgoritmoGenetico(1000, 0.01, 0.8, 2);

		// Inicializar População
		Population pop = ag.iniciarPopulacao(1000);

		// Mapear a população fazendo uma avaliação dos individuos
		ag.avaliarPopulacao(pop);

		// Manter contador da atual geração
		int geracao = 1;

		// Fazer realmente o loop de execução
		while (ag.condicaoDeParada(pop) == false) {
			// Se um cromossomo for avaliado como perfeito, fechar o programa
			// Printar o individuo mais bem avaliado
			System.out.println("Melhor Caminho: " + pop.getMelhorAvaliado(0).toString());

			// Aplicar o crossover Rate

			// Aplicar mutação

			// Avaliar a população

			// Incrementar a população
			geracao++;
		}
		// Fora do loop printar a solução
		System.out.println("Solucao achada");

	}
}