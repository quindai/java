package com.randy.ufal.floresta.Source;
/**
 * @Autoria 	::
 * 				Randy Ambrosio Quindai Joao
 * @Data		::
 * 				Maceió, 3 de Setembro de 2011
 * 				UFAL, Alagoas, Brasil
 * @Descricao 	::
 * 				Gerencia o comportamento de todos os animais terrestres, como se movem, como comem...
 * 			
 * Codigo aberto, a maioria das ideias são originalmente minhas, se for usar por favor mencione a fonte 
 */
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class Terrestre extends Animal{
	
	public Terrestre(Dimension a, String img){
		area = a;
		this.img = new ImageIcon("imagens/" +img).getImage();
		iw = this.img.getWidth(null);
		ih = this.img.getHeight(null);
		// x e y calculados usando a area do jogo
		x = (int)(iw / 2 + Math.random() * (a.width - iw));
		y = (int)(ih / 2 + Math.random() * (a.height  -ih));
		
		// dx e dy aleatorios
		while( dx == 0 || dy == 0)
		{
			dx = 3 - (int) (Math.random() * 6);
			dy = 2 - (int) (Math.random() * 4);
		}
		estaAtivo = true;
	}
	//movimenta os animais e verifica se esta na area valida
	public void mover(){
		if (estaAtivo)
		{
			x += dx;
			y += dy;
			if (x < iw/2){ dx = -dx; x+= dx;}
			if (y < ih/2){ dy = -dy; y+= dy;}
			if (x > area.width - iw/2){ dx = -dx; x+= dx;}
			if (y > area.height - ih/2){ dy = -dy; y+= dy;}
		}
	}
	
//	public void setAssexuado(boolean istrue){
//		
//	}
//	
}
