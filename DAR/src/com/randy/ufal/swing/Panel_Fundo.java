package com.randy.ufal.swing;
//
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_Fundo extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox cboGrad_pos = new JComboBox(new String[] {"Graduação", "Pós-Graduação"});
	JLabel lblfundo ;
	
	public Panel_Fundo(){
		
		setFundo( "fundo.png" );
//		add(cboGrad_pos);
//		cboGrad_pos.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(getValue());
//			}
//		});
	}
	
	public void setFundo(String img){
		//if ( !img.isEmpty() ){
			lblfundo = new JLabel(new ImageIcon( "imagens//"+ img ));
			add(lblfundo);
			//add(new JLabel(new ImageIcon("imagens//"+ img)));
			//add
		//}
		
	}
	public int getValue(){
		return cboGrad_pos.getSelectedIndex();
	}
	
	
}
