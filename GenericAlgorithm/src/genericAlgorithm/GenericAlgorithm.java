package genericAlgorithm;

public class GenericAlgorithm {

	    public static double Ai = -4.5;
	    public static double Bi = 4.5;
	    static double precision = 1000;
	    public int genCount = 2;
	    public double mutationPropability = 0.04;
	    public double crossingPropability = 0.6;
	    
	    public int populationLength;

	    public int generation;

	    public double localBestSolution;
	    public int evaluationPointer = 0;
	    
	    Invidual[] population;
	    
	    Invidual najlepszy = null;

	    int ewaulacje;
	    
	    int MI = 1;
	    
	    public GenericAlgorithm(int _n, int _populationLength, double _MutationPropability, double _krzyzowaniePropability) {
	        mutationPropability = _MutationPropability;
	        crossingPropability = _krzyzowaniePropability;
	        populationLength = _populationLength;
	        genCount = _n;
	        //step 1: creating primary population
	        population = stworzPopulacje();
	        MI = Invidual.Mi(Ai, Bi, precision);
	    }

	    
	    private Invidual[] stworzPopulacje(){
	    	
	    	Invidual [] _population = new Invidual[populationLength];
	    	for(int i = 0; i < populationLength; i++) {
	    		_population[i] = new Invidual(Ai,Bi,genCount,precision);
	    		
	    	}
	    	return _population;
	    }
	    
	    
	    private Invidual znajdzNajlepszegoObecnie(Invidual [] population) {
	   
	    	Invidual najlepszy = population[0];
	    	for(int i = 1; i < populationLength; i++) {
	    		if(najlepszy.compareTo(population[i]) == 1) {
	    			najlepszy = population[i];
	    		}
	    	}
	    	return najlepszy;
	    }
	    
	    private void zmienPopulacje(Invidual[] nowa) {
	    	for(int i = 1; i < populationLength; i++) {
	    		population[i] = nowa[i];
	    	}
	    }
	    
	    public Invidual[] run(double env) {
	        evaluationPointer = 1;
	        String probe = "";
	        
	        while (evaluationPointer <= env) {
	        	double wartosciFunkcji [] = new double[populationLength];
	        	
	        	//step 2: calculating population values
	        	for(int i = 0; i < populationLength; i++) {
	        		population[i].functionValue = population[i].calculateFunctionValue();
	        		wartosciFunkcji[i] = population[i].functionValue;
	        		evaluationPointer++;
	        	}
	        	probe = (evaluationPointer)+";"+PopulationAVGValue(wartosciFunkcji);
	        	probe = probe.replace('.',',');
	    		saveSolutions(probe,populationLength);
	    	
	        	
	        	// step 3: selecting the best solutions to auxiliary population
	        	TournamentSelection TournamentSelection = new TournamentSelection(population);
	        	najlepszy = znajdzNajlepszegoObecnie(population);
	        	localBestSolution = najlepszy.functionValue;
	        	
	        	population = TournamentSelection.organizeFullTournament();
	        	population[0] = najlepszy;
	        	
	        	// step 4: mutating an auxiliary population; going into another space
	        	population = mutatePopulation(population);      	
	        	
	        	for(int i = 0; i < populationLength; i++) {
	        		population[i].functionValue = population[i].calculateFunctionValue();
	        	}
	        	
	        	// step 5: crossing an mutated auxiliary population; searching entered space
	        	if(genCount <= 20) {
	        		population = cross2Points(population);
	        	}
	        	else {
	        		population = cross8Points(population);
	        	}
	        	
	        	for(int i = 0; i < populationLength; i++) {
	        		population[i].functionValue = population[i].calculateFunctionValue();
	        	}
	        	
	        	//geting probes of searching results
	        	probe = (evaluationPointer)+";"+localBestSolution;
	          	probe = probe.replace('.',',');
	          	saveBestLocalSolution(probe, populationLength);
	          	
	          	if(localBestSolution <= Main.globalBest) {
	          		Main.globalBest = localBestSolution;
	          	}
	          	
	          	probe = evaluationPointer+";" + Main.globalBest;
	          	probe = probe.replace(".",",");
	        	saveBestGlobalSolution(probe);
	          	
	        }
	      
	        return population;
	    }
	    
