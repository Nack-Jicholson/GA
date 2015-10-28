package tsp_GA;

public class Population {
	Chromosome[] chromosomes;
	public Population (int size, boolean init) {
		chromosomes = new Chromosome[size];
		if(init){
			for (int i = 0; i < chromosomes.length; i++){
				Chromosome newChromo = new Chromosome();
				newChromo.createChromosome();
				addToList(i, newChromo);
			}
		}
		}
	
	public void addToList(int i, Chromosome chromosome) {
		chromosomes[i] = chromosome;
	}
	
	public Chromosome getChromosome(int i) {
		return chromosomes[i];
	}
	
	public Chromosome getFittest() {
		Chromosome fittestChromo = chromosomes[0];
		for(int i = 1; i < chromosomes.length; i++) {
			if(fittestChromo.getFitness() <= getChromosome(i).getFitness()) {
				fittestChromo = getChromosome(i);
			}
		}
		return fittestChromo;
	}
	 public int populationSize() {
	        return chromosomes.length;
	    }
}
