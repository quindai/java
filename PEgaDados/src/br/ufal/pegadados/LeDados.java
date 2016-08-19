package br.ufal.pegadados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class LeDados {

	int conta = 0;
	public LeDados() {
		try {
			FileReader f = new FileReader("entrada.txt");
			BufferedReader ler = new BufferedReader(f);
			FileWriter gravar = new FileWriter("coletados.txt");
			PrintWriter gravador = new PrintWriter(gravar);
			
			String linha = ler.readLine();
			
			while(linha != null){
//				System.out.println(linha);
//				System.out.printf("%s", verP(linha));
				gravador.print(verP(linha));
				linha = ler.readLine();
			}
			
			f.close();
			gravar.close();
			JOptionPane.showMessageDialog(null, "Dados encontrados: "+ conta+
										"\nVer arquivo 'coletados.txt'.", "PgDados",
										JOptionPane.INFORMATION_MESSAGE);
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo 'entrada.txt' não encontrado.\n"+e.getMessage(), "PgDados", JOptionPane.ERROR_MESSAGE); 
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "PgDados", JOptionPane.ERROR_MESSAGE);
		} catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Linha em branco no arquivo.\n" +e.getMessage(), "PgDados", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	//verificaPrecipitacao
	public String verP(String l){
		String retorno = "";
//		if (l.contains("BR") || l.contains("FG") || l.contains("HZ"))
//			retorno += l +"\n";
		String reto = l.substring(20,l.length());
//		System.out.println("RET:"+ reto);
		
//		String[] ret = l.split(" ");
//		//BR FG HZ
		
//		if(ret[5].equals("BR"))
//			retorno += l;
		if (reto.contains("BR") || reto.contains("FG") || reto.contains("HZ")){
			retorno += l +System.lineSeparator();
			conta++;
		}
		
		return retorno;
	}
	public static void main(String[] args) {
		new LeDados();
		System.out.println("Dados gravados com sucesso!");
	}
}
