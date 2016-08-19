package pkgDesenho;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame{
	JPanel panel = new JPanel();
	public Janela() {
		AreaDesenho areaDesenho = new AreaDesenho();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(areaDesenho.botoes);
		panel.add(areaDesenho);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Janela();
	}
}
