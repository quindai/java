package pkgDesenho;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AreaDesenho extends JPanel implements Runnable, ActionListener{

	public Botoes botoes = new Botoes();
	Shape shape = new Ellipse2D.Float();
	Paint paint = null;
	public AreaDesenho() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(500,300));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == botoes.btnApagar)
			JOptionPane.showMessageDialog(this, "Apagar");
		if  (e.getSource() == botoes.btnCirculo){
			 JOptionPane.showMessageDialog(this, "Circulo");
			 desenhaCirculo();
			}
		if (e.getSource() == botoes.btnQuadrado){
			JOptionPane.showMessageDialog(this, "Quadrado");
			desenhaQuadrado();
		}
	}
	
	private void apagar(){
		repaint();
	}
	private void desenhaCirculo(){
		shape =  new Ellipse2D.Float(100.0f, 100.0f, 100.0f, 100.0f);
		paint = null;
		repaint();
		
//		Graphics g = null;
//		Dimension size = getSize();
//	    // diameter
//	    int d = Math.min(size.width, size.height); 
//	    int x = (size.width - d)/2;
//	    int y = (size.height - d)/2;
//
//	    // draw circle (color already set to foreground)
//	    g.fillOval(x, y, d, d);
//	    g.setColor(Color.black);
//	    g.drawOval(x, y, d, d);
//	    paintComponent(g);
	}
	
	private void desenhaQuadrado(){
		shape = new Rectangle2D.Double(100,100,100,100);
//		Graphics g = getGraphics();
//		Graphics2D g2d = (Graphics2D)g;
		paint = new GradientPaint(0,0,Color.blue,175,175,Color.yellow);
		//g2d.fill(shape);
		repaint();
	}
	
	protected synchronized void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(paint);
		g2d.fill(shape);
		g2d.draw(shape);
	}

	class Botoes extends JPanel {
		JButton btnCirculo, btnQuadrado, btnApagar;
		public Botoes() {
			btnCirculo = new JButton("Circulo");
			btnQuadrado = new JButton("Quadrado");
			btnApagar = new JButton("Apagar");
			btnApagar.setMnemonic('A');
			btnCirculo.setMnemonic('C');
			btnQuadrado.setMnemonic('Q');
			btnApagar.addActionListener(AreaDesenho.this);
			btnCirculo.addActionListener(AreaDesenho.this);
			btnQuadrado.addActionListener(AreaDesenho.this);
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(btnCirculo);
			add(btnQuadrado);
			add(btnApagar);
		}
	}
}
