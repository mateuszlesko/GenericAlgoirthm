package genericAlgorithm;

public class Intersection2P extends Intersection {
	
	private int intersectPoint1,intersectPoint2; //punkt wydzielenia 2 czesci
	
	public Intersection2P(int _chromosomeLength){
		chromosomeLength = _chromosomeLength;
		intersectPoint1 = super.getRandomNumber(0,chromosomeLength);
		intersectPoint2 =  super.getRandomNumber(0,chromosomeLength);
		checkIntersectPoints();
		
	}
	
	@Override
	protected Chromosome getChild(Chromosome parentX, Chromosome parentY) {
		char [] childChromosome = new char[chromosomeLength];
		//pierwsza czesc z rodzica X
		for(int i = 0; i < intersectPoint1;i++) {
			childChromosome[i] = parentX.chromosome[i];
		}
		//srodek z rodzica Y
		for(int i = intersectPoint1; i < intersectPoint2; i++) {
			childChromosome[i] = parentY.chromosome[i];		
		}
		//koniec z rodzica X
		for(int i = intersectPoint2; i < chromosomeLength; i++) {
			childChromosome[i] = parentX.chromosome[i];		
		}
		
		Chromosome child = new Chromosome(parentX.getStart(),parentX.getEnd(),parentX.n,parentX.precision);
		child.chromosome = childChromosome;
		return child;
	}
	
	//sprawdzam czy punkt 1 krzyzowania jest < niz punkt 2 krzyzowania ; jesli nie to zamieniam je 
	private void checkIntersectPoints() {
		if(intersectPoint1 > intersectPoint2) {
			int point = intersectPoint1;
			intersectPoint1 = intersectPoint2;
			intersectPoint2 = point;
		}
		
		if(intersectPoint1 == intersectPoint2) {
			intersectPoint1 = super.getRandomNumber(0,chromosomeLength);
			intersectPoint2 =  super.getRandomNumber(0,chromosomeLength);
		}
	}
	
}
