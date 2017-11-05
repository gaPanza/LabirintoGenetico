package util;

public class Individual {
	
	private Integer[] cromossomo;
	private Double aderencia = 0.0;

	public Individual(Integer[] cromossomo) {
		this.cromossomo = cromossomo;
	}

	public Individual(Integer tamCromossomo) {
		this.cromossomo = new Integer[tamCromossomo];
		for (int gene = 0; gene < tamCromossomo; gene++) {
			if (0.5 < Math.random()) {
				this.setGene(gene, 1);
			} else {
				this.setGene(gene, 0);
			}
		}
	}

	public void setGene(int offset, int gene) {
		this.cromossomo[offset] = gene;
	}

	public int getGene(int offset) {
		return this.cromossomo[offset];
	}

	public Integer[] getCromossomo() {
		return cromossomo;
	}

	public void setCromossomo(Integer[] cromossomo) {
		this.cromossomo = cromossomo;
	}

	public Double getAderencia() {
		return aderencia;
	}

	public void setAderencia(Double aderencia) {
		this.aderencia = aderencia;
	}

	public String toString() {
		String output = "";
		for (int gene = 0; gene < this.cromossomo.length; gene++) {
			output += this.cromossomo[gene];
		}
		return output;
	}

}
