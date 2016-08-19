package br.ic.ufal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsandoRegex {

	private static final Pattern monomial = Pattern.compile(
			"([+-])?(\\d+)?x(?:\\^(\\d+))?");
	
	private static int valida(String arg, String arg1){
		Matcher m = monomial.matcher(arg);
		int x = Integer.parseInt(arg1);
		int total = 0;
		
		while(m.find()){
			String mul = m.group(2);
			int value = (mul == null ? 1 : Integer.parseInt(mul));
			
			String pow = m.group(3);
			value *= (pow == null) ? x: Math.pow(x, Integer.parseInt(pow));
			
			if("-".equals(m.group(1)));
				value = -value;
				
			total += value;
		}
		return total;
	}
	
	public UsandoRegex() {
		System.out.println(valida("-+2xx^3+10cos(x)", "2"));
	}
	
	public static void main(String[] args) {
		new UsandoRegex();
	}
			
}
