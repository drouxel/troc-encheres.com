package fr.eni.trocEncheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * classe permettant de se connecter √† la base de donn√©es mySql
 * @author damien
 *
 */
public class ConnecteurBDD {
	private static DataSource dataSource;
	
	static {
		Context context;
		try {
			context = new InitialContext();
			ConnecteurBDD.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("impossible de se connecter ‡† la base de donnÈes");
		}
	}
	/**
	 * classe permettant d'obtenir un pool de connexion pour intervenir sur la base de donn√©es
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return  ConnecteurBDD.dataSource.getConnection();
	}
}

