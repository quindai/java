/**
 * 
 */
package com.randy.pkgCirco.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 * @author randy
 *
 */
@SuppressWarnings("serial")
public class Arte extends JDialog{

	/**
	 * 
	 */
	JPanel p_search, p_background = new JPanel();
	JTextField txtArg;
	JButton btnSalvar;
	String[] s = {"Ola","Nada","fareo"};
	DefaultListModel md = new DefaultListModel();
	JList lstDados = new JList();
	
	public Arte(JFrame f)
	{
		super(f);
		init();
		setLocationRelativeTo(f);
	}
	public Arte(JDialog f)
	{
		super(f);
		init();
		setLocationRelativeTo(f);
		
	}
	private void init()
	{
		new LookNFeel();
		initComponentes();
		getContentPane().add(p_background);
		setModal(true);
		pack();
		
		//setVisible(true);
	}
	private void initComponentes()
	{
		p_background.setLayout(new BoxLayout(p_background, BoxLayout.Y_AXIS));
		p_search = new JPanel();
		p_search.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		txtArg = new JTextField(30);
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				md.addElement(txtArg.getText());
			}
		});
		
		md.addElement("Ola");
		lstDados.setModel(md);
		
		p_search.add(txtArg);
		p_search.add(btnSalvar);
		
		p_background.add(p_search);
		p_background.add(new JScrollPane( lstDados ));
	}
	public static void main(String[] args)
	{
		//new Arte();
	}

}
