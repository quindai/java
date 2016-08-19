package com.randy.pkgCirco.Frame;

import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
//import javax.swing.plaf.ProgressBarUI;

@SuppressWarnings("serial")
public class Splash extends JWindow
{

	/**
	 * @param --JANELA SPLASH
	 */
	JProgressBar pb;
	
	public Splash()
	{
		Init();
		getContentPane().add( 						//adiciona ah janela
							  BorderLayout.CENTER,	//no centro 
							  new JLabel(			//um JLabel contendo uma nova imagem
									  	  new ImageIcon("imagens/splash_circo.jpg")));
		
		getContentPane().add(BorderLayout.SOUTH, pb);
		
		//empacota os objectos no form
		pack();	
		setLocationRelativeTo(null);
		setVisible(true);
		//muda o cursor
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		
		Start();    //invoca o metodo Start	
		dispose(); //descarrega a janela da memoria
	}


	public static void main(String[] args) {
		new Splash();
	}//fim de main

	
	private void Init()	{
		new LookNFeel(); //define a aparencia do sistema actual
		pb = new JProgressBar();
		pb.setMaximum(100);
		pb.setStringPainted(true); //aceita texto na JProgressBar
	}//fim de Init
	
	private void Start(){
		for( int i = 0; i <= 100; i++ ){
			pb.setValue(i);
			pb.setString( "Inicializando "+ i + "% aguarde..." );
			try
			{
				if( i == 90 ){
					new Main_form();
					setAlwaysOnTop(true);
					Thread.sleep(300);
				}
				Thread.sleep(40);
			}catch(InterruptedException e){e.printStackTrace();}
		}
	}//fim de Start

}//fim da Classe
