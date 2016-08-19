package com.randy.ufal.floresta.Source;

import java.awt.Dimension;

public class Coelho extends Terrestre{
	
	public Coelho(Dimension a){
		super(a, "coelho.png");
		nome = "Coelho";
		tempoVida = (int)(Math.random() * 5) + 1;	//tempo de vida aleatorio
	}	
	
}
