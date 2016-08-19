package com.randy.ufal.floresta.Source;
/**
 * @Autoria 	::
 * 				Randy Ambrosio Quindai Joao
 * @Data		::
 * 				Maceió, 3 de Setembro de 2011
 * 				UFAL, Alagoas, Brasil
 * @Descricao 	::
 * 				Gerencia o comportamento do lobo, a agressividade influencia em como o lobo se alimenta
 * 				e.g: lobo se cruza com Coelho-> lobo MANSO pode deixar passar mais um lobo FURIOSO
 * 					 							ou FAMINTO devora o coelho
 *  
 * Codigo aberto, a maioria das ideias são originalmente minhas, se for usar por favor mencione a fonte 
 */
import java.awt.Dimension;

enum estado {MANSO, FAMINTO, FURIOSO, RAIVOSO}

public class Lobo extends Terrestre{
	
	int margem;		//estado de espirito do animal / humor
	public Lobo(Dimension a) {
		super(a, "lobo.png");
		nome = "Lobo";
		herbivoro = false;
		tempoVida = (int)(Math.random() * 7) + 1;
	}
	
	public boolean comer(Object ob){
		Animal obj = (Terrestre)ob;
		boolean saida = false;
		int ox = obj.getX();
		int oy = obj.getY();
		margem = (int)(Math.random()*4);	//torna a agressividade aleatoria
		
		if(Math.sqrt((x-ox) * (x-ox) + (y-oy)) < margem){
			if(obj.estaAtivo){
				obj.estaAtivo = false;
				saida = true;
			}
		}
		return saida;
	}
	
	private String getEstado(){
		String saida = "";
		switch(margem){
		case 0: 
			saida = estado.MANSO.name();
			break;
		case 1: 
			saida = estado.FAMINTO.name();
			break;
		case 2: 
			saida = estado.FURIOSO.name();
			break;
		default:
			saida = estado.RAIVOSO.name();
		}
		return saida;
	}
	
	public String toString(){
		return String.format("%s %s", super.toString(), getEstado());
	}

}