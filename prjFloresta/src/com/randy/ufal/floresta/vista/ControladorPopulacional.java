package com.randy.ufal.floresta.vista;
/**
 * @Autoria 	::
 * 				Randy Ambrosio Quindai Joao
 * @Data		::
 * 				Maceió, 26 Agosto 2011, Sexta - 22:53
 * 				UFAL, Alagoas, Brasil
 * @Descricao 	::
 * 				contem os componentes JSlider e JButton que controlam
 * 				   o fluxo populacional
 * 
 * Codigo aberto, a maioria das ideias são originalmente minhas, se for usar por favor mencione a fonte 
 */
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ControladorPopulacional extends JPanel {

	private JSlider popSlider;   //Slider Populacional
	private JTextField txtpop;
	
	public ControladorPopulacional () {
		this("");
	}
	
	public ControladorPopulacional(String title){
		super(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createEtchedBorder(), 
					title));
		initComponents();
		add(BorderLayout.CENTER, popSlider);
		add(BorderLayout.EAST, txtpop);
	}
	
	private void initComponents(){
		txtpop = new JTextField(4);
		txtpop.setText("0");
		txtpop.setEditable(false);
		//					Constante, Valor Inicial, Valor Maximo, Posicao Inicial
		popSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 1);
		popSlider.setMajorTickSpacing(10);								//Espacamento das medidas visiveis
		popSlider.setFont(new Font("Calibri", Font.PLAIN, 8));
		popSlider.setPaintLabels(true);									//Imprime o valor dos espacamentos
		//slPopInicial.setPaintTicks(true); 							//mostra as marcas de medida do controle deslizante
		popSlider.addChangeListener(new SliderListener());
	}

	public int getValue(){
		return Integer.parseInt(txtpop.getText());
	}

	//		CLASSES INTERNAS / EVENTOS DOS OBJECTOS
	class SliderListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			txtpop.setText(Integer.toString(popSlider.getValue()));
		}
	}
}// Fim da classe ControladorPopulacional
