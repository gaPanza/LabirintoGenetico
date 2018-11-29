package util;

import util.Individual;
import util.Population;

public class AlgoritmoGenetico {
	
	public Integer populationSize;
	private Double taxaMutacao;
	private Double crossRate;
	private Integer keepCount;

	public AlgoritmoGenetico(Integer populationSize, Double taxaMutacao, Double rate, Integer keepCount) {
		this.populationSize = populationSize;
		this.taxaMutacao = taxaMutacao;
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

	public Population crossoverPopulation(Population population) {
		Population pop = new Population(population.getIndividuals().length);

		for (int i = 0; i < population.getIndividuals().length; i++) {
			Individual individual = population.getMelhorAvaliado(i);

			if (this.crossRate > Math.random() && i >= this.keepCount) {
				Individual crossRateInd = new Individual(individual.getCromossomo().length);

				Individual ind = parente(population);

				for (int j = 0; j < individual.getCromossomo().length; j++) {
					if (0.5 > Math.random()) {
						crossRateInd.setGene(j, individual.getGene(j));
					} else {
						crossRateInd.setGene(j, ind.getGene(j));
					}
				}

				pop.returnIndividual(i, crossRateInd);
			} else {
				pop.returnIndividual(i, individual);
			}
		}

		return pop;
	}

	public Individual parente(Population population) {
		Individual individuals[] = population.getIndividuals();

		double populationFitness = population.getPopulationFitness();
		double rouletteWheelPosition = Math.random() * populationFitness;

		double spinWheel = 0;

		for (Individual individual : individuals) {
			spinWheel += individual.getAderencia();
			if (spinWheel >= rouletteWheelPosition) {
				return individual;
			}
		}
		return individuals[population.getIndividuals().length - 1];
	}

	public Population mutatePopulation(Population population) {
		Population newPopulation = new Population(this.populationSize);

		for (int populationIndex = 0; populationIndex < population.getIndividuals().length; populationIndex++) {
			Individual individual = population.getMelhorAvaliado(populationIndex);

			for (int i = 0; i < individual.getCromossomo().length; i++) {
				if (populationIndex > this.keepCount) {
					if (this.taxaMutacao > Math.random()) {
						int newGene = 1;
						if (individual.getGene(i) == 1) {
							newGene = 0;
						}
						individual.setGene(i, newGene);
					}
				}
			}

			// Add individual to population
			newPopulation.returnIndividual(populationIndex, individual);
		}

		// Return mutated population
		return newPopulation;
	}

	public void avaliarPopulation(Population population) {
		double populationFitness = 0;

		for (Individual individual : population.getIndividuals()) {
			populationFitness += avaliarAderencia(individual);
		}

		population.setPopulationFitness(populationFitness);
	}

}
