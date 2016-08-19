package com.randy.ufal.swing;
/**
 * @author randy
 * Janela Principal do sistema
 */

//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class DarMain extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static DarMain instance;
	protected JPanel panel_principal = new JPanel();
	protected Panel_ControlesCima panel_controlescima;
	protected Panel_Fundo panel_fundo;
	
	private DarMain(){
		super( "Diretoria de Admissao e Registro" );
		initComponentes();
		getContentPane().add( panel_principal );
		setResizable(false);
		pack();
		setLocationRelativeTo( null );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	public static void main(String[] args){
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                try{
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                }catch(Exception e){

                }
                  getInstance().setVisible( true );;
            }
        });
    }

	private void initComponentes(){
		panel_controlescima = new Panel_ControlesCima();
		panel_fundo = new Panel_Fundo();
		panel_principal.setLayout(new BoxLayout(panel_principal, BoxLayout.Y_AXIS));
		panel_principal.add( new Panel_Banner() );
		panel_principal.add( panel_controlescima );
		panel_principal.add( panel_fundo );
		
		try{
			panel_controlescima.setAction_btnOperacao( new Action_novoAluno() , 1);
			panel_controlescima.setAction_btnOperacao( new Action_Ajuda() , 2);
		}	catch(Exception e){
			System.err.println("Erro ao delegar Acao.\n\tPossiveis Causas:" +
					"\n\t Controle inexistente!\n\t Controle nao disponivel!.");
		}
		

	}
	
	public static synchronized  DarMain getInstance(){
        if (instance == null)
            instance = new DarMain();
		return instance;
	}	
	
	public void action_novoAluno(){
		CadastraAluno.getInstance( this ).setVisible( true );
	}
	
	public void action_ajuda(){
		JOptionPane.showMessageDialog(this, "Ajuda!");
	}
}

//		CLASSES INTERNAS
	class Action_novoAluno implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DarMain.getInstance().action_novoAluno();
		}
	}
	
	class Action_Ajuda implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DarMain.getInstance().action_ajuda();
		}
	}
//******************************************************************************
//class panel_banner extends JPanel{
//	private static final long serialVersionUID = 1L;
//
//	public panel_banner() {
//		add( new JLabel( new ImageIcon("imagens/banner.png")) );
//	}
//}
//******************************************************************************

