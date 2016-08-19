package br.ic.ufal;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;
import com.singularsys.jep.ParseException;

public class FunctionJep extends Jep{
	
	private String f;
	public FunctionJep(String f, String vars, double values) throws JepException{
		parse(f);
		addVariable(vars, values);
	}
	
	public FunctionJep(String f) throws EvaluationException, JepException{
		parse(f);
		this.f = f;
//		if (vars.length != values.length) 
//			throw new Exception("O numero de variaveis nao corresponde ao numero de valores.");
//		for(int i=0; i < vars.length; i++){
		
//			addVariable(v, 0.0);
//		}
	}
	
	public double value(double x, double y) throws ParseException,JepException{
		addVariable("x", x);
		addVariable("y", y);
		
		return (double) evaluate();
	}
	
	public double value(String var, double value) throws JepException{
		addVariable(var, value);
		return evaluateD();
	}
}
