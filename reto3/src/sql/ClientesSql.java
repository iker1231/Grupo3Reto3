package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.Cliente;

public class ClientesSql {

	public void insertarCliente(Cliente cliente) {

		Connection connection = null;

		Statement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

			statement = connection.createStatement();

			String sql = "insert into cliente (DNI, Nombre, Apellido, Sexo, Contraseña, Usuario) VALUES ('"
					+ cliente.getDni() + " ','" + cliente.getNombreCli() + "','" + cliente.getApellidoCli() + "','"
					+ cliente.getGeneroCli() + "','" + cliente.getContrasena() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo");
		} finally {
			try {
				if (statement != null)
					statement.close();
				JOptionPane.showMessageDialog(null, "Cliente creado");
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
	}

	public boolean validarLogin(String usuario, String contraseña) {

		boolean ret = false;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

			statement = connection.createStatement();

			String sql = "select * from cliente where usuario = '" + usuario + "' and contraseña = '" + contraseña
					+ "'";
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				JOptionPane.showMessageDialog(null, "Usuario y contraseña correctos");
				ret = true;
			} else {
				JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
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
