package teste;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JTableJanela extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField search;
	public JTableJanela() {
		m_tb = new JTable(new JTableModel(colunaNomes, dados));
		search = new JTextField();
		setLayout(new BorderLayout());
		
		add(search, BorderLayout.NORTH);
		add(new JScrollPane( m_tb ));
		search.setToolTipText("Insira o texto aqui...");
		m_tb.setFillsViewportHeight(false);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableJanela().setVisible(true);
	}
	
	//Variaveis de Instancia
	JTable m_tb;
	Date data = Calendar.getInstance().getTime();
	DateFormat f_data = DateFormat.getDateInstance(DateFormat.SHORT);
	String [] colunaNomes = {"Id","Nome","Idade","Ano Nascimento","Custo de Vida","Solteiro"};
	Object[][] dados = {{1,"Randy Arca",30,f_data.format(data) ,380, true},
			{2,"Randy Arca",30,f_data.format(data),380, true},
			{3,"Randy Arca",30,f_data.format(data),380, false},
			{4,"Randy Arca",30,f_data.format(data),380.33, true},
			{5,"Randy Arca",3,f_data.format(data),380.33, false},
			{6,"Randy Arca",30,f_data.format(data),380.33, false},
			{7,"Randy Arca",30,f_data.format(data),380.33, true},
			{8,"Randy Arca",30,f_data.format(data),380.33, true},
			{9,"Randy Arca",30,f_data.format(data),380.33, false},
			{10,"Randy Arca",30,f_data.format(data),380.33, false},
			{11,"Randy Arca",30,f_data.format(data),380.33, true},
			{12,"Randy Arca",30,f_data.format(data),380.33, false}};
	Object[] tipoDados = {Integer.class,String.class};
	
}
