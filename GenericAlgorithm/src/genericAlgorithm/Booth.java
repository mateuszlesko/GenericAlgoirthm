package genericAlgorithm;

public class Booth {
	public double func(double x1,double x2) {
		double part1 = Math.pow((x1+2*x2-7),2);
		double part2 = Math.pow((2*x1+x2-5),2);
		
		return part1+part2;
	}
	
	public double apply(double[]xs) {
		double sum = 0.0;
		for (int i = 1; i < xs.length; i++) {
			sum+=func(xs[i-1],xs[i]);
		}
		return sum;
	}
}
