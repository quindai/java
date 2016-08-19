package br.ic.ufal;

public class DoubleIntegral {

	public DoubleIntegral() {
		double lowBound1 = 3;
		double upBound1 = 5;
		double lowBound2 = 1;
		int n = 1000;
		double dy = (upBound1 - lowBound1)/n;
		double result = sumDoubleIntegral(lowBound1,lowBound2, n, dy);
	}
	double fun(double x){
		return x*x/2+3*x-1/x;
	}
	
	double sumIntegral(double lowBound, int n, double dx){
		double sumSum = 0.0;
		for(int i = 0; i < n; i++){
			double xi = lowBound + i * dx;
			double funValue = fun(xi);
			double retangleArea = funValue * dx;
			sumSum += retangleArea;
		}
		return sumSum;
	}
	
	double sumDoubleIntegral(double lowBound,double lowBound2, int n, double dy){
		double sumSum = 0.0;
		for(int i = 0; i < n; i++){
			
			double yi = lowBound + i * dy;
			double dx = (yi - lowBound2)/n;
			double smallSum = 0;
			
			for(int j = 0; j < n; j++){
				double xi = lowBound + dx*j;
				double funValue = fun(xi);
				double retangleArea = funValue * dx;
				smallSum += retangleArea;
			}
			
			double secRetangle = smallSum * dy;
			sumSum += secRetangle;
		}
		return sumSum;
	}
	
	public static void main(String[] args) {
		new DoubleIntegral();
	}
}
