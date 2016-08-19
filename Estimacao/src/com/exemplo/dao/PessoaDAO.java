package com.exemplo.dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exemplo.ConnectionFactory;
import com.exemplo.Pessoa;

public class PessoaDAO {

	private Connection conn;
	public PessoaDAO(){
		conn = new ConnectionFactory().getConnection();
	}
	
	public void teste(){
		List<Pessoa> list = null;
		
//		list = conn.createStatement(resultSetType, resultSetConcurrency);
//		
//		session.getTransaction().commit();
//		
//		for(Pessoa p: list){
//			System.out.println(p.getNome());
//		}
//		
//		session.close();
	}
	
	public static void main(String[] args) {
		new PessoaDAO().teste();
	}
}
