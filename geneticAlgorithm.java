package tsp_GA;

import java.io.BufferedReader;
import java.io.FileReader;

public class geneticAlgorithm {
	
	public static double[][] distance;
	public static int numberOfCities = 8;
	private static String DISTANCE_FILENAME = "C:/Users/Daniel/Desktop/Uni/ComputerScience/Year 3/Artificial Intelligence/Coursework/workspace/GeneticAlgorithms/src/cycleTour/cycleTourData.txt";
	
	public static void main(String args[]){
		
		//int numberOfCities = 8;
		/*
		Distance AbeAyr = new Distance(179);
		Chromosome.addDistance(AbeAyr);
		Distance AbeEdi = new Distance(129);
		Chromosome.addDistance(AbeEdi);
		Distance AbeFor = new Distance(157);
		Chromosome.addDistance(AbeFor);
		Distance AbeGla = new Distance(146);
		Chromosome.addDistance(AbeGla);
		Distance AbeInv = new Distance(105);
		Chromosome.addDistance(AbeInv);
		Distance AbeStA = new Distance(79);
		Chromosome.addDistance(AbeStA);
		Distance AbeSti = new Distance(119);
		Chromosome.addDistance(AbeSti);
		Distance AbeAbe = new Distance(0);
		Chromosome.addDistance(AbeAbe);
		
		Distance AyrAbe = new Distance(179);
		Chromosome.addDistance(AyrAbe);
		Distance AyrEdi = new Distance(79);
		Chromosome.addDistance(AyrEdi);
		Distance AyrFor = new Distance(141);
		Chromosome.addDistance(AyrFor);
		Distance AyrGla = new Distance(33);
		Chromosome.addDistance(AyrGla);
		Distance AyrInv = new Distance(207);
		Chromosome.addDistance(AyrInv);
		Distance AyrStA = new Distance(118);
		Chromosome.addDistance(AyrStA);
		Distance AyrSti = new Distance(64);
		Chromosome.addDistance(AyrSti);
		Distance AyrAyr = new Distance(0);
		Chromosome.addDistance(AyrAyr);

		Distance EdiAbe = new Distance(129);
		Chromosome.addDistance(EdiAbe);
		Distance EdiAyr = new Distance(79);
		Chromosome.addDistance(EdiAyr);
		Distance EdiFor = new Distance(131);
		Chromosome.addDistance(EdiFor);
		Distance EdiGla = new Distance(43);
		Chromosome.addDistance(EdiGla);
		Distance EdiInv = new Distance(154);
		Chromosome.addDistance(EdiInv);
		Distance EdiStA = new Distance(50);
		Chromosome.addDistance(EdiStA);
		Distance EdiSti = new Distance(36);
		Chromosome.addDistance(EdiSti);
		Distance EdiEdi = new Distance(0);
		Chromosome.addDistance(EdiEdi);

		Distance ForAyr = new Distance(141);
		Chromosome.addDistance(ForAyr);
		Distance ForEdi = new Distance(131);
		Chromosome.addDistance(ForEdi);
		Distance ForAbe = new Distance(157);
		Chromosome.addDistance(ForAbe);
		Distance ForGla = new Distance(116);
		Chromosome.addDistance(ForGla);
		Distance ForInv = new Distance(74);
		Chromosome.addDistance(ForInv);
		Distance ForStA = new Distance(134);
		Chromosome.addDistance(ForStA);
		Distance ForSti = new Distance(96);
		Chromosome.addDistance(ForSti);
		Distance ForFor = new Distance(0);
		Chromosome.addDistance(ForFor);
		
		Distance GlaAyr = new Distance(33);
		Chromosome.addDistance(GlaAyr);
		Distance GlaEdi = new Distance(43);
		Chromosome.addDistance(GlaEdi);
		Distance GlaFor = new Distance(116);
		Chromosome.addDistance(GlaFor);
		Distance GlaAbe = new Distance(146);
		Chromosome.addDistance(GlaAbe);
		Distance GlaInv = new Distance(175);
		Chromosome.addDistance(GlaInv);
		Distance GlaStA = new Distance(81);
		Chromosome.addDistance(GlaStA);
		Distance GlaSti = new Distance(27);
		Chromosome.addDistance(GlaSti);
		Distance GlaGla = new Distance(0);
		Chromosome.addDistance(GlaGla);
		
		Distance InvAyr = new Distance(207);
		Chromosome.addDistance(InvAyr);
		Distance InvEdi = new Distance(154);
		Chromosome.addDistance(InvEdi);
		Distance InvFor = new Distance(64);
		Chromosome.addDistance(InvFor);
		Distance InvGla = new Distance(175);
		Chromosome.addDistance(InvGla);
		Distance InvAbe = new Distance(105);
		Chromosome.addDistance(InvAbe);
		Distance InvStA = new Distance(145);
		Chromosome.addDistance(InvStA);
		Distance InvSti = new Distance(143);
		Chromosome.addDistance(InvSti);
		Distance InvInv = new Distance(0);
		Chromosome.addDistance(InvInv);
		
		Distance StAAyr = new Distance(118);
		Chromosome.addDistance(StAAyr);
		Distance StAEdi = new Distance(50);
		Chromosome.addDistance(StAEdi);
		Distance StAFor = new Distance(134);
		Chromosome.addDistance(StAFor);
		Distance StAGla = new Distance(81);
		Chromosome.addDistance(StAGla);
		Distance StAInv = new Distance(145);
		Chromosome.addDistance(StAInv);
		Distance StAAbe = new Distance(79);
		Chromosome.addDistance(StAAbe);
		Distance StASti = new Distance(52);
		Chromosome.addDistance(StASti);
		Distance StAStA = new Distance(0);
		Chromosome.addDistance(StAStA);
		
		Distance StiAyr = new Distance(64);
		Chromosome.addDistance(StiAyr);
		Distance StiEdi = new Distance(36);
		Chromosome.addDistance(StiEdi);
		Distance StiFor = new Distance(96);
		Chromosome.addDistance(StiFor);
		Distance StiGla = new Distance(27);
		Chromosome.addDistance(StiGla);
		Distance StiInv = new Distance(143);
		Chromosome.addDistance(StiInv);
		Distance StiStA = new Distance(52);
		Chromosome.addDistance(StiStA);
		Distance StiAbe = new Distance(119);
		Chromosome.addDistance(StiAbe);
		Distance StiSti = new Distance(0);
		Chromosome.addDistance(StiSti);
		*/
		
		 int city1, city2;
	        BufferedReader readbuffer = null;
	        String strRead;
	        String splitarray[];

	        try {
	            readbuffer = new BufferedReader(new FileReader(DISTANCE_FILENAME));
	            for (city1 = 0; city1 < numberOfCities; city1++) {
	                strRead = readbuffer.readLine();
	                splitarray = strRead.split("\t");
	                for (city2 = 0; city2 < numberOfCities; city2++) {
	                    Distance distance = new Distance(Integer.parseInt(splitarray[city2]));
	                    Chromosome.addDistance(distance);
	                    System.out.println(Integer.parseInt(splitarray[city2]));
	                }
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	            System.exit(0);
	        }
		
		Population pop = new Population(100, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());	
        
        
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
		
	}

}