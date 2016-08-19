package ufal2016.arq.view;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EmptyStackException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import ufal2016.arq.bo.Interpreter;
import ufal2016.arq.bo.NotFoundException;

/**
 * 
 * @author randy
 * This is the GUI class
 *
 *	inserir um objeto que terá a mesma saída que a consola
 */
public class Principal extends JFrame{
	private JPanel panel, pnButtons;
	private JTextArea txtCode, txtInterpretedCode, txtStack;
	private JButton btnStart, btnPause, btnStop;
	private int haltAux;
	TextLineNumber l;
	Interpreter interpretador;
	
	public Principal() {
		super("Interpretador - Arquitetura 2016");
		init();
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//--------------------------------------
		setVisible(true);
		txtCode.requestFocus();
	}
	
	private void init(){
		JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		btnStart = new JButton(new ActionStart("Iniciar", new ImageIcon("img/start.png"), "Interpretar código", new Integer(KeyEvent.VK_I)));
		btnPause = new JButton(new ActionPause("Continuar", new ImageIcon("img/continue.png"), "Continuar execuçãoo", new Integer(KeyEvent.VK_C)));
		btnStop = new JButton(new ActionStop("Parar", new ImageIcon("img/stop.png"), "Parar execução", new Integer(KeyEvent.VK_P)));
		panel = new JPanel(new BorderLayout());
		pnButtons = new JPanel();
		txtCode = new JTextArea(25,50);
		txtStack = new JTextArea(2,5);
		txtInterpretedCode = new JTextArea(4,5);
		
		btnPause.setEnabled(false);
		
		txtStack.setEditable(false);
		txtCode.setWrapStyleWord(true);
		txtInterpretedCode.setEditable(false);
		l = new TextLineNumber(txtCode);
		JScrollPane spTxtCode = new JScrollPane(txtCode, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spTxtCode.setRowHeaderView(l);
		sp.add(spTxtCode);
		sp.add(new JScrollPane(txtInterpretedCode, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,  
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		sp.setOneTouchExpandable(true);
		
		
		pnButtons.add(btnStart);
		pnButtons.add(btnPause);
		pnButtons.add(btnStop);
		
		panel.add(BorderLayout.NORTH, pnButtons);
		panel.add(BorderLayout.CENTER,sp);
		panel.add(BorderLayout.EAST, new JScrollPane( txtStack, 
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		getContentPane().add(panel);
	}
	
	private void writeErrorInterpretedCode(String str, int caret){
		//txtInterpretedCode.setText(str.split("encr12")[0]);
		txtInterpretedCode.append(str +" : Linha: "+ l.getTextLineNumber(caret));
		/**
		 * Coloca o cursor na linha com erro - gambiarra
		 */
		try {
			l.selectLine(caret);
		} catch (BadLocationException e1) { /* nothing to do*/	}
		
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Principal();
			}
		});
	} //fim do metodo main
	
	private int run(){
		
		return 0;
	}
	/**
	 * 
	 * @author Randy Quindai
	 *	Inicio do command Pattern
	 */
	abstract class MyActions extends AbstractAction{
		public MyActions(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon);
			putValue(SHORT_DESCRIPTION, desc);
			putValue(MNEMONIC_KEY, mnemonic);
		}
	}
	class ActionStart extends MyActions{
		public ActionStart(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon, desc, mnemonic);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int status=0;
		
			Interpreter.restartStack();
			txtInterpretedCode.setText("");
			int caret = 0;//gambiarra, para pegar a posicao do cursor
			
			String[] code = txtCode.getText().split(System.lineSeparator());
			if (!code[0].isEmpty())
				for(String line: code){
					try { //nota: status sempre terá o valor da resposta
						//refatorar esse código
						line = line.trim();
						if (line.split("[ \t]")[0].equalsIgnoreCase("print"))
							txtInterpretedCode.append(line.substring(line.split("[ \t]")[0].length()).trim());
						else if(line.trim().equalsIgnoreCase("ajuda")){
							File html = new File("doc/index.html");
							java.awt.Desktop.getDesktop().browse(html.toURI());
						}
						else if (line.trim().equalsIgnoreCase("halt")){
							haltAux = caret+5;
							l.selectLine(haltAux);
							txtInterpretedCode.append("HALT na linha "+ l.getTextLineNumber(caret)+"\n");
							btnPause.setEnabled(true);
							break;
						}
						else
							status = Interpreter.translate(line);
						
						//l.selectLine(0);
					} catch (NotFoundException e) {
						writeErrorInterpretedCode( e.getMessage(), caret);
						break;
						//e.printStackTrace();
					} catch (EmptyStackException ex){
						writeErrorInterpretedCode( "Pilha vazia: " + ex.toString(), caret);
						//txtInterpretedCode.append("Pilha vazia: "+ ex.toString()+"\n");
						break;
					} catch (NumberFormatException ef){
						writeErrorInterpretedCode( "Valor inválido: " + ef.toString(), caret);
						break;
					} catch (BadLocationException e) {/*nothing to do*/	break;} 
					 catch (IOException e) {
						 writeErrorInterpretedCode("Ocorreu um erro inesperado!\n"+e.toString()+"\n", caret);
					}
					
					if (status != 0){
						System.out.println(status);
						txtInterpretedCode.append(status+System.lineSeparator());
					}
					caret += line.length()+1;
				}
			//JOptionPane.showMessageDialog(null, "Iniciado");
			//btnStart.setEnabled(false);
			txtStack.setText(Interpreter.showStack());
			txtCode.requestFocusInWindow();
		}
	}//fim de ActionStart
	
