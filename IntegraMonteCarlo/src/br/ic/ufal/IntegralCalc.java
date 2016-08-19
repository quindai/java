package br.ic.ufal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.singularsys.jep.JepException;

public class IntegralCalc extends JFrame{
	/**
	 * Classe Principal
	 */
	private static final long serialVersionUID = 1L;
	private static int N = 10000;
	JTextField txtexpression;
	JTextField txtXmin;
	JTextField txtXmax;
	JTextField txtYmin;
	JTextField txtYmax;
	JTextField txtN;
	
	public IntegralCalc(){
		super("IntegralCalc - Beta");
		setLayout(new BorderLayout());
		initComponents();
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initComponents(){
		JPanel panelUp = new JPanel();
		JPanel panelX = new JPanel();
		JPanel panelY = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelButtons = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		txtexpression = new JTextField(25);
		txtXmin = new JTextField(10);
		txtXmax = new JTextField(10);
		txtYmin = new JTextField(10);
		txtYmax = new JTextField(10);
		txtN = new JTextField(5);
		JButton btnCalc = new JButton("Calcular");
		JButton btnPlot = new JButton("Plot");
		panelUp.add(new JLabel("∫∫"));
		panelUp.add(txtexpression);
		panelUp.add(new JLabel("dydx"));
		
		panelX.add(new JLabel("x ="));
		panelX.add(txtXmin);
		panelX.add(new JLabel("ate x ="));
		panelX.add(txtXmax);
		
		panelY.add(new JLabel("y ="));
		panelY.add(txtYmin);
		panelY.add(new JLabel("ate y ="));
		panelY.add(txtYmax);
		
		panelCenter.add(panelX);
		panelCenter.add(panelY);
		
		btnCalc.setMnemonic('C');
		btnPlot.setMnemonic('P');
		btnCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calcIntegral();
			}
		});
		
		btnPlot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraMensagem("Por implementar, desculpe o transtorno.",2);
			}
		});
		
		panelButtons.add(btnCalc);
		panelButtons.add(btnPlot);
		panelButtons.add(txtN);
		
		add(panelUp, BorderLayout.NORTH);
		add(panelCenter,BorderLayout.CENTER);
		add(panelButtons, BorderLayout.SOUTH);
		
	}
	
	private void mostraMensagem(String msg, int icone){
		JOptionPane.showMessageDialog(this, msg, this.getTitle(),icone);
	}
	
	private void calcIntegral(){
		Integral calc = new Integral();
		
		try {
			FunctionJep f = new FunctionJep(txtexpression.getText());
			
//			if (txtYmax.getText().matches("\\d*")){
//			calc.monteCarlo(f, Double.parseDouble(txtXmin.getText()),
//					Double.parseDouble(txtXmax.getText()), 
//					Double.parseDouble(txtYmin.getText()), 
//					Double.parseDouble(txtYmax.getText()), N);
//			}else
			mostraMensagem(
			calc.monteCarlo(f, Double.parseDouble(txtXmin.getText()),
					Double.parseDouble(txtXmax.getText()), 
					Double.parseDouble(txtYmin.getText()), 
					txtYmax.getText(), Integer.parseInt(txtN.getText())), 1);
			
		} catch (NumberFormatException e) {
			mostraMensagem("Valor inesperado nos intervalos.\n"+e.getMessage(), 2);
		} catch (JepException e) {
			mostraMensagem("Erro na funcao.\n"+ e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar layout","Erro",3);
		}
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new IntegralCalc().setVisible(true);				
			}
		});
	}
}
