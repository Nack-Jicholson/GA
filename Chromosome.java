package tsp_GA;

import java.util.ArrayList;
import java.util.Collections;

public class Chromosome {

	//holds a chromosome
	private ArrayList<Distance> chromosome = new ArrayList<Distance>();
	//holds the cities of a tour
	private static ArrayList<Distance> destinations = new ArrayList<Distance>();
	
	double fitness = 0.0;
	int length = 0;
	
	public static void addDistance(Distance distance){
		destinations.add(distance);
	}
	
	public Distance getDistance(int i){
		return (Distance)destinations.get(i);
	}
	
	//constructs a blank chromosome
	public Chromosome(){
		for (int i = 0; i < destinations.size(); i++) {
			chromosome.add(null);
		}
	}
	
	public Distance getCity(int i) {
		return (Distance)chromosome.get(i);
	}
	 public int chromosomeSize() {
	        return chromosome.size();
	    }
	public void setCity(int i, Distance distance) {
		chromosome.set(i, distance);
		//changing the chromosome means we need to reset the fitness and distance
		fitness = 0;
		length = 0;
	}
	//check if chromosome contains a city
    public boolean containsCity(Distance distance) {
    	return chromosome.contains(distance);
    }
    
	//gets solution for specific iteration
	public Chromosome(ArrayList chromosome) {
		this.chromosome = chromosome;
	}
	
	//creates a random chromosome
    public void createChromosome() {
        //loop through all our destination cities and add them to our chromosome
        for (int i = 0; i < destinations.size(); i++) {
          setCity(i, getCity(i));
        }
        //randomly reorder the chromosome
        Collections.shuffle(destinations);
    }

    public int getDistance(){
    	if (length == 0) {
    		int intDistance = 0;
    		for (int i = 0; i < destinations.size(); i++) {
    			Distance from = getDistance(i);
    			Distance to;
    			if(i+1 < destinations.size()) {
    				to = getDistance(i+1);
    			}
    			else {
    				to = getDistance(0);
    			}
    			intDistance += from.getDistance();	
    		}
    		length = intDistance;
    	}
    	return length;
    }
    
    public double getFitness() {
    	if (fitness == 0) {
    		fitness = 1/(double)getDistance();
    	}
    	return fitness;
    }
}
