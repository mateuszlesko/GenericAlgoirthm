package genericAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class EightPointCrossing {
	int chromosomeLenght;
	ArrayList<Integer> crossingPoints = new ArrayList<Integer>();
	
	public EightPointCrossing(int _chromosomeLenght) {
		chromosomeLenght = _chromosomeLenght;
		crossingPoints = drawCrossingPoints(8);
	}
	
	private ArrayList<Integer> drawCrossingPoints(int length) {
		 ArrayList<Integer> numbers = new ArrayList<Integer>();   
		    Random randomGenerator = new Random();
		    while (numbers.size() < length){
		      int random = drawCrossingPoint(1,chromosomeLenght);
		      if (!numbers.contains(random)) {
		        numbers.add(random);
		      }
		    }
		numbers.sort(null);    
		return numbers;
	}
	
	public char[] getChild(char [] parentX, char[] parentY) {
		
		char [] childChromosome = new char[chromosomeLenght];

		int in = 0;
	    int turn = 0;
	    //repeat x time; where x is the count of crossing points
	    for(int i = 0; i < crossingPoints.size();i++){
	      //get following crossing point
	      int point = crossingPoints.get(i);
	      //until get to crossing point dopoki
	      do {
	        // parent 1 part
	        if(turn % 2 == 0){
	        	childChromosome[in] = parentX[in];
	        }
	        // parent 2 part
	        else{
	        	childChromosome[in] = parentY[in];
	        }

	        in++;
	       
	      }while(in < point);
	      turn++;
	    }
	    //for the rest: from the last crossing point to end of table
	    while(in < parentX.length){
	      //parent 1 part
	        if(turn % 2 == 0){
	        	childChromosome[in] =parentX[in];
	        }
	        //parent 2 part
	        else{
	        	childChromosome[in] = parentY[in];
	        }
	        in++;
	    }
	    
		return childChromosome;
	}
	
	private static int drawCrossingPoint(int max, int min) {
		return (int)((Math.random() * (max - min)) + min);
	}
}
