package com.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

//	FIXME caminho do banco de dados fixo
	private String url = "jdbc:mysql://localhost:3036/mydb";
	public Connection getConnection(){
		try {
//			Class.forName("com.mysql.jdbc.Driver"); deprecated
//			Pega a conexao do banco de dados
			return DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
//			Passa a responsabilidade
			throw new RuntimeException(e);
		}
	}
}
