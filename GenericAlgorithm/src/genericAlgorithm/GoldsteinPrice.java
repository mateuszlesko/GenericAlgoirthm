package genericAlgorithm;

public class GoldsteinPrice {
	public double func(double x1,double x2) {
		double fact1a = Math.pow((x1+x2+1), 2);
		double fact1b = 19 - 14*x1;
		double fact1c = Math.pow((3*x1), 2);
		double fact1d = -14*x2;
		double fact1e = 6*x1*x2;
		double fact1f = Math.pow(3*x2, 2);
		
		double fact1 = (1+fact1a *( fact1b + fact1c + fact1d + fact1e + fact1f));
		
		double fact2a = Math.pow((2*x1-3*x2),2);
		double fact2b = 18 - 32*x1;
		double fact2c = (12*Math.pow(x1, 2));
		double fact2d = 48*x2;
		double fact2e = -36*x1*x2;
		double fact2f = (27*Math.pow(x1, 2));
		
		double fact2 = (30 + fact2a * (fact2b + fact2c*fact2d + fact2e + fact2f));
		return fact1*fact2;
	}
	
	public double apply(double[]xs) {
		double sum = 0.0;
		for (int i = 1; i < xs.length; i++) {
			sum+=func(xs[i-1],xs[i]);
		}
		return sum;
	}
}
