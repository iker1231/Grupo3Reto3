package sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cine;
import modelo.Cliente;
import modelo.Pelicula;
import vista.SelectPelicula;
import sql.SelectPeliSql;

public class NoAsientosSQL {
	public static int sesionId = 0;
	
	public float precio() {
		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;
		SelectPeliSql pelis = new SelectPeliSql();
		//creo que habría que hacerlo con los geter y seter.
		int cineId = 0;
		Cine cine = new Cine();
		cineId = cine.getIdCine();
		float precio = 0;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");
			statement = connection.createStatement();

			String sql = "SELECT Precio FROM sesion WHERE IdSesion = '" + sesionId  +"'";
			rs = statement.executeQuery(sql);
			rs.next();
			Float all = rs.getFloat("Precio");
			precio = all;


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
		return precio;
	}


}