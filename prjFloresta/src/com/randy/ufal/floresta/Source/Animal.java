package com.randy.ufal.floresta.Source;
/**
 * @Autoria 	::
 * 				Randy Ambrosio Quindai Joao
 * @Data		::
 * 				Maceió, 3 de Setembro de 2011
 * 				UFAL, Alagoas, Brasil
 * @Descricao 	::
 * 				Contem o suficiente para que um animal exista nessa floresta
 * 			
 * Codigo aberto, a maioria das ideias são originalmente minhas, se for usar por favor mencione a fonte 
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
//enum especHerbivoro {TARTARUGA, TATU, ELEFANTE, COELHO, KOALA, CAVALO}
//enum especCarnivoro {LOBO, LEAO, TIGRE, RAPOSA, CARNOTAURO, OVIRAPTOR, CHITA}

public abstract class Animal implements Especie{

	
	protected boolean assexuado = true;	//assume que todo animal he assexuado 
	protected int x, y;					//coordenadas do animal
	protected int dx, dy;				//coordenada aleatoria do animal
	protected int tempoVida = 3;		//tempo de vida do animal - assume que todo animal vive pelo menos 10 ciclos
	protected boolean estaAtivo;
	protected boolean herbivoro = true;
	protected int iw, ih; //tamanho em pixel
	protected Image img;
	protected Dimension area;
	protected String nome;	//NOME DO ANIMAL
	
	public Animal(){
		
	}
	
	public Animal(Dimension a){

	}
	
	public boolean reproduzir(Object ob){
		boolean saida = false;
		Animal obj = (Animal)ob;
		int ox = obj.getX();
		int oy = obj.getY();
		//if(((x - 3) >= ox) && ((y - 3) >= oy)){
		if(Math.sqrt((x-ox) * (x-ox) + (y-oy)) < 3){
			if(obj.estaAtivo){
				//if(obj.equals(obj))
				saida = true;
				System.out.println("Reproduzindo");
			}
		}
		
		return saida;
	}
	
	public boolean comer(Object ob){
		Vegetacao obj = (Vegetacao)ob;
		boolean saida = false;
		int ox = obj.getX();
		int oy = obj.getY();
		//if(((x - 3) >= ox) && ((y - 3) >= oy)){
		if(Math.sqrt((x-ox) * (x-ox) + (y-oy)) < 2){
			if(obj.estaAtivo){
				obj.estaAtivo = false;
				saida = true;
			}
		}
		
		return saida;
	}
	
	
	public boolean getHerbivoro(){
		return herbivoro;
	}
	
	public void diminuiTempoVida(int tempo){
		tempoVida = ((tempoVida - tempo) < 0 ? 0 : tempoVida - tempo);
	}
	
	public int getTempoVida(){
		return tempoVida;
	}
	
	public void desativa(){
		estaAtivo = false;
	}
	
	public boolean estaAtivo(){
		return estaAtivo;
	}
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	
	public void draw(Graphics g){	//todo animal sabe como se desenhar
	if (estaAtivo) g.drawImage(img, x-iw/2, y-ih/2, null);
	}
	
	public String toString(){
		return nome;
	}
}
