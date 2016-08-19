package teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datas extends javax.swing.JFrame{

	public Datas() {
		/*JFormattedTextField t = null;
		
			t = new JFormattedTextField(new DateFormatter());
		
		
		add(t);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);*/
		Calendar c = Calendar.getInstance();
		Date data = Calendar.getInstance().getTime();
		DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("Data brasileira: "+ f.format(data));
		
		f = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println("Data sem o dia descrito: "+f.format(data));
		
		f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("Data resumida: "+ f.format(data));
		
		f = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("Data resumida: "+ f.format(data));
		
		//convertendo data
		f = DateFormat.getDateInstance();
		//	Date data2 = f.parse("12/01/1995");
		SimpleDateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Data formatada: "+ df.format(data));
		
		try {
			System.out.println("Conversao: "+ df.parse("27/8/1998 10:32:23"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Datas();
	}
}
