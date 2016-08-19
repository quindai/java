package com.randy.ufal.floresta.Source;
/**
 * @Autoria 	::
 * 				Randy Ambrosio Quindai Joao
 * @Data		::
 * 				Maceió, 3 de Setembro de 2011
 * 				UFAL, Alagoas, Brasil
 * @Descricao 	::
 * 				Gerencia a vegetacao
 * 			
 * Codigo aberto, a maioria das ideias são originalmente minhas, se for usar por favor mencione a fonte 
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;



public abstract class Vegetacao {
	enum tipoToxicidade {TOXICO, MUITO_TOXICO, DEAD_KILLER_XTREME_TOXICO}
	protected Image img;
	protected int iw, ih;
	protected int x, y;
	protected int dx, dy;
	protected int toxicidade = 1;
	protected boolean estaAtivo;
	protected Dimension area;
	protected String nome;
	
	public Vegetacao(Dimension a, String img){
		area = a;
		this.img = new ImageIcon("imagens/"+ img).getImage();
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
	
	public int getToxicidade(){
		return toxicidade;
	}
	public void draw(Graphics g){	//todo animal sabe como se desenhar
		if (estaAtivo) g.drawImage(img, x-iw/2, y-ih/2, null);
	}
	public int getX(){ return x; }
	public int getY(){ return y; }
	
	public String toString(){
		return nome;
	}
}
