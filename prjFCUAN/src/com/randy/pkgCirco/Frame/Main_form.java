/**
 * 
 */
package com.randy.pkgCirco.Frame;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * @author randy
 * @param backPaper - painel de fundo		midlePanel - painel central
 */
@SuppressWarnings("serial")
public class Main_form extends JFrame
{
	JPanel painel_backPaper, painel_toolbar;
	JToolBar tb_main;
	
	public Main_form() 
	{
		super("Circo Manager");
		
		Init();
		setVisible(true);
		
		getContentPane().add(painel_backPaper);
		setSize(1000, 700);
		
		setAlwaysOnTop(true);//a frente de todos activado
		
		//setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new Main_FormListener());//adiciona ouvinte do Formulario
		
		setJMenuBar(new Menu());
		repaint();
		setAlwaysOnTop(false);//a frente de todos desactivado
		
		setLocationRelativeTo(null);
		//setExtendedState(MAXIMIZED_BOTH);//maximizar janela
		
	}
	
	private void Init(){
		
		painel_toolbar = new JPanel();
		painel_toolbar.setLayout(new BoxLayout(painel_toolbar, BoxLayout.X_AXIS));
		Barra_Ferramenta b = new Barra_Ferramenta();
		//b.setBackground(Color.HSBtoRGB(2, 2, 2));
		painel_toolbar.add(b);
		painel_toolbar.add( new Barra_Ferramenta(true) );
		//painel_toolbar.setBackground(Color.LIGHT_GRAY);
		
		painel_backPaper = new JPanel(new BorderLayout());
		painel_backPaper.setBackground(Color.white);
		painel_backPaper.add(BorderLayout.CENTER, new JLabel(new ImageIcon("imagens/clown.gif")));
		painel_backPaper.add(BorderLayout.NORTH, painel_toolbar);
		//backPaper.add(BorderLayout.NORTH, new Barra_Ferramenta(true));
	}
	
	//----------.. A C A O   D O S   E V E N T O S ..-----------------
	private void sair()	{
		String[] oa = {" Sim ", " Nao "};
		 if ( JOptionPane.showOptionDialog(Main_form.this, "Fechar o sistema?", "Circo Manager",
				 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, oa, oa[0]) == 0)
		 																// 0 == YES_OPTION
			 System.exit(0); //fecha o sistema
	}
	
	//-------.. T R A T A D O R   D E   E V E N T O S  D E   M A I N   F O R M ..----------------------
	class Main_FormListener extends WindowAdapter{
		
		public void windowClosing(WindowEvent evento) {
			sair();
		}
	}// fim da classe interna Main_FormListener
	
	//-------.. B A R R A   DE   F E R R A M E N T A S..-------------------
	class Barra_Ferramenta extends JToolBar
	{
		JButton btn_Novo, btn_Abrir;
		public Barra_Ferramenta()
		{
			btn_Novo = new JButton("",new ImageIcon("Imagens/novo.gif"));
			btn_Novo.setToolTipText("Novo Arquivo (Ctrl+N)");
			btn_Abrir = new JButton("", new ImageIcon("Imagens/abrir.gif"));
			btn_Abrir.setToolTipText("Abrir Arquivo");
			//setFloatable(false);
			//setRollover(true);
			add(btn_Novo);
			addSeparator(new Dimension(3,1));
			add(btn_Abrir);
			addSeparator(new Dimension(5,1));
			//		instanciando um objecto interno da classe interna Menu
			btn_Abrir.addActionListener(new Menu().new SobreListener()); //fascinante
			btn_Novo.addActionListener(new Menu().new Novo_ArquivoListener());
		}
		public Barra_Ferramenta(boolean t)
		{
			//setFloatable(false);
			JButton btn_N = new JButton("", new ImageIcon("Imagens//novo.gif"));
			add(btn_N);
		}
	}
	//-------.. M   E   N   U ..-------------------
	class Menu extends JMenuBar//classe interna a Main_form
	{
	    //JMenuBar menu;
	    JMenu mnuFile, mnuEdit, mnuHelp, mnuF_Add;
	    JMenuItem mnuF_Sair, mnuF_Open, mnuF_Search, mnuH_Credito, mnuH_Sobre,
	            mnuAdd_Artista, mnuAdd_Arte, mnuAdd_File,
	            mnuE_Artista, mnuE_Arte;

