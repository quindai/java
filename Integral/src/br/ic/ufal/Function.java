package br.ic.ufal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function implements IsFunction {

	/**
	 * Recebe uma funcao do tipo String e a prepara
	 */
	private String f;
	
	public Function(String f){
		//if (isValid(f))
			this.f = f;
	}
	
	public static void main(String[] args) {
		new Function("2+");
	}
	@Override
	public double value(double x) {
		return 2*Math.pow(x, 2);
	}

	@Override
	public void setOffset(double o) {
		
	}
	
	@Override
	public double value(double x, double y) {
		return 8*x + 6*y;
	}
	
	public static boolean isValid(String f){
		//reconhece qualquer soma linear com variaveis contendo argumento ou nao
		Pattern pattern = Pattern.compile("((\\d)*([a-zA-Z]{1})?\\s*([+-/\\*]?)(?(3)\\d)");
		
		Matcher matcher = pattern.matcher(f);
		boolean r = matcher.matches();
		return matcher.matches();
	}
	
	@Override
	public String toString(){
		return f;
	}
}
