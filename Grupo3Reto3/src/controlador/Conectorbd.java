package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectorbd {

	private Connection conexion;
//sss
	public Conectorbd() {
		iniciarConexion();
	}


	public void iniciarConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Conectado!");

	}

	public void cerrarConexion() {
		System.out.println("Cerrando...");
		try {
			if (!conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Cerrada!");
	}
}
