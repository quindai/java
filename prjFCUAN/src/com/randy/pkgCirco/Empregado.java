/**
 * o artista he caracterizado por um nome, numero de bilhete de identidade, numero de cedula profissional
 * arte e ordenado - subtraido 8% 12% e 30 AKz
 * arte-palhaço, malabarista, trapezista, ajudante, domador, acrobacia, monociclo, contorcionismo, equilibrismo,
 * ilusionismo
 * 
 * criar bd - introduzir artista - remover artista por numero de artista, calcular ordenado, calcular total ordenado
 */
package com.randy.pkgCirco;

/**
 * @author randy
 *
 */
public class Empregado extends Pessoa
{
	private double salario;//variavel de instancia
	String nome, bi, cedula;
	
	public Empregado(){//construtor sem argumentos
		
	}
	
	public Empregado(double salario){//construtor
		setSalario( salario );		//valida salario
	}
	
	public void setSalario(double salario){
		this.salario = ( salario < 0 ? 0 : salario );
	}
	
	public double getSalario(){//devolve salario
		
		return salario;
	}
}
