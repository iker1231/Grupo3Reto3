package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.Cliente;

public class ClientesSql {

	public int insertarCliente(Cliente cliente) {
		Connection connection = null;
		int a = 0;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

			statement = connection.createStatement();

			String sql = "insert into cliente (DNI, NombreCli, ApellidoCli, Genero, Contraseña) VALUES ('"
					+ cliente.getDni() + " ','" + cliente.getNombreCli() + "','" + cliente.getApellidoCli() + "','"
					+ cliente.getGeneroCli() + "','" + cliente.getContrasena() + "')";

			statement.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Usuario creado");
			a = 1;
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo 1");
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return a;
	}

	public boolean validarLogin(String Dni, String Contrasena) {

		boolean ret = false;

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

			statement = connection.createStatement();

			String sql = "select * from cliente where DNI = '" + Dni + "' and Contraseña = '" + Contrasena
					+ "'";
			rs = statement.executeQuery(sql);

			if (rs.next()) {
				ret = true;
				Cliente cliente = new Cliente();
				cliente.setDni(Dni);
			} else {
				JOptionPane.showMessageDialog(null, "DNI y/o contraseña incorrectos");
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ret;
	}

}
