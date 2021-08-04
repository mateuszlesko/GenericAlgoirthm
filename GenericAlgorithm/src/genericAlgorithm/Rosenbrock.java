package genericAlgorithm;

public class Rosenbrock {
	public double func(double x1,double x2) {
		double f1 = Math.pow(100*(x2-Math.pow(x2,2)),2);
		double f2 = Math.pow((x1-1), 2);
		return f1+f2;
	}
	
	public double apply(double[]xs) {
		double sum = 0.0;
		for (int i = 1; i < xs.length; i++) {
			sum+=func(xs[i-1],xs[i]);
		}
		return sum;
	}
}
