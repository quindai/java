/**
 * @data:: 30 de Maio de 2010
 * 
 */
package com.randy.pkgCirco;

/**
 * @author randy
 *
 */
//requisitos obrigatorios numa pessoa
public abstract class Pessoa
{
	//encapsulando os meus dados
	private String nome;
	private int idade;
	private String sexo;
	private String BI;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade)	{
		this.idade = idade;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setBI(String BI) {
		this.BI = BI;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getBI() {
		return BI;
	}
	
	public String toString()
	{
		return String.format("Nome:: %S\nIdade:: %d\nSexo:: %s\n", nome, idade, sexo);
	}
}
