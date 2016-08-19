package ufal2016.arq.bo;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Interpreter {
	static int PC;
	static int AC;
	static int instr;
	static int instr_type;
	static int data_loc;
	static int data;
	static boolean run_bit = true;
	private HashMap<String, ?> register;
	//ArrayList<String> stack = new ArrayList<String>(); //pilha
	private static Stack<Integer> stack = new Stack<Integer>();
	
	public static void interpret(int memoria[], int starting_address){
		PC = starting_address;
		while(run_bit){
			instr = memoria[PC];
			PC = PC + 1;
			instr_type = get_instr_type(instr);
		}
	}
	private static int get_instr_type(int addr){
		return 0;
	}
	
	private static int find_data(int instr, int type){
		return 0;
	}
	
	private static void execute(int type, int data){
		
	}
	
	private void load(String val){
		//como implementar: LOAD var valor
	//	stack.add(val);
	}
	
	private static void push(int val){
		stack.push(val);
	}
	
	private static Integer pop(){
		return stack.pop();
	}
	
	private static int add(){
		int a = stack.pop(), b = stack.pop();
		return a+b;
	}
	
	private static int sub(){
		int a = stack.pop(), b = stack.pop();
		return a-b;
	}
	
	private static int mult(){
		int a = stack.pop(), b = stack.pop();
		return a*b;
	}
	
	private static int div(){
		int a = stack.pop(), b = stack.pop();
		return a/b;
	}
	
	public static void restartStack(){
		stack.clear();
	}
	
	public static String showStack(){
		return stack.toString().replaceAll("\\[^*\\]", "").replaceAll(",", System.lineSeparator());
	}
	
	public static int translate(String line) throws NotFoundException,EmptyStackException{
		int status = 0;
		//int caret = 0;//gambiarra, para pegar a posicao do cursor
		//if (!code[0].isEmpty()){
			//int currentLine = 1;
			//for(String line: code){
				String statement = line.trim().split("[ \t]")[0];
				switch(statement.toUpperCase()){
					case "ADD": System.out.println(); status = add(); break;
					case "DIV": System.out.println(); status = div(); break;
					case "HALT": System.out.println("COMANDO HALT"); break; //pausa a execução
					case "LOAD": System.out.println("COMANDO LOAD"); break;
					case "POP": System.out.println("COMANDO POP"); status=pop();break; //tira da pilha
					case "PUSH": System.out.println("COMANDO PUSH"); push(Integer.parseInt( line.split("[ \t]")[1]) );
								status = 0;
					break;
					case "MULT": System.out.println("COMANDO MULT"); status = mult(); break;
					case "SUB": System.out.println("COMANDO SUB"); status = sub(); break; //subtrae
					case "PRINT": System.out.println("COMANDO PRINT"); break;
					default: {
						//status = currentLine;
						throw new NotFoundException(String.format("Comando não encontrado: %s", 
															statement));
					}
				}
			//	currentLine++;
			//	caret += line.length()+1;
			//}
		//}
		return status;
	}
	
}