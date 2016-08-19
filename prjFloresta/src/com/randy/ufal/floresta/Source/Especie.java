package com.randy.ufal.floresta.Source;
/**
 * @Autoria 	::
 * 				Randy Ambrosio Quindai Joao
 * @Data		::
 * 				Maceió, 3 de Setembro de 2011
 * 				UFAL, Alagoas, Brasil
 * @Descricao 	::
 * 				Interface promete que toda especie terá o minimo para existir
 * 			
 * Codigo aberto, a maioria das ideias são originalmente minhas, se for usar por favor mencione a fonte 
 */
import java.awt.Graphics;

public interface Especie {
	public void mover();		//toda especie se move, come e se reproduz
	public boolean reproduzir(Object ob);
	public boolean comer(Object ob);
	public void draw(Graphics g);
}
