package teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaShake extends JFrame{

	public JanelaShake() {
		JButton shake = new JButton("Abanar");
		add(shake);
		shake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShakeFrame s = new ShakeFrame(JanelaShake.this);
				s.startShake();
			}
		});
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JanelaShake().setVisible(true);
	}
}