	    private Invidual[] cross2Points(Invidual[] population) {
	    	TwoPointCrossing TwoPointCrossing = new TwoPointCrossing(genCount*MI);
	    	for(int i = 0; i < population.length;i++) {
	    		TwoPointCrossing.drawCrossingPoints();
	    		if(Math.random() < crossingPropability) {
	    			int partner = drawCrossingPartner(populationLength,0);
	    			char [] parentGenesX = population[i].getLinear();
	    			char [] parentGenesY = population[partner].getLinear();
	    			population[i].chromosome = Invidual.changeToGens(TwoPointCrossing.getChild(parentGenesX, parentGenesY),genCount,MI);
	    			population[partner].chromosome = Invidual.changeToGens(TwoPointCrossing.getChild(parentGenesY, parentGenesX),genCount,MI);
	    		}
	    		
	    	}
	    	return population;
	    }
	    private Invidual[] cross8Points(Invidual[] population) {
	    	Invidual[] crossedInviduals = Invidual.copyPopulation(population, population.length);
	    	EightPointCrossing EightPointCrossing = new EightPointCrossing(genCount*MI);
	    	for(int i = 0; i < population.length;i++) {
	    		
	    		if(Math.random() < crossingPropability) {
	    			int partner = drawCrossingPartner(populationLength,0);
	    			char [] parentGenesX = crossedInviduals[i].getLinear();
	    			char [] parentGenesY = crossedInviduals[partner].getLinear();
	    			crossedInviduals[i].chromosome = Invidual.changeToGens(EightPointCrossing.getChild(parentGenesX, parentGenesY),genCount,MI);
	    		}
	    	}
	    	return crossedInviduals;
	    }
	    
	    private Invidual[] mutatePopulation(Invidual[] population) {
	    	
	    	Invidual[] mutatedInviduals = Invidual.copyPopulation(population, population.length);
	    	
	    	char [] mutatedChromosome = new char[genCount*13];
	    	Mutation Mutation = new Mutation(mutationPropability);
	    	for(int i = 0; i < populationLength; i++) {
	    		
	    		//choosing if gen will be mutated
	    		if(Math.random() < mutationPropability) {
	    			mutatedChromosome =  Mutation.InvidualMutation(mutatedInviduals[i].getLinear());
	    			mutatedInviduals[i].chromosome = Invidual.changeToGens(mutatedChromosome, genCount, MI);
	    		}
	    	}
	    	return mutatedInviduals;
	    }
	    
	    private static double PopulationAVGValue(double [] populationValues) {
	    	double AVG = 0.0;
	    	int populationLength = populationValues.length;
	    	for(int i = 0; i < populationLength;i++) {
	    		AVG+=populationValues[i];
	    	}
	    	return AVG / populationLength;
	    }
	    
	    private static void saveBestGlobalSolution( String probe) {
	        FileSaver FileSaverWszystkich = new FileSaver("globalBests.txt");
	        FileSaverWszystkich.WriteToFile(probe);
	    }
	    
	    private static void saveBestLocalSolution(String probe, int population) {

	        FileSaver FileSaverNajlepszychLokalnie = new FileSaver("localBests" + population + "." + ".txt");
	        FileSaverNajlepszychLokalnie.WriteToFile(probe);
	    }

	    private static void saveSolutions(String probe, int population) {

	        FileSaver FileSaverNajlepszychLokalnie = new FileSaver("all" + population + "." + ".txt");
	        FileSaverNajlepszychLokalnie.WriteToFile(probe);
	    }
	    private static int drawCrossingPartner(int max, int min) {
			return (int)((Math.random() * (max - min)) + min);
		}
}
