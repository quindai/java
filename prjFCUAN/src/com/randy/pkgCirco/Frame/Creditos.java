package com.randy.pkgCirco.Frame;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Creditos extends JDialog{
	JPanel p_backgroung, p_Center, p_South;
	
	Creditos()
	{
		initComponentes();
		setLocationRelativeTo(null);
	}
	public Creditos(JFrame f)
	{
		super(f);
		initComponentes();
		setLocationRelativeTo(f);
	}
	private void initComponentes()
	{
		p_backgroung = new JPanel(new BorderLayout());
		p_Center = new JPanel();
		p_South = new JPanel();
		p_Center.add(new JLabel("Direitos de copia Randy Ambrosio \n Todos os Direitos reservados "));
		p_backgroung.add(BorderLayout.CENTER, p_Center);
		
		getContentPane().add(p_backgroung);
		setModal(true);
		pack();
	}
	public static void main(String[] args)
	{
		new Creditos().setVisible(true);
	}
}
