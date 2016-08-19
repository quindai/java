package teste;

public class Coelho extends Animal{

	public Coelho(){
		
	}
	
	public int soma(){
		return 0;
	}
	
	public int soma(int a, int b){
		return a+b;
	}
	public int soma(int a){
		return a+2;
	}
	
	@Override
	protected String fala(){
		return "auauau";
	}
	public static void main(String[] args) {
		System.out.println( new Coelho().fala() );
	}
}


abstract class Animal{
	protected String fala(){
		return "Sou animal";
	}
}
