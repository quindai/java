package com.randy.ufal.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_ControlesCima extends JPanel{
	private static final long serialVersionUID = 1L;
		//		Matricula		Ajuda
		private JButton btnOperacao1, btnOperacao2;
		
		public Panel_ControlesCima(){
			setLayout(new FlowLayout());
			setBackground(Color.lightGray);
			initComponentes();
			/*btnOperacao1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DarMain.getInstance().action_novoAluno();
					//new CadastraAluno().setVisible(true);
				}
			});*/
			
			add(btnOperacao1);
			add(btnOperacao2);
		}
		
		private void initComponentes(){
			btnOperacao1 = new JButton("Nova Matricula");
			btnOperacao2 = new JButton("Ajuda");
			setMnemonic_btnAsc('N', 'A', ' ', ' ', ' ');
		}
		
		public void setText_btnOperacao1(String texto){
			btnOperacao1.setText( texto );
		}
		
		public void setText_btnOperacao2(String texto){
			btnOperacao2.setText( texto );
		}
		
		public void setMnemonic_btnAsc(char arg01, char arg02, char arg03, char arg04, char arg05){
			btnOperacao1.setMnemonic(arg01);
			btnOperacao2.setMnemonic(arg02);
		}
		
		public void setAction_btnOperacao(ActionListener acao, int num_botao) throws Exception{
			//num_botao = 1,2 ... num de botoes
			switch ( num_botao ){
				case 1:
					btnOperacao1.addActionListener( acao );
				break;
				case 2:
					btnOperacao2.addActionListener( acao );
					break;
				default: 
					throw new Exception(); 
			}
		}
		
		/*public void setAction_btnOperacao2(ActionListener acao){
			btnOperacao2.addActionListener( acao );
		}*/
		
		public void setVisible_btnAsc(Boolean arg01, Boolean arg02, Boolean arg03, Boolean arg04){
			btnOperacao1.setVisible( arg01 );
			btnOperacao2.setVisible( arg02 );
		}
}