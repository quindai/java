package teste;

public class Palindromo {

	public static void main(String[] args) {
		String dados = "aba";
		String aux = "";
		for (int i = dados.length() - 1; i >= 0; i--)
			aux += dados.charAt(i);
		if (dados.equals(aux))
			System.out.println("Palindromo");
		else
			System.out.println("Nao");
	}
}
