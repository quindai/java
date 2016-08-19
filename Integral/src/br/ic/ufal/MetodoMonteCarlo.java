package br.ic.ufal;

import java.util.Random;

public class MetodoMonteCarlo {

	public MetodoMonteCarlo() {
		
		System.out.println(3 + (int)Math.random() * (6-3) + 1);
		System.out.println(getRandomico(3, 6));
//		System.out.println("Valor aproximado da integral com 100 retangulos: "+  f(100,0,2,0,2));
	}
	
	/**
	 * @see http://www.javapractices.com/topic/TopicAction.do?Id=62
	 * @param inicio
	 * @param fim
	 * @return numero gerado aleatoriamente no intervalo [inicio,fim]
	 */
	double getRandomico (double inicio, double fim){
		return ((fim - inicio) + 1) * new Random().nextDouble() + inicio;
	}
	
	double fun (double x, double y){
		return 16 - Math.pow(x, 2) - 2*Math.pow(y, 2);
	}
	
	/**
	 * 
	 * @param n precisao(numero de retangulos)
	 * @return
	 */
	double f(int n, double x1, double x2, double y1, double y2){
		double retorna = 0;
		double xi = (x2 - x1)/n;
		double yi = (y2 - y1)/n;
		for(int i = 0; i < n; i++)
			retorna += fun(xi, yi);
		
		return (retorna*1/n)*(x2-x1)*(y2-y1);
	}
	
	public static void main(String[] args) {
		new MetodoMonteCarlo();
	}
}
