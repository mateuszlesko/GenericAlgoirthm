package genericAlgorithm;

public class SquaredFunction {
	public double func(double x) {
		return x*x;
	}
	
	public double apply(double[]xs) {
		double sum = 0.0;
		for (int i = 0; i < xs.length; i++) {
			sum+=func(xs[i]);
		}
		return sum;
	}
}
