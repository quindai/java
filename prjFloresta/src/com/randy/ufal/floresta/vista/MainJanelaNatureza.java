package com.randy.ufal.floresta.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainJanelaNatureza extends JFrame{

	// definir boolean para verificar se a animacao esta a rodar
	// para entao fechar ou nao o programa
	
	private JPanel backPanel, buttonPanel;
	//private JTextArea jtxtFatos_Area;
	private ControladorPopulacional slPopInicial, slVegetacao;
	private Simulador simulador;
	//private Simulador.PanelFactos factPanel;	//classe interna de Simulador
	private JButton btnSetup, btnGo, btnCancel;
	
	public MainJanelaNatureza() {
		this("Floresta do Maiombe");
	}

	public MainJanelaNatureza(String title){
		super(title);
		setPlataformaLookAndFeel();		//Pega a aparencia do sistema
		initComponents();
		addWindowListener(new MainWindowListener());   //atribui evento a janela
		getContentPane().add(backPanel);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
	private void setPlataformaLookAndFeel(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao carregar o tema!");
		}
	}
	
	private void initComponents(){
		backPanel 	= new JPanel();
		buttonPanel = new JPanel();
		//factPanel = new Simulador().new PanelFactos();	// Panel Apresentacao dos factos
		simulador 	= new Simulador();
		btnSetup 	= new JButton("Configuração");
		btnGo 		= new JButton("Iniciar");
		btnCancel 	= new JButton("Cancelar");
		
		slPopInicial = new ControladorPopulacional("População Inicial");
		slVegetacao = new ControladorPopulacional("Vegetação Inicial");
	
		// Painel de botoes
		btnSetup.setMnemonic('O');
		btnGo.setMnemonic('I');
		btnCancel.setMnemonic('C');
		btnCancel.addActionListener(new CancelListener());
		btnGo.addActionListener(new GoListener());
		btnSetup.addActionListener(new SetupListener());
		
		buttonPanel.add( btnSetup );
		buttonPanel.add( btnGo );
		buttonPanel.add( btnCancel );
		
		backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
		backPanel.add(simulador);
		backPanel.add(simulador.fact);
		backPanel.add(slPopInicial);
		backPanel.add(slVegetacao);
		backPanel.add(buttonPanel);
	}
	
	private void controlaAnimacao(){
		simulador.setPausado();
		if( btnGo.getText().equals("Pausar") ){
			btnGo.setText("Iniciar");
			btnGo.setMnemonic('I');
		}
		else{
			btnGo.setText("Pausar");
			btnGo.setMnemonic('P');
		}
	}
	private void sair(){
		String[] op = {"Sim", "Não"};
		if(!simulador.getPausadoState()){
			controlaAnimacao();
		}
		if (JOptionPane.showOptionDialog(MainJanelaNatureza.this, "Fechar Aplicação?",
				MainJanelaNatureza.this.getTitle(), JOptionPane.YES_NO_OPTION, 3, 
				null, op, op[1]) == 0)
		{
			//System.out.print(jtxtFatos_Area.getText()); //implementar impressao de log.txt
			System.exit(0);
		}
		
	}
	
	class MainWindowListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			sair();		//	IMPLEMENTAR - chamar apenas quando animacao em execucao
		}
	}
	
	class CancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			sair();		//	IMPLEMENTAR - chamar apenas quando animacao em execucao
		}
	}
	
	class GoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			controlaAnimacao();
		}
	}
	
	class SetupListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (slPopInicial.getValue() > 0 || slVegetacao.getValue() > 0){
				if(!simulador.getInicioSimulador()){	//se nao estiver no inicio
					if(!simulador.getPausadoState())	//se a animacao estiver parada
						controlaAnimacao();
			
				}else
					simulador.setInicioSimuladorFalso();
			
				simulador.setNumAnimais(slPopInicial.getValue());
				simulador.setNumVegetacao(slVegetacao.getValue());
				simulador.reiniciarEstadoDaAnimacao();
			}
		}
	}

	public static void main(String[] args) {
		new MainJanelaNatureza();

	}

}
