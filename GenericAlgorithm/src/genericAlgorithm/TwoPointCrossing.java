package genericAlgorithm;

public class TwoPointCrossing {
	int chromosomeLength;
	private int crossingPoint1,crossingPoint2; //2 parts
	
	public TwoPointCrossing(int _chromosomeLength){
		chromosomeLength = _chromosomeLength;	
	}
	
	public void drawCrossingPoints() {
		crossingPoint1 = getRandomNumber(0,chromosomeLength);
		crossingPoint2 =  getRandomNumber(0,chromosomeLength);
		checkCrossingPoints();
	}
	protected char[] getChild(char[] parentX, char[] parentY) {
		char [] childChromosome = new char[chromosomeLength];
		System.out.println("===== PARENT 1 ======");
		System.out.println(parentX);
		System.out.println("===== PARENT 2 ======");
		System.out.println(parentY);
		System.out.println(crossingPoint1+" "+crossingPoint2);
		//the first part from parent X
		for(int i = 0; i < crossingPoint1;i++) {
			childChromosome[i] = parentX[i];
		}
		//the middle from parent Y
		for(int i = crossingPoint1; i < crossingPoint2; i++) {
			childChromosome[i] = parentY[i];		
		}
		//the rest from parent X
		for(int i = crossingPoint2; i < chromosomeLength; i++) {
			childChromosome[i] = parentX[i];		
		}
		
		
		return childChromosome;
	}
	
	// checking if point 1 < point 2; else swap them
	private void checkCrossingPoints() {
		if(crossingPoint1 > crossingPoint2) {
			int point = crossingPoint1;
			crossingPoint1 = crossingPoint2;
			crossingPoint2 = point;
		}
		
		if(crossingPoint1 == crossingPoint2) {
			crossingPoint1 = getRandomNumber(0,chromosomeLength);
			crossingPoint2 =  getRandomNumber(0,chromosomeLength);
		}
	}
	
	protected int getRandomNumber(int min, int max) {
	    return (int)((Math.random() * (max - min)) + min);
	}
}
