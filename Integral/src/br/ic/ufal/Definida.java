package br.ic.ufal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Definida {

	public Definida() {
		NumericalIntegration numInt = new NumericalIntegration(100);
		double z = numInt.integrate(-5, 5);
	}
	
	public static void main(String[] args) {
		new Definida();
	}
	
	class NumericalIntegration{
		private int numIntervalos;
		public NumericalIntegration(int numIntervalos) {
			this.numIntervalos = numIntervalos;
		}
		
		double fun(double x){
			return x*x;
		}
		
		public double integrate(double lowBound, double upBound){
			
			//valores iniciais 2
			ArrayList<Double> arrayCoef = new ArrayList<Double>(numIntervalos+1);
			for (int i = 0; i <= numIntervalos; i++){
				arrayCoef.add(Double.valueOf(2));
			}
			
			arrayCoef.set(0, Double.valueOf(1));
			arrayCoef.set(arrayCoef.size()-1, Double.valueOf(1));
			
			ArrayList<Double> fValues = new ArrayList<Double>(numIntervalos+1);
			
			double intSize = (upBound-lowBound)/numIntervalos;
			for(int i = 0; i <= numIntervalos; i++){
				double x_i = lowBound + i*intSize;
				fValues.add(fun (Double.valueOf(x_i)));
			}
			
			double multValue = inner_product(arrayCoef, fValues);
			double retorna = 0.5*intSize*multValue;
			return retorna;
		}
	}
	
	private double inner_product(ArrayList<Double> vCoef, ArrayList<Double> fValues){
		double retorna = 0.0;
		for (int i = 0; i < vCoef.size(); i++){
			retorna += vCoef.get(i)*fValues.get(i);
		}
		return retorna;
	}
}
