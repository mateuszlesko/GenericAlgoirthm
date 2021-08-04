package genericAlgorithm;


public class Beale {
	public double func(double x1,double x2) {
		double part1 = Math.pow((1.5 - x1 + ( x1*x2)), 2);
		double part2 = Math.pow((2.25-x1+(x1* Math.pow(x2, 2))),2);
		double part3 = Math.pow((2.625 - x1 + (x1*Math.pow(x2, 3)) ), 2);
		return part1+part2+part3;
	}
	
	public double apply(double[]xs) {
		double sum = 0.0;
		for (int i = 1; i < xs.length; i++) {
			sum+=func(xs[i-1],xs[i]);
		}
		return sum;
	}
}
