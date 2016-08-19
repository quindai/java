package br.ic.ufal;

public class Riemman {

	public Riemman() {
		System.out.println(MonteCarlo(0, Math.PI, 1000000));
	}
	
	double f(double x){
		return Math.cos(x)* Math.cos(x);
	}
	double MonteCarlo(double xmin, double xmax, int n){
		int aceito = 0;
		 
		double xxmax = xmax - xmin;
				 
		for (int i = 10000; i <= n; i++){
//			System.out.println(i);
						//r1
			double xr = Math.random() * xxmax;
						//r2
			double fr = Math.random() * f(xxmax); //funcao f(x) = xmax
			
			if(fr <= f(xr))  //f(xr) xr, funcao fx
				aceito++;
		}
		double fmax = 1+f(xxmax*xxmax);
		double retorno = (aceito/n)*fmax;
		return retorno;
	}
	
	public static void main(String[] args) {
		new Riemman();
	}
}
