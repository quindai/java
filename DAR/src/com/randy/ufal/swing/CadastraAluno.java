package com.randy.ufal.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CadastraAluno extends JDialog{
	
	private static CadastraAluno instance;
	private JPanel panel_principal = new JPanel();
	private Panel_ControlesCima panel_ControlesCima;
	private Panel_DadosAluno panel_DadosAluno;
	
	private CadastraAluno(JFrame f){
		super(f, true);
		setTitle("Cadastrar Aluno");
		initComponentes();
		getContentPane().add( panel_principal );
		pack();
		setLocationRelativeTo(f);
		//setResizable(false);
	}
	
	public static CadastraAluno getInstance(JFrame f){
		if ( instance == null )
			instance = new CadastraAluno( f );
		return instance;
	}
	
	public static CadastraAluno getInstance() throws Exception{
		return instance;
	}
	
	private void initComponentes(){
		panel_ControlesCima = new Panel_ControlesCima();
		panel_DadosAluno = new Panel_DadosAluno();
		panel_principal.setLayout(new BoxLayout(panel_principal, BoxLayout.Y_AXIS));
		panel_ControlesCima.setText_btnOperacao1("Salvar");
		panel_ControlesCima.setText_btnOperacao2("Cancelar");
		panel_ControlesCima.setMnemonic_btnAsc('S', 'C', ' ', ' ', ' ');
		panel_principal.add( new Panel_Banner() );
		panel_principal.add( panel_ControlesCima );
		panel_principal.add(panel_DadosAluno);
		
		try {
			panel_ControlesCima.setAction_btnOperacao(new Action_salvar(), 1);
			panel_ControlesCima.setAction_btnOperacao(new Action_cancelar(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void action_salvar(){
		JOptionPane.showMessageDialog(this, "Salvar Dados!");
	}
	
	public void action_cancelar(){
		String args[] = {"Sim", "Nao"};
		if ( JOptionPane.showOptionDialog(this, "Cancelar operacao?",
				this.getTitle(), JOptionPane.YES_NO_OPTION, 3, null, args, args[1]) == 0 ) { 
			this.dispose();
		}
	}
}

	class Action_salvar implements ActionListener {
		public void actionPerformed(ActionEvent ev){	
				try{
					CadastraAluno.getInstance().action_salvar();
				}catch(Exception e){
					System.err.println("Objeto nao instanciado");
				}
			}
		}
	
	
	class Action_cancelar implements ActionListener {
		public void actionPerformed(ActionEvent e){
			try{
				CadastraAluno.getInstance().action_cancelar();
			}catch(Exception ev){
				System.err.println("Objeto nao instanciado");
			}
		}
	}