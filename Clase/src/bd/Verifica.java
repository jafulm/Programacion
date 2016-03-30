package bd;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Verifica {

	public static void main(String[] args) {
		Conector conexion = new Conector();
		ResultSet resultado;
		String nombres;

		resultado = conexion.getQuery("select Nombre From usuarios");
		//conexion.setQuery("insert into datos.datos (Nombre,Apellidop,ApellidoM) values('joseles','antioca','Carrasco')");
		try {
			while (resultado.next()) {
				nombres = resultado.getString("nombre");
				System.out.println("Nombre: " + nombres);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}