package com.randy.ufal.swing;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel_Banner extends JPanel {
	private static final long serialVersionUID = 1L;

	public Panel_Banner() {
		add( new JLabel( new ImageIcon("imagens/banner.png")) );
	}
}
