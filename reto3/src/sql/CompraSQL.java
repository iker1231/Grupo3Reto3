package sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cine;
import modelo.Cliente;
import modelo.Compra;
import modelo.Entrada;
import modelo.Pelicula;
import vista.SelectPelicula;
import sql.SelectPeliSql;

public class CompraSQL {
	public static int sesionId = 0;
	
	public int compra1() {
		Connection connection = null;
		Compra compra = new Compra();
		ResultSet rs = null;
		Statement statement = null;
		SelectPeliSql pelis = new SelectPeliSql();
		//creo que habría que hacerlo con los geter y seter.
		int cineId = 0;
		Cine cine = new Cine();
		Cliente cliente = new Cliente();
		cineId = cine.getIdCine();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");
			statement = connection.createStatement();

			String sql = "Insert into compra (FechaCompra, PrecioTotal, DNI ) value ('" + Date.valueOf(LocalDate.now()) + "', 0, '" + cliente.getDni()  +"' )";
			statement.executeUpdate(sql);
			sql = "select IdCompra from compra where DNI = '" + cliente.getDni() + "'";
			ResultSet rs1 = statement.executeQuery(sql);
			rs1.next();
			int all = rs1.getInt("IdCompra");
			compra.setIdCompra(all);
			compra.setDni(cliente.getDni());
			cineId = all;


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
		return cineId;
	}
	public int entrada() {
		Connection connection = null;
		Compra compra = new Compra();
		ResultSet rs = null;
		Statement statement = null;
		SelectPeliSql pelis = new SelectPeliSql();
		//creo que habría que hacerlo con los geter y seter.
		int cineId = 0;
		Cine cine = new Cine();
		Entrada entrada = new Entrada();
		cineId = cine.getIdCine();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");
			statement = connection.createStatement();

			String sql = "Insert into entrada (FechaEmision, IdCompra, IdSesion) values ('" + entrada.getFechaEmision()  +"', '" + compra.getIdCompra()  +"', '" + entrada.getIdSesion()  +"')";
			statement.executeUpdate(sql);

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
		return cineId;
	}
	public int compra2() {
		Connection connection = null;
		Compra compra = new Compra();
		ResultSet rs = null;
		Statement statement = null;
		SelectPeliSql pelis = new SelectPeliSql();
		//creo que habría que hacerlo con los geter y seter.
		int cineId = 0;
		Cine cine = new Cine();
		Cliente cliente = new Cliente();
		cineId = cine.getIdCine();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");
			statement = connection.createStatement();

			String sql = "Update compra set PrecioTotal = '" +compra.getPrecioTotal() + "', Descuento = '"+ compra.getDescuento()+"' where IdCompra = '" + compra.getIdCompra() +"'";
			statement.executeUpdate(sql);
			sql = "select IdCompra from compra where DNI = '" + cliente.getDni() + "'";
			ResultSet rs1 = statement.executeQuery(sql);
			rs1.next();
			int all = rs1.getInt("IdCompra");
			compra.setIdCompra(all);
			compra.setDni(cliente.getDni());
			cineId = all;


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
		return cineId;
	}

}