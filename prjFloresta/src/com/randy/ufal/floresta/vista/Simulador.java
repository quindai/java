package com.randy.ufal.floresta.vista;

import com.randy.ufal.floresta.Source.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class Simulador extends JPanel implements Runnable{

	public PanelFactos fact = new PanelFactos();
	private static final int LARGURA = 500;
	private static final int ALTURA = 300;
	private boolean pausado = true;
	private Thread animacao;
	private ArrayList<Animal> animais;
	private ArrayList<Vegetacao> vegetacao;
	private static  int NUM_ANIMAIS = 0;
	private static  int NUM_VEGETACAO = 0;
	private static boolean inicioSimulador = true;
	
	public Simulador() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		setFocusable(true);
		requestFocus();
		
		reiniciarEstadoDaAnimacao();
			
//		for(int i = 0; i < NUM_ANIMAIS; i++)
//			lobos.add(new Lobo(this.getPreferredSize()));
//		timer = new Timer(400, this);
	//	timer.start();	//inicia temporizador
//		setBackground(Color.black);
//		setPreferredSize(new Dimension(RWIDTH, RHEIGHT));
	}
	
	//avisa que agora temos a interface num container parente
	public void addNotify(){
		super.addNotify();
		start();
	}
	
//	private synchronized void adicionarAnimal(ArrayList<Animal> aux){
//		for(Animal a: aux){
//			animais.add(a);
//			NUM_ANIMAIS++;
//		}
	//	animais.add(ob);
//		implementar de novo
//	}
	
	public void reiniciarEstadoDaAnimacao(){
		animais = new ArrayList<Animal>(NUM_ANIMAIS);
		vegetacao = new ArrayList<Vegetacao>(NUM_VEGETACAO);
		//lobos = new ArrayList<Animal>(NUM_ANIMAIS);
		
		for(int i = 0; i < NUM_VEGETACAO; i++)
			if(i < (NUM_VEGETACAO/4))
				vegetacao.add(new Arbusto(this.getPreferredSize()));
			else if(i < (NUM_VEGETACAO/3))
				vegetacao.add(new Cactus(this.getPreferredSize()));
			else if(i < (NUM_VEGETACAO/2))
				vegetacao.add(new Cogumelo(this.getPreferredSize()));
			else
				vegetacao.add(new Laranjeira(this.getPreferredSize()));
		
		for(int i = 0; i < NUM_ANIMAIS; i++)
			if(i < (NUM_ANIMAIS/4)) 
				animais.add(new Coelho(this.getPreferredSize()));
			else if(i <= (NUM_ANIMAIS/3))
				animais.add(new Lobo(this.getPreferredSize()));
			else if(i < (NUM_ANIMAIS/2))
				animais.add(new Tartaruga(this.getPreferredSize()));
			else
				animais.add(new Rato(this.getPreferredSize()));
	}
	
	public void setNumAnimais(int num){
		NUM_ANIMAIS = (num >= 0 ? num : NUM_ANIMAIS);
	}
	
	public void setNumVegetacao(int num){
		NUM_VEGETACAO = (num >=0 ? num : NUM_VEGETACAO);
	}
	
	public void setPausado(){			//coloca a animacao em pause
		pausado = !pausado;
	}
	
	public boolean getPausadoState(){	//verifica se a animacao esta pausada
		return pausado;
	}
	
	public boolean getInicioSimulador(){
		return inicioSimulador;
	}
	
	public void setInicioSimuladorFalso(){
		inicioSimulador = false;
	}
	public void start()
    {
       if (animacao == null){
    	   animacao = new Thread(this);
    	   animacao.start();
       }
    }
