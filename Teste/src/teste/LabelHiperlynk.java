package teste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LabelHiperlynk extends JFrame{
	JLabel label;
	public LabelHiperlynk() {
		setSize(300,300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		label = new JLabel("Teste Hiperlynk");
		add(label, BorderLayout.NORTH);
		setLocationRelativeTo(null);
		setResizable(false);
		
		label.addMouseListener(new Comportamento(this));
	}
	
	class Comportamento extends MouseAdapter{
		JFrame f;
		public Comportamento(JFrame f) {
			// TODO Auto-generated constructor stub
			this.f = f;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, "acao");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			acao(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			acao(false);
		}
		
	}
	protected void acao(boolean v) {
		label.setForeground(v?Color.blue:Color.black);
	}

	public static void main(String[] args) {
		new LabelHiperlynk().setVisible(true);
	}
}
