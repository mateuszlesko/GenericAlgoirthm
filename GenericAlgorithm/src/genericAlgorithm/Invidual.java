package genericAlgorithm;


public class Invidual implements Comparable<Invidual>{
	 double Ai, Bi;
	    double precision = 1000d;
	    int MI;
	    int n = 1;
	    		
	    char[][] chromosome;
	    double[] gensValues;
	    double functionValue = 9999.9;
	    
	    //funkcje:
	    //functionKwadratowa function;
	    //function beale:
	    Beale function;
	    //Booth function;
	    //GoldsteinPrice function;
	    //Rosenbrock function;
	    
	    public Invidual() {}
	    public Invidual(double Ai, double Bi, int n, double precision) {
	        this.Ai = Ai; // wartosc poczatku przedzialu values
	        this.Bi = Bi; // wartosc konica przedzialu values
	        this.n = n; // liczba genow
	        this.precision = precision;
	        MI = Mi(Ai,Bi,precision);
	        chromosome = create();
	        gensValues = new double[n];
	       //function = new functionKwadratowa();
	        function = new Beale();
	       //function = new Booth();
	        //function = new GoldsteinPrice();
	       // function = new Rosenbrock();
	    }
	    
	    @Override
	    protected Object clone() throws CloneNotSupportedException{
	    	
	    	Invidual Invidual = new Invidual(Ai, Bi, n, precision);
	    	Invidual.chromosome = new char[n][MI];
	    	
	    	return super.clone();
	    }
	    
	    @Override
	    public int compareTo(Invidual secondOne) {
	    	if(this.functionValue < secondOne.functionValue) {
	    		return -1;
	    	}
	    	else if(this.functionValue > secondOne.functionValue) {
	    		return 1;
	    	}
	    	else {
	    		return 0;
	    	}
	    }
	   
	    public void ustawChromosom(char[][] values) {
	        chromosome = values;
	    }

	    //wyliczenie ilu bit�w potrzebne jest do zakodowania 1 genu.
	    public static int Mi(double Ai, double Bi, double precision) {
	        return (int) Math.round(Log2((Bi - Ai) * precision));
	    }

	    //c : generowanie losowo chromosomu w postaci binarnej
	    private double decoding(char[] gen) {
	        double rezultat = Ai + Integer.parseInt(new String(gen), 2) * (Bi - Ai) / (Math.pow(2, MI) - 1);
	        return Math.round(rezultat * precision) / precision;
	    }
	    
	    private char[] createGen() {
	        char[] gen = new char[MI];
	        for (int i = 0; i < MI; i++) {
	            gen[i] = 0 + (int)(Math.random() * 2) == 0 ? '0' : '1';
	        }
	        return gen;
	    }
	    
	    private char[][] create() {
	        char[][] _chromosome = new char[n][MI];
	        double value = 0.0;
	        char[] gen = new char[MI];
	        for (int i = 0; i < n; i++) {
	            gen = createGen();
	            value = decoding(gen);
	            while (!(value >= -5.12 && value <= 5.12)) {
	                gen = createGen();
	                value = decoding(gen);
	            }
	            _chromosome[i] = gen;
	        }
	        return _chromosome;
	    }

	    public double calculateFunctionValue() {
	    	return function.apply(getGensValues(chromosome));
	    }
	    
	    //dostanie dowolnego genu po przez podanie jego numeru
	    public String getXn(int gen) {
	        return new String(chromosome[gen]);
	    }
	    
	    //dekodowanie zakodowanego binarnie genu na jego value decymalna
	    public double decoding(int gen) {
	        double result = Ai + Integer.parseInt(getXn(gen), 2) * (Bi - Ai) / (Math.pow(2, MI) - 1);
	        return Math.round(result * precision) / precision;
	    }

	    public char[] getLinear() {
	        char[] line = new char[MI * n];
	        int pointer = 0;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < MI; j++) {
	                line[pointer] = chromosome[i][j];
	                pointer++;
	            }
	        }
	        return line;
	    }

	    public String toString() {
	        String chromosome = "";
	        for (int i = 0; i < n; i++)
	            chromosome += getXn(i);
	        return chromosome;
	    }

	    private static double Log2(double x) {
	        return (Math.log(x) / Math.log(2));
	    }
	    
	    public static char[][] changeToGens(char[] line, int n, int MI) {
	        char[][] _gens = new char[n][MI];
	        int pointer = 0;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < MI; j++) {
	                _gens[i][j] = line[pointer];
	                pointer++;
	            }
	        }
	        return _gens;
	    }
	    
	    private double[] getGensValues(char[][] chromosome) {
	    	double [] values = new double[n];
	    	
	    	for(int i = 0; i < n; i++) {
	    		values[i] = decoding(chromosome[i]);
	    	}
	    	return values;
	    }
	    
	    static Invidual copy(Invidual Invidual) {
	    	Invidual copy = new Invidual();
	    	copy.chromosome = Invidual.chromosome;
	    	copy.gensValues = Invidual.gensValues;
	    	copy.functionValue = Invidual.functionValue;
	    	copy.Ai = Invidual.Ai;
	    	copy.Bi = Invidual.Bi;
	    	copy.precision = Invidual.precision;
	    	copy.n = Invidual.n;
	        copy.MI = Invidual.MI;
	      // copy.function = new functionKwadratowa();
	        copy.function = new Beale();
	       //copy.function = new Booth();
	       // copy.function = new GoldsteinPrice();
	       // copy.function = new Rosenbrock();
	        return copy;
	    }
	    
	    static Invidual[] copyPopulation(Invidual [] populacja, int size) {
	    	Invidual [] copyPopulation = new Invidual[size];
	    	for(int i  = 0; i < size; i++) {
	    		copyPopulation[i] = copy(populacja[i]);
	    	}
	    	return copyPopulation;
	    }
}
