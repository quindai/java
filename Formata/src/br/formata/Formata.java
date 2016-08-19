package br.formata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Formata {

	private BufferedReader leitor;
	ArrayList<String> cid = new ArrayList<String>();
	ArrayList<Long> estado = new ArrayList<Long>();
	File arq = new File("art.txt");
	
	public Formata() {
		int i = 0;
		try {
			leitor = new BufferedReader(new FileReader("cidades.txt"));
			PrintWriter pw = new PrintWriter(arq);
			while(leitor.ready()){
				String linha = leitor.readLine();
//				System.out.println(linha);
				int num = Integer.parseInt(linha.substring(39, 41));
				switch (num){
				case 11:
					num = 13; break;
				case 13:
					num = 11; break;
				case 16:
					num = 17; break;
				case 17:
					num = 18; break;
				case 18:
					num = 16; break;
				case 21:
					num = 22; break;
				case 22:
					num = 23; break;
				case 23:
					num = 21; break;
				case 25:
					num = 26; break;
				case 26:
					num = 25; break;
				}
				String aux = "("+num+ ","+linha.substring(48, linha.length()-2)+"),";
				
				pw.println(aux);
//				arranja(linha);
//				if (i++ == 2) break;
			}
			
			pw.close();
			
//			for(Long c:estado)
//				System.out.println(c);
			
			for(String c:cid)
				System.out.println(c);
			
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado");
		} catch (IOException e) {
			System.err.println("Erro ao ler arquivo");
		}
		
	}
	
	private void arranja(String l){
//		estado.add(Long.parseLong(l.substring(39, 41)));
//		cid.add(l.substring(48, l.length()-2));
		
		int num = Integer.parseInt(l.substring(39, 41));
		String aux = "("+num+ ","+l.substring(48, l.length()-2)+"),";
		
		System.out.println(aux);
	}
	public static void main(String[] args) {
		new Formata();
	}
}
