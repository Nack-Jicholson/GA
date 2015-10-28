package tsp_GA;

public class Distance {
    
	double distance;

    //creates a city with distance passed from main method
    public Distance(int distance){
        this.distance = distance;
    }
    
    //gets distance between two cities
    public double getDistance(){
        return this.distance;
    }
}