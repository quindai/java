package com.randy.ufal.swing;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel_DadosAluno extends JPanel{
	private JLabel lblMatricula, lblNome, lblCurso, lblCreditoCObrigatorio, lblCreditoCEletivo, lblCursoMatriculado, lblDisciplinasCursadas;
	private JTextField txtMatricula, txtNome, txtCreditoCObrigatorio, txtCreditoCEletivo, txtCursoMatriculado, txtDisciplinasCursadas;
	private JComboBox cboCurso;
	JPanel panelRotulos, panelInformacao;
	public Panel_DadosAluno(){
		setLayout( new GridBagLayout() ); //implementar GridLayout
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//setSize(400,300);
		initComponentes();
	}
	
	private void initComponentes(){
		//panelRotulos = new JPanel();
		//panelInformacao = new JPanel();
		
		lblMatricula = new JLabel("Matricula:");
		lblNome = new JLabel("Nome:");
		lblCurso = new JLabel("Curso:");
		cboCurso = new JComboBox(new String[]{"","Engenharia de Computacao", "Doutorado - Informática",
								"Portugues - Ingles","Outro"});
		
		txtMatricula = new JTextField(15);
		txtNome = new JTextField(30);
		
		//c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipadx = 0;
		//c.weightx = 0;
		//c.anchor = GridBagConstraints.WEST;
		addComponente(lblMatricula, 0, 0, GridBagConstraints.EAST);
		/*c.gridx = 0;
		c.gridy = 0;
		//c.gridwidth = 10;
		add(lblMatricula, c);*/
		addComponente(txtMatricula, 0, 1, GridBagConstraints.WEST);
		/*c.gridx = 1;
		c.gridy = 0;
		//c.gridwidth = 40;
		c.anchor = GridBagConstraints.WEST;
		add(txtMatricula, c);*/
		
		addComponente(lblNome, 1, 0, GridBagConstraints.EAST);
		/*c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.EAST;
		add(lblNome, c);*/
		
		addComponente(txtNome, 1, 1, GridBagConstraints.WEST);
		/*c.gridx = 1;
		c.gridy = 1;
		add(txtNome, c);*/
		
		addComponente(lblCurso, 2, 0, GridBagConstraints.EAST);
		/*c.gridx = 0;
		c.gridy = 2;
		add(lblCurso, c);*/
		
		addComponente(cboCurso, 2, 1, GridBagConstraints.WEST);
		/*c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		add(cboCurso, c);*/
		/*add(txtMatricula);
		add(lblNome);
		add(txtNome);
		*/
		/*panelInformacao.setLayout(new BoxLayout(panelInformacao, BoxLayout.Y_AXIS));
		panelRotulos.setLayout(new BoxLayout(panelRotulos, BoxLayout.Y_AXIS));
		
		panelRotulos.add(lblMatricula);
		panelRotulos.add(lblNome);
		
		panelInformacao.add(txtMatricula);		
		panelInformacao.add(txtNome);*/
		
		/*add( panelRotulos);
		add( panelInformacao);*/
	}
	
	private void addComponente(Component obj,int linha, int coluna, int posicao ){
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = coluna;
		c.gridy = linha;
		c.anchor = posicao;
		add(obj, c);
	}
}
