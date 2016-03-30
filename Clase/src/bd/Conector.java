package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conector {
//aguaespecial01
	private String usuariodb = "root";
	private String contrasena = "";
	private static String basedatos = "clase";
	static String servidor = "jdbc:mysql://localhost/"+basedatos;
	private Connection conn = null;

	public Conector() {

		try {
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection) DriverManager.getConnection(servidor,usuariodb, contrasena);
			if (conn != null) {
				System.out.println("Conexi-n a base de datos " + servidor
						+ " . . . Ok");
			}
		} catch (SQLException ex) {
			System.out
					.println("Hubo un problema al intentar conecarse a la base de datos"
							+ servidor);
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
	}

	public ResultSet getQuery(String _query) {
		Statement state = null;
		ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(_query);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return resultado;
	}

	public void setQuery(String _query) {

		Statement state = null;

		try {
			state = (Statement) conn.createStatement();
			state.execute(_query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}