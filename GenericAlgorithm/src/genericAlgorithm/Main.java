package genericAlgorithm;

public class Main {
	
	static int evaulationMax = 10000;
	static int population = 10;
	
	static double globalBest = 450000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericAlgorithm GenericAlgorithm = new GenericAlgorithm(2,1000,0.04,0.6);
		GenericAlgorithm.run(evaulationMax);
		System.out.println("Rozwiazanie "+globalBest);
	}

}