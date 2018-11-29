package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenerateGenes {
	public static void main(String[] args) {
		// Criar Algoritmo Genetico
		AlgoritmoGenetico ag = new AlgoritmoGenetico(1000000, 0.001, 0.95, 2);
		
		// Inicializar População
		Population pop = ag.iniciarPopulacao(20);

		// Mapear a população fazendo uma avaliação dos individuos
		ag.avaliarPopulacao(pop);

		// Manter contador da atual geração
		int geracao = 1;
	
		Map map = new Map(new Integer[1000][1000]);
		map.getMap()[0][0] = 2;
		map.getMap()[999][999] = 4;
		for (int i=0;i<999;i++) {
			map.getMap()[i][500] = 1;
		}
		map.getMap()[400][500] = 0;
		map.getMap()[700][500] = 0;
		map.getMap()[701][500] = 0;
		
		HashMap<Integer[], Individual> hash = new HashMap<Integer[], Individual>();
		int next= 0;
		for(int i = 0;i<map.getMap().length;i++) {
			for (int j=0;j<map.getMap()[i].length;j++) {
				hash.put(new Integer[] {i,j}, pop.getIndividuals()[next]);	
				//System.out.println(hash.get({i,j}));	
				next++;
			}
		}
		
		Individual current;
		Integer x = map.getCurrentX();
		Integer y = map.getCurrentY();
		System.out.println(hash.get(new Integer[] {1,1}));
		// Fazer realmente o loop de caminhada
		while (hash.get(new Integer[] {x,y}).getAderencia() == 1) {
			// Current Position
			x = map.getCurrentX();
			y = map.getCurrentY();
			System.out.println("("+x+","+y+")"+"  "+ "Geração "+ geracao + "  " + hash.get(new Integer[] {x,y}));
			
			List<Individual> toRate = new ArrayList<Individual>();
			toRate.add(hash.get(new Integer[] {x+1,y})); //Baixo
			toRate.add(hash.get(new Integer[] {x,y}));   //Mesmo
			toRate.add(hash.get(new Integer[] {x+1,y+1}));//Diagonal
			toRate.add(hash.get(new Integer[] {x,y+1}));//Direita
			
			// Printar o individuo mais bem avaliado
			System.out.println("Melhor Caminho: " + pop.getBestAvaliado(toRate).toString());
			
			// Aplicar o crossover Rate
			pop = ag.crossoverPopulation(pop);
			// Aplicar mutação
			pop = ag.mutatePopulation(pop);

			// Avaliar a população
			ag.avaliarPopulation(pop);
			// Incrementar a população
			geracao++;
		}
		// Fora do loop printar a solução
		System.out.println("Solucao achada " + geracao + " " +pop.getMelhorAvaliado(0).toString());

	}
}
