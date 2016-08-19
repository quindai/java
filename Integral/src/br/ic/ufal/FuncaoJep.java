package br.ic.ufal;

import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;

public class FuncaoJep {

	public FuncaoJep(){
		Jep jep = new Jep();
		try {
			jep.parse("e^y");
//			jep.addVariable("x", Math.PI);
			jep.addVariable("y");
			jep.setAllowUndeclared(true);
						
			Object r = jep.evaluate();
			
//			System.out.println(r);
		} catch (JepException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FuncaoJep();
	}
}