	class ActionPause extends MyActions{
		public ActionPause(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon, desc, mnemonic);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setEnabled(false);
			String[] code = txtCode.getText().substring(haltAux).split(System.lineSeparator());
			System.out.println(code[0]);
			int caret = haltAux, status=0;
			if (!code[0].isEmpty())
				for(String line: code){
					try { //nota: status sempre será zero
						//TODO melhorar o split
						//TODO melhorar comando print
						//TODO inserir desvio condicional, if'else
						line = line.trim();
						if (line.split("[ \t]")[0].equalsIgnoreCase("print"))
							txtInterpretedCode.append(line.substring(line.split("[ \t]")[0].length()));
						else if (line.equalsIgnoreCase("halt")){
							haltAux = caret+5;
							l.selectLine(haltAux);
							txtInterpretedCode.append("HALT na linha "+ l.getTextLineNumber(caret)+"\n");
							setEnabled(true);
							break;
						}
						else
							status = Interpreter.translate(line);
						
						//l.selectLine(0);
					} catch (NotFoundException e) {
						writeErrorInterpretedCode( e.getMessage(), caret);
						break;
						//e.printStackTrace();
					} catch (EmptyStackException ex){
						writeErrorInterpretedCode( "Pilha vazia: " + ex.toString(), caret);
						//txtInterpretedCode.append("Pilha vazia: "+ ex.toString()+"\n");
						break;
					} catch (NumberFormatException ef){
						writeErrorInterpretedCode( "Valor inválido: " + ef.toString(), caret);
						break;
					} catch (BadLocationException e) {/*nothing to do*/	}
					
					if (status != 0){
						System.out.println(status);
						txtInterpretedCode.append(status+System.lineSeparator());
					}
					caret += line.length()+1;
				}
			//JOptionPane.showMessageDialog(null, "Iniciado");
			//btnStart.setEnabled(false);
			txtStack.setText(Interpreter.showStack());
			txtCode.requestFocusInWindow();
		}
	}//fim de ActionPause
	
	class ActionStop extends MyActions{
		public ActionStop(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon, desc, mnemonic);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			btnPause.setEnabled(false);
			try {
				l.selectLine(0);
				txtInterpretedCode.append("Fim de execução...");
			} catch (BadLocationException e) {/*nothing to do*/	}
		}
	}//fim de ActionStop
}