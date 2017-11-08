package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Population {
	
	private Individual population[];
	private double populationFitness = -1;

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

	public Individual returnIndividual(int i, Individual i1) {
		return population[i] = i1;
	}

	public double getPopulationFitness() {
		return populationFitness;
	}

	public void setPopulationFitness(double populationFitness) {
		this.populationFitness = populationFitness;
	}

	public Individual getMelhorAvaliado(int condicao) {
		Arrays.sort(this.population, new Comparator<Individual>() {
			@Override
			public int compare(Individual o1, Individual o2) {
				if (o1.getAderencia() > o2.getAderencia()) {
					return -1;
				} else if (o1.getAderencia() < o2.getAderencia()) {
					return 1;
				}
				return 0;
			}
		});

		return this.population[condicao];
	}
	
	public Individual getBestAvaliado(List<Individual> x) {
		Collections.sort(x, new Comparator<Individual>() {
			@Override
			public int compare(Individual o1, Individual o2) {
				if (o1.getAderencia() > o2.getAderencia()) {
					return -1;
				} else if (o1.getAderencia() < o2.getAderencia()) {
					return 1;
				}
				return 0;
			}
		});
	
		return x.get(0);
	}
}