//	public void paint(Graphics g){
//		super.paintComponent(g);
//		g.setColor(Color.GREEN);
//		g.fillOval(10, 10, 8, 4);	//	Vegetacao
//		g.drawString("-> Vegetacao", 30, 15);
//		g.setColor(Color.CYAN);
//		g.fillOval(10, 20, 4, 4);
//		g.drawString("-> Especies", 30, 25);
//		
//		//move(g);
//		//setPreferredSize(new Dimension(RWIDTH, RHEIGHT));
//		//repaint();
//	}
//	public void move(Graphics g){
//		Random r = new Random();
//		curX = RWIDTH / 2 + j ;
//		curY = RHEIGHT / 2 - 1 % Math.abs(r.nextInt());
//		j += 10;
//		g.fillOval(j, j, 4, 4);
//	}
	//utilizado pelo gerenciador de layout para determinar o tamanho preferido
	public Dimension getPreferredSize(){
		return new Dimension(LARGURA, ALTURA);
	}
	
	//utilizado pelo gerenciador de layout para determinar o tamanho minimo
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
	
	//Onde a magia acontece
	public void run(){
		while(true){
			actualizaCiclo();
			repaint();
			try{
				Thread.sleep(20);
			}catch(InterruptedException e){
				
			}
		}
	}
	
	private synchronized void actualizaCiclo(){
//		ArrayList<Animal> aux = new ArrayList<Animal>();
		if(!pausado){
			for(Animal a: animais){
				a.mover();
				if(a.estaAtivo() && a.getTempoVida() == 0){
					a.desativa();
					fact.setJTextArea(a + " FALECEU de causas naturais.\n"+
										a.getX() +" , "+ a.getY() +"\n");
				}
			}
			
			//	gerencia a cadeia alimentar
			for(Animal a: animais){
				if(a.estaAtivo())
				{
					if (a.getHerbivoro()) {
						for(Vegetacao v: vegetacao)
							if(a.comer(v)){
								fact.setJTextArea(a +" comeu "+ v + "\n"+ v.getX() + 
													" , "+ v.getY()+ "\n");
								a.diminuiTempoVida(v.getToxicidade());		//animal morre depois de uma certa quantidade de comida
							}
					}else
						for(Animal b: animais)
							if(b.estaAtivo())
								if(b.getHerbivoro())
									if(a.comer(b)){
										fact.setJTextArea(a +" comeu "+ b + "\n"+ b.getX() + 
															" , "+ b.getY()+ "\n");
										a.diminuiTempoVida(1);	
								}
				}
			}
				
//				//reproduzir
//				for(Animal b : animais)
//				if (a.equals(b) && a.reproduzir(b)){
//					//animais.add(new Coelho(this.getPreferredSize()));
//					if (a.equals("Rato")){
//						fact.setJTextArea(a +" reproduziu.\n");
//					}
					//adicionarAnimal(new Coelho(this.getPreferredSize()));  erro
					//NUM_ANIMAIS++;
				//}
			
		//	adicionarAnimal(aux);
			//	gerencia a reproducao de especies
//			for(Animal a: animais){
//				for(Animal b: animais)
//					if (a.equals(b) && a.reproduzir(b)){
//						animais.add(new Coelho(this.getPreferredSize()));
//						NUM_ANIMAIS++;
//					}
			//}
		
//		for(Animal c: lobos)
//			c.mover();
		}
	}
	
	protected synchronized void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(inicioSimulador)
		{
			g.setColor(Color.GREEN);
			g.drawString("-> Bem Vindo <-", 170, 15);
			g.drawString("programador>>", 130, 160);
			g.drawString("UFAL >> 2011 >> Eng. Computação.", 130, 190);
			g.setColor(Color.CYAN);			
			g.drawString("1.Para iniciar defina \"População Inicial\".", 130, 30);
			g.drawString("2.Defina \"Vegetação Inicial\".", 130, 45);
			g.drawString("3.Clique em \"Configuração\".", 130, 60);
			g.drawString("(A animação estará no seu estado inicial.)", 130, 75);
			g.drawString("4.Clique em \"Iniciar\".", 130, 90);
			g.drawString("(Ao terminar a aplicação um ficheiro \"log.txt\"", 130, 120);
			g.drawString("será gravado no mesmo directório que a aplicação.)", 130, 135);
			g.drawString("(PROJECTO DE P. III)", 180, 215);
			g.setColor(Color.YELLOW);
			g.drawString("Randy Ambrosio Quindai Joao", 170, 175);
			g.setColor(Color.RED);
			g.drawString("A ser implementado na proxima versão->", 130, 105);
			
		}
		else{
			for(Vegetacao i: vegetacao)
				i.draw(g);
		
			for(Animal i : animais)
				i.draw(g);
		}
//		for(Animal c : lobos)
//			c.draw(g);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}

	class PanelFactos extends JPanel{	// Panel Apresentacao dos factos
		private JTextArea jtxtFatos_Area;
		public PanelFactos()
		{
			setLayout(new BorderLayout());
			jtxtFatos_Area  = new JTextArea(10, 40);
			jtxtFatos_Area.setLineWrap(true);
			jtxtFatos_Area.setEditable(false);
			setBorder(new EtchedBorder(EtchedBorder.RAISED));
			add(new JScrollPane(jtxtFatos_Area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
											JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
			//jtxtFatos_Area.append("Iniciado com sucesso \n");
			
		}
		
		public void setJTextArea(String texto){
			jtxtFatos_Area.append(texto);
		}
	}
}
