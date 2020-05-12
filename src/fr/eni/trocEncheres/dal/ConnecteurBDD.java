package fr.eni.trocEncheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnecteurBDD {
	private static DataSource dataSource;
	
	static {
		Context context;
		try {
			context = new InitialContext();
			ConnecteurBDD.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("impossible de se connecter à la base de données");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return  ConnecteurBDD.dataSource.getConnection();
	}
}

