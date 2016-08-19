package com.randy.pkgCirco.Frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class Padrao extends JDialog
{
	private JPanel p_comp, p_background, p_botao;
	private JTextField txtNome, txtBI, txtCedula, txtSalario;
	private JComboBox cboSexo, cboArte;
	private JLabel lblNome, lblSexo, lblArte, lblSalario, lblBI, lblCedula;
	private JButton btnSalvar, btnCancelar, btnNovoArte;
	private String[] arte = {"Palhaço","Malabarista","Trapezista","Outro"};
	
	public Padrao(JFrame f)
	{
		super(f);//nao menos importante + necessario
		initPainel();
		add(p_background);
		
		//pack();
		setModal(true);
		setSize(680, 300);
		setLocationRelativeTo(f);
		setVisible(true);
	}
	
	public Padrao()
	{
		initPainel();
		add(p_background);
		
		pack();
		//setSize(680, 300);
		setModal(true);
		setVisible(true);
	}
	
	private void  initPainel()
	{
		p_background = new JPanel();
		p_background.setLayout(new BorderLayout());
		p_background.add(BorderLayout.NORTH, new JLabel(new ImageIcon("imagens/banner1.jpg")));
		
		p_comp = new JPanel();
		p_comp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		//p_comp.setBackground(Color.lightGray);
		p_comp.setLayout(null);
		
		p_botao = new JPanel();
		
		initComponentes();//inicia componentes - jlabel, jtextfield e outros
		
		p_botao.add(btnSalvar);
		p_botao.add(btnCancelar);
		
		p_comp.add(lblNome);
		p_comp.add(txtNome);
		p_comp.add(lblSexo);
		p_comp.add(cboSexo);
		p_comp.add(lblBI);
		p_comp.add(txtBI);
		p_comp.add(lblCedula);
		p_comp.add(txtCedula);
		p_comp.add(lblSalario);
		p_comp.add(txtSalario);
		p_comp.add(lblArte);
		p_comp.add(cboArte);
		p_comp.add(btnNovoArte);
		p_comp.getPreferredSize();
		p_background.add(BorderLayout.CENTER, p_comp);
		p_background.add(BorderLayout.SOUTH, p_botao);
	
	}
	private void initComponentes()
	{
		String[] sexo = {"Masculino","Feminino"};
		btnSalvar = new JButton("Salvar");
		btnCancelar = new JButton("Cancelar");
		btnNovoArte = new JButton("Novo");
		
		lblNome = new JLabel("Insira o nome:");
		lblArte = new JLabel("Insira a arte:");
		lblSalario = new JLabel("Insira o salario:");
		lblSexo = new JLabel("Sexo:");
		lblCedula = new JLabel("Cedula N�:");
		lblBI = new JLabel("BI N�:");
		lblSalario = new JLabel("Salario:");
		lblArte = new JLabel("Arte:");
		cboSexo = new JComboBox(sexo);
		cboArte = new JComboBox(arte);
		txtNome = new JTextField();
		txtBI = new JTextField();
		txtCedula = new JTextField();
		txtSalario = new JTextField();
		
		//posicionando os componentes
		lblNome.setBounds(55, 25, 100, 10);
		txtNome.setBounds(140, 23, 400, 20);
		lblSexo.setBounds(97, 50, 50, 10);
		cboSexo.setBounds(140, 47, 100, 20);
		lblBI.setBounds(260, 50, 50, 10);
		txtBI.setBounds(300, 47, 240, 20);
		lblCedula.setBounds(70, 75, 60, 10);
		txtCedula.setBounds(140, 73, 100, 20);
		lblSalario.setBounds(250, 75, 50, 10);
		txtSalario.setBounds(300, 73, 70, 20);
		lblArte.setBounds(385, 75, 50, 10);
		cboArte.setBounds(420, 73, 120, 20);
		btnNovoArte.setBounds(540, 73, 20, 20);
		// padrao
		
		//adicionando ToolTips
		btnNovoArte.setToolTipText("Editar Arte");
		
		//adicionando eventos
		btnNovoArte.addActionListener(new NovoArteListener());
		
	}
	class NovoArteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new Arte(Padrao.this).setVisible(true);
		}
	}
	public static void main(String[] args)
	{
		new Padrao();
	}
}