	    public Menu()
	    {
	      //  menu = new JMenuBar();
	        mnuFile = new JMenu("Ficheiro");
	        mnuF_Add = new JMenu("Novo");
	        mnuAdd_File = new JMenuItem("Arquivo");
	        mnuAdd_Artista = new JMenuItem("Artista");
	        mnuAdd_Arte = new JMenuItem("Arte");
	        mnuF_Open = new JMenuItem("Abrir Arquivo");
	        mnuF_Search = new JMenuItem("Pesquisar");
	        mnuF_Sair = new JMenuItem("Sair");
	        mnuEdit = new JMenu("Editar");
	        mnuE_Artista = new JMenuItem("Artista");
	        mnuE_Arte = new JMenuItem("Arte");
	        mnuHelp = new JMenu("Ajuda");
	        mnuH_Credito = new JMenuItem("Creditos");
	        mnuH_Sobre = new JMenuItem("Sobre a Aplicacao");

	        //.....definindo o menu FILE
	        mnuF_Sair.addActionListener( new SairListener() );
	        mnuF_Open.addActionListener( new Abre_ArquivoListener() );
	        mnuF_Search.addActionListener( new PesquisaListener() );
	        mnuFile.add(mnuF_Add);
	        mnuFile.add(mnuF_Open);
	        mnuFile.add(mnuF_Search);
	        mnuFile.addSeparator();
	        mnuFile.add(mnuF_Sair);

	        //.....definindo menu NOVO
	        mnuAdd_File.addActionListener(new Novo_ArquivoListener());
	        mnuAdd_Artista.addActionListener(new Novo_ArtistaListener());
	        mnuAdd_Arte.addActionListener(new Novo_ArteListener());
	        mnuF_Add.add(mnuAdd_File);
	        mnuF_Add.addSeparator();
	        mnuF_Add.add(mnuAdd_Artista);
	        mnuF_Add.add(mnuAdd_Arte);
 	        
  	       //.....definindo o menu EDITAR
	        mnuE_Artista.addActionListener(new Edit_ArtistaListener());
	        mnuE_Arte.addActionListener(new Edit_ArteListener());
	        mnuEdit.add(mnuE_Artista);
	        mnuEdit.add(mnuE_Arte);
	        
	        //.....definindo o menu AJUDA
	        mnuH_Credito.addActionListener(new CreditoListener());
	        mnuH_Sobre.addActionListener(new SobreListener());
	        mnuHelp.add(mnuH_Credito);
	        mnuHelp.add(mnuH_Sobre);

	        //.....definindo os ATALHOS do teclado
	        mnuFile.setMnemonic('F');
	        mnuAdd_File.setMnemonic('Q');
	        mnuAdd_Artista.setMnemonic('R');
	        mnuAdd_Arte.setMnemonic('T');
	        mnuF_Open.setMnemonic('A');
	        mnuF_Search.setMnemonic('P');
	        mnuF_Sair.setMnemonic('S');
	        mnuEdit.setMnemonic('E');
	        mnuE_Artista.setMnemonic('R');
	        mnuE_Arte.setMnemonic('T');
	        mnuHelp.setMnemonic('A');
	        mnuH_Credito.setMnemonic('C');
	        mnuH_Sobre.setMnemonic('S');
	        mnuAdd_File.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_MASK));
	        mnuH_Credito.setAccelerator(KeyStroke.getKeyStroke('C',KeyEvent.ALT_MASK));
	        mnuF_Open.setAccelerator(KeyStroke.getKeyStroke('A', KeyEvent.CTRL_MASK));
	        mnuF_Search.setAccelerator(KeyStroke.getKeyStroke('P', KeyEvent.CTRL_MASK));
	        
	        /*fazer F1 funcionar
	         * 
	         * mnuH_Sobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.KEY_PRESSED,KeyEvent.VK_F1));
	         */
	        
	        //....adicionando  os menus a barra de menus
	        add(mnuFile);
	        add(mnuEdit);
	        add(mnuHelp);
	        
	    } //fim do construtor Menu
	   
	    class SobreListener implements ActionListener//classe interna ao Menu
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		JOptionPane.showMessageDialog(Main_form.this,"Clicou em ajuda");
	    	}
	    }//fim de SobreListener

	    class CreditoListener implements ActionListener//classe interna ao Menu
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		JOptionPane.showMessageDialog(Main_form.this,"Clicou em ajuda");
	    	}
	    }//fim de CreditoListener

	    class PesquisaListener implements ActionListener//classe interna ao Menu
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		//JOptionPane.showMessageDialog(Main_form.this,"Clicou em pesquisar");
	    		new Padrao(Main_form.this);
	    		//new Padrao();
	    	}
	    }//fim de PesquisaListener
	    
	    class Abre_ArquivoListener implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		JFileChooser jc;
	    		jc = new JFileChooser();
	    		
	    		//jc.setFileFilter("*|.txt");
	    		
	    		jc.showOpenDialog(Main_form.this);
	    		JOptionPane.showMessageDialog(Main_form.this,"Clicou em Abrir Arquivo");
	    	}
	    }//fim de Abre_ArquivoListener
	    
	    class Novo_ArquivoListener implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		JOptionPane.showMessageDialog(Main_form.this,"Clicou em Novo Arquivo");
	    	}
	    }//fim de Novo_ArquivoListener
	    
	    class Novo_ArtistaListener implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		JOptionPane.showMessageDialog(Main_form.this,"Clicou em Novo Artista");
	    	}
	    }//fim de Novo_ArtistaListener
	    
	    
	    class Novo_ArteListener implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		//JOptionPane.showMessageDialog(Main_form.this,"Clicou em Novo Arte");
	    		new Arte(Main_form.this).setVisible(true);
	    	}
	    }//fim de Novo_ArteListener

	    class Edit_ArtistaListener implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		JOptionPane.showMessageDialog(Main_form.this,"Clicou em Editar Artista");
	    	}
	    }//fim de Edit_ArtistaListener
	    
	    class Edit_ArteListener implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		JOptionPane.showMessageDialog(Main_form.this,"Clicou em Editar Arte");
	    	}
	    }//fim de Edit_ArteListener
	    
	    class SairListener implements ActionListener//classe interna ao Menu
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		 /*if( JOptionPane.showConfirmDialog(Main_form.this, "Fechar o sistema?", "Circo Manager",
	    				 		JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) */
	 
	    		 sair();
	    										
	    	}
	    }//fim de SairListener
	    
	}//fim da classe interna Menu
	
}//fim da classe Main_form