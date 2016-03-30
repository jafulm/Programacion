package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MyDataAcces {

	private String _usuario = "root";
	private String _pwd = "";
	private static String _bd = "eclipse";
	static String _url = "jdbc:mysql://localhost/" + _bd;
	private Connection conn = null;

	public MyDataAcces() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(_url, _usuario,
					_pwd);
			if (conn != null) {
				System.out.println("Conexión a base de datos " + _url
						+ " . . . Ok");
			}
		} catch (SQLException ex) {
			System.out
					.println("Hubo un problema al intentar conecarse a la base de datos"
							+ _url);
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

	public static void main(String[] args) {
		MyDataAcces conexion = new MyDataAcces();
		ResultSet resultado;
		String nombres;

		resultado = conexion.getQuery("SELECT nombre FROM eclipse.datos");
		
		

		try {
			if (resultado.next()) { // verifica si esta vacio, pero desplaza el puntero al siguiente elemento
				
				resultado.beforeFirst();//esta regresa el puntero al inicio para no perder el 1er dato
				
				while (resultado.next()) {
					nombres = resultado.getString("nombre");
					System.out.println("nombre: " + nombres);
				}
				resultado.close();
			}else{
				JOptionPane.showMessageDialog(null, "El resultado esta vacio");
			}

		        

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
