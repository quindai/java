package br.ic.ufal;
/**
 * Dizando, essa classe foi uma tentativa falha,
 * mas eh bom dar uma olhada 
 * 
 */
import java.util.Random;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.JepException;
import com.singularsys.jep.ParseException;

public class Integral {

	/**
	 * 
	 * @param f    funcao
	 * @param xmin intervalo inferior "a"
	 * @param xmax intervalo superior "b"
	 * @param ymin intervalo inferior "c"
	 * @param ymax intervalo superior "d"
	 * @param n	   numero de retangulos
	 */
	public void monteCarlo(IsFunction f, double xmin, double xmax, double ymin, double ymax,int n){
		double mf = 0.0;  //valor medio de f
		double quadrado_mf = 0.0;  //valor medio de f^2
		double area = (xmax - xmin)*(ymax-ymin);
		double error = 0;  //erro na aproximacao
		double aproxim; // aproximacao do valor da integral
		
		for (int i = 0; i < n; i++){
			double xi = getRandomico(xmin, xmax);
			double yi = getRandomico(ymin, ymax);
			double valueF = f.value(xi, yi); //valor de f no ponto (xi,yi) 
			mf += valueF;
			quadrado_mf += valueF*valueF;
		}
		
		mf /= n;	//calcula a media em f
		quadrado_mf /= n;	//calcula a media em f^2
		
		error = area * Math.sqrt((quadrado_mf - Math.pow(mf, 2))/n);
		aproxim = area*mf;
		System.out.println(n+ "    "+ aproxim +"   "+error);
		System.out.println("≈ "+ (aproxim+error));
	}
	
	public String monteCarlo(FunctionJep f,double xmin, double xmax, double ymin, double ymax, int n) throws ParseException, JepException{
		
		double area = (xmax - xmin)*(ymax-ymin);
		double mf = 0.0;  //valor medio de f
		double quadrado_mf = 0.0;  //valor medio de f^2
		double error = 0;  //erro na aproximacao
		double aproxim; // aproximacao do valor da integral
		
		for (int i = 0; i < n; i++){
			double xi = getRandomico(xmin, xmax);
			double yi = getRandomico(ymin, ymax);
			double valueF = f.value(xi, yi); //valor de f no ponto (xi,yi) 
			mf += valueF;
			quadrado_mf += valueF*valueF;
		}
		
		mf /= n;	//calcula a media em f
		quadrado_mf /= n;	//calcula a media em f^2
		
		error = area * Math.sqrt((quadrado_mf - Math.pow(mf, 2))/n);
		aproxim = area*mf;
		String saida = String.format("Numero de Retangulos %d\n"+
				"Valor aproximado da integral:\n≈ %.2f\n"+
				"Erro estimado da aproximacao:\n≈ %.2f\n"+
				"Valor da integral:≈ %.2f", n, aproxim, error, (aproxim+error));
//		System.out.println(n+ "    "+ aproxim +"   "+error);
//		System.out.println("≈ "+ (aproxim+error));
		return saida;
	}
	
	public String monteCarlo(FunctionJep f, double xmin, double xmax, double ymin, String ymax, int n) throws EvaluationException,JepException{
		double mf = 0.0;  //valor medio de f
		double quadrado_mf = 0.0;  //valor medio de f^2
		FunctionJep yinter = new FunctionJep(ymax,"x",xmax);
		
		double valueOfymax = yinter.evaluateD();
		double area = (xmax - xmin)*(valueOfymax-ymin);
		double error = 0;  //erro na aproximacao
		
		double aproxim; // aproximacao do valor da integral
		
		for (int i = 0; i < n; i++){
			double xi = getRandomico(xmin, xmax);
			double yi = getRandomico(ymin, valueOfymax);
			if (yi < yinter.value("x", xi)){
				double valueF = f.value(xi, yi); //valor de f no ponto (xi,yi)
				mf += valueF;
				quadrado_mf += valueF*valueF;
			}
		}
		
		mf /= n;	//calcula a media em f
		quadrado_mf /= n;	//calcula a media em f^2
		
		error = area * Math.sqrt((quadrado_mf - Math.pow(mf, 2))/n);
		aproxim = area*mf;
		String saida = String.format("Numero de Retangulos %d\n"+
				"Valor aproximado da integral:\n≈ %.2f\n"+
				"Erro estimado da aproximacao:\n≈ %.2f\n"+
				"Valor da integral:≈ %.2f", n, aproxim, error, (aproxim+error));
//		System.out.println(n+ "    "+ aproxim +"   "+error);
//		System.out.println("≈ "+ (aproxim+error));
		return saida;
	}
	
	public String monteCarlo(FunctionJep f, double xmin, double xmax, String ymin, String ymax, int n) throws EvaluationException,JepException{
		double mf = 0.0;  //valor medio de f
		double quadrado_mf = 0.0;  //valor medio de f^2
		FunctionJep f_ymax = new FunctionJep(ymax,"x",xmax);
		FunctionJep f_ymin = new FunctionJep(ymin,"x",xmin);
		
		double valueOfymax = f_ymax.evaluateD();
		double valueOfymin = f_ymin.evaluateD();
		double area = (xmax - xmin)*(valueOfymax-valueOfymin);
		double error = 0;  //erro na aproximacao
		
		double aproxim; // aproximacao do valor da integral
		
		for (int i = 0; i < n; i++){
			double xi = getRandomico(xmin, xmax);
			double yi = getRandomico(valueOfymin, valueOfymax);
			if (yi < f_ymax.value("x", xi)){
				double valueF = f.value(xi, yi); //valor de f no ponto (xi,yi)
				mf += valueF;
				quadrado_mf += valueF*valueF;
			}
		}
		
		mf /= n;	//calcula a media em f
		quadrado_mf /= n;	//calcula a media em f^2
		
		error = area * Math.sqrt((quadrado_mf - Math.pow(mf, 2))/n);
		aproxim = area*mf;
		String saida = String.format("Numero de Retangulos %d\n"+
				"Valor aproximado da integral:\n≈ %.2f\n"+
				"Erro estimado da aproximacao:\n≈ %.2f\n"+
				"Valor da integral:≈ %.2f", n, aproxim, error, (aproxim+error));
//		System.out.println(n+ "    "+ aproxim +"   "+error);
//		System.out.println("≈ "+ (aproxim+error));
		return saida;
	}
	private double getRandomico (double inicio, double fim){
		return (fim - inicio) * new Random().nextDouble() + inicio;
	}
	
	public Integral() {
//		Function f = new Function("");
//		FunctionJep f;
//		try {
//			f = new FunctionJep("8x + 6y");
//			monteCarlo(f, 0, 1, 0, "2x^2", 1000);
//		} catch (EvaluationException e) {
//			e.printStackTrace();
//		} catch (JepException e) {
//			e.printStackTrace();
//		}
		//monteCarlo(f, 0, 1, 0, 2, 1000);
	}
	
//	public static void main(String[] args) {
//		new Integral();
//	}
}
