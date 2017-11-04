package util;

import java.util.Arrays;

import util.Individual;

public class Population {
	private Individual population[];
	private double populationFitness = 0;

	public Population(int Size) {
		this.population = new Individual[Size];
	}

	public Population(int tamPopulation, int tamCromosssomo) {
		this.population = new Individual[tamPopulation];
		for (int individualCount = 0; individualCount < tamPopulation; individualCount++) {
			Individual individual = new Individual(tamCromosssomo);
			this.population[individualCount] = individual;
		}
	}

	public Individual[] getIndividuals() {
		return this.population;
	}

	public void setPopulation(Individual[] population) {
		this.population = population;
	}

	public double getPopulationFitness() {
		return populationFitness;
	}

	public void setPopulationFitness(double populationFitness) {
		this.populationFitness = populationFitness;
	}

	public Individual getMelhorAvaliado(int condicao) {
		Arrays.sort(this.population, (Individual i1, Individual i2) -> i1.getAderencia().compareTo(i2.getAderencia()));

		return this.population[condicao];
	}

}
