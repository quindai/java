package com.randy.ufal.floresta.Source;

import java.awt.Dimension;

public class Cogumelo extends Vegetacao{
	public Cogumelo(Dimension a){
		super(a, "cogumelo.png");
		nome = "Cogumelo";
		toxicidade = (int)(Math.random() * 3) + 1;
	}
	
	private String getToxicidadeNome(){
		String saida = "";
		switch (toxicidade) {
		case 0:
			saida = "";
			break;
		case 1:
			saida = tipoToxicidade.TOXICO.name();
		case 2:
			saida = tipoToxicidade.MUITO_TOXICO.name();
		default:
			saida = tipoToxicidade.DEAD_KILLER_XTREME_TOXICO.name();
		}
		return saida;
	}
	
	public String toString(){
		return String.format("%s %s", super.toString(), getToxicidadeNome());
	}
}
