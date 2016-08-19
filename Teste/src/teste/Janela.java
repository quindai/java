package teste;

import javax.swing.JFrame;

public class Janela extends JFrame {

	public Janela() {
		setTitle("Ola Dario");
		setSize(700, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Janela().setVisible(true);
	}
}
