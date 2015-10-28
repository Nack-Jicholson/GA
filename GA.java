package tsp_GA;
public class GA {

    /* GA parameters */
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    // Evolves a population over one generation
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);

        // Keep our best individual if elitism is enabled
        int elitismOffset = 0;
        if (elitism) {
            newPopulation.addToList(0, pop.getFittest());
            elitismOffset = 1;
        }

        // Crossover population
        // Loop over the new population's size and create individuals from
        // Current population
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            // Select parents
        	Chromosome parent1 = tournamentSelection(pop);
        	Chromosome parent2 = tournamentSelection(pop);
            // Crossover parents
        	Chromosome child = crossover(parent1, parent2);
            // Add child to new population
            newPopulation.addToList(i, child);
        }

        // Mutate the new population a bit to add some new genetic material
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getChromosome(i));
        }

        return newPopulation;
    }

    // Applies crossover to a set of parents and creates offspring
    public static Chromosome crossover(
    		Chromosome parent1, Chromosome parent2) {
        // Create new child tour
        Chromosome child = new Chromosome();

        // Get start and end sub tour positions for parent1's tour
        int startPos = (int) (Math.random() * parent1.chromosomeSize());
        int endPos = (int) (Math.random() * parent1.chromosomeSize());

        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.chromosomeSize(); i++) {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getCity(i));
            } // If our start position is larger
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        // Loop through parent2's city tour
        for (int i = 0; i < parent2.chromosomeSize(); i++) {
            // If child doesn't have the city add it
            if (!child.containsCity(parent2.getCity(i))) {
                // Loop to find a spare position in the child's tour
                for (int ii = 0; ii < child.chromosomeSize(); ii++) {
                    // Spare position found, add city
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutate a tour using swap mutation
    private static void mutate(Chromosome chromosome) {
        // Loop through tour cities
        for(int tourPos1=0; tourPos1 < chromosome.chromosomeSize(); tourPos1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){
                // Get a second random position in the tour
                int tourPos2 = (int) (chromosome.chromosomeSize() * Math.random());

                // Get the cities at target position in tour
                Distance city1 = chromosome.getCity(tourPos1);
                Distance city2 = chromosome.getCity(tourPos2);

                // Swap them around
                chromosome.setCity(tourPos2, city1);
                chromosome.setCity(tourPos1, city2);
            }
        }
    }

    // Selects candidate tour for crossover
    private static Chromosome tournamentSelection(Population pop) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize, false);
        // For each place in the tournament get a random candidate tour and
        // add it
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.addToList(i, pop.getChromosome(randomId));
        }
        // Get the fittest tour
        Chromosome fittest = tournament.getFittest();
        return fittest;
    }
}