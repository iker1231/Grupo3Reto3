package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectorbd {

	private Connection conexion;

	public Conectorbd() {
		iniciarConexion();
	}

	private void iniciarConexion() {
		System.out.println("Conectando...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Falta meter datos
			conexion = DriverManager.getConnection("", "root", "");
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
