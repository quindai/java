package br.ic.ufal;

public class RegraDoTrapezio {

	double f(double x){
		return x;//Math.exp(- x * x / 2) / Math.sqrt(2 * Math.PI);
	}
	
	double integre(double xmin, double xmax, int n){
		double h = (xmax-xmin)/n;
		double soma = 0.5 * (f(xmin) + f(xmax));
		for (int i = 1; i < n; i++){
			double xi = xmin + h*i;
			soma += f(xi);
		}
		
		return soma * h;
	}
	public RegraDoTrapezio() {
		System.out.println("≈ "+ integre(0, 1, 1000));
	}
	public static void main(String[] args) {
		new RegraDoTrapezio();
	}
}
