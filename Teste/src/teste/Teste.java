package teste;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Teste extends JFrame{

	private JLabel lblMostra = new JLabel(""+ Math.pow(5, 2));
	
	public Teste() {
		super("Ola Dayane");
		setSize(300,300);
		setLocationRelativeTo(null);
		add(lblMostra);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
			new Teste().setVisible(true);
	}
}
