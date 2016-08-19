package com.randy.ufal.floresta.Source;

import java.awt.Dimension;

public class Rato extends Terrestre{
	public Rato(Dimension a){
		super(a, "rato.png");
		nome = "Rato";
	}
	
	@Override
	public boolean comer(Object ob){	//ratos menos gulosos
		Vegetacao obj = (Vegetacao)ob;
		boolean saida = false;
		int ox = obj.getX();
		int oy = obj.getY();
		
		if(Math.sqrt((x-ox) * (x-ox) + (y-oy)) < 1){
			if(obj.estaAtivo){
				obj.estaAtivo = false;
				saida = true;
			}
		}
		return saida;
	}
}
