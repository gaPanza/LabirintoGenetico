package util;

import util.Individual;
import util.Population;

public class AlgoritmoGenetico {
	public Integer populationSize;
	private Double mutationRate;
	private Double crossRate;
	private Integer keepCount;

	public AlgoritmoGenetico(Integer populationSize, Double mutationRate, Double rate, Integer keepCount) {
		this.populationSize = populationSize;
		this.mutationRate = mutationRate;
		this.crossRate = rate;
		this.keepCount = keepCount;
	}

	public Double avaliarAderencia(Individual individual) {
		int genesCorretos = 0;

		// Loop pelos genes

		for (int i = 0; i < individual.getCromossomo().length; i++) {
			if (individual.getGene(i) == 1) {
				genesCorretos += 1;
			}
		}

		double aderencia = (double) genesCorretos / individual.getCromossomo().length;

		individual.setAderencia(aderencia);

		return aderencia;

	}

	public void avaliarPopulacao(Population population) {
		double aderenciaPop = 0;

		for (Individual individual : population.getIndividuals()) {
			aderenciaPop += avaliarAderencia(individual);
		}

		population.setPopulationFitness(aderenciaPop);
	}

	public boolean condicaoDeParada(Population population) {
		for (Individual individual : population.getIndividuals()) {
			if (individual.getAderencia() == 1) {
				return true;
			}
		}
		return false;
	}

	public Population iniciarPopulacao(int tamCromossomo) {
		Population population = new Population(this.populationSize, tamCromossomo);
		return population;
	}

}
