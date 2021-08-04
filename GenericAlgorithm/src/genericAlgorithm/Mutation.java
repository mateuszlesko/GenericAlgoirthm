package genericAlgorithm;

public class Mutation {
	private double propability = 0.1;
	Invidual Invidual;
	
	public Mutation(Invidual Invidual,double propability) {
		this.propability = propability; //prawdopodobienstwo
		this.Invidual = Invidual;
	}
	
	public Mutation(double propability) {
		this.propability = propability; //prawdopodobienstwo
	}
	
	public Invidual InvidualMutation() {
		char chromosome [] = Invidual.getLinear();
		for(int i = 0; i < Invidual.chromosome.length;i++) {
			double _propability = Math.random();
			if(_propability < propability) {
				chromosome[i] = chromosome[i] == '0' ? '1' : '0';
			}
		}
		return Invidual;
	}
	
	public char[] InvidualMutation(char [] chromosome) {
		for(int i = 0; i < chromosome.length;i++) {
			double _propability = Math.random();
			if(_propability < propability) {
				chromosome[i] = chromosome[i] == '0' ? '1' : '0';
			}
		}	
		return chromosome;
	}
}
