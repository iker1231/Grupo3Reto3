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
import modelo.Sesion;
import vista.SelectPelicula;

public class SelectPeliSql {
	private int sesionId;
	private int cineId;
	
	public String[] nombrePelicula() {
		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;
		String[] pelis = { "", "", "", "", "", "", "", "" };

		int i = 0;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

			statement = connection.createStatement();

			String sql = "select IdPelicula, Titulo from pelicula";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String all = rs.getString("Titulo");
				pelis[i] = all;
				i = i + 1;

			}

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
		return pelis;
	}

	public String[] idiomPeli(int NumP) {
		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;
		String[] idiom = { "", "", "", "" };
		int i = 0;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");
			statement = connection.createStatement();

			darpeli(NumP);
			NumP++;
			String sql1 = "select Idioma from sesion where IdPelicula ='" + NumP + "'";
			rs = statement.executeQuery(sql1);

			while ((i <= 4) && (rs.next())) {
				String all = rs.getString("Idioma");
				idiom[i] = all;
				i = i + 1;
			}

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo 2");
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
		return idiom;
	}

	public String[] darpeli(int NumP) {
		Connection connection = null;
		ResultSet rs2 = null;
		Statement statement = null;
		String[] idiom = { "", "", "" };

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

			statement = connection.createStatement();
			NumP++;
			String sql2 = "select * from pelicula where IdPelicula ='" + NumP + "'";
			rs2 = statement.executeQuery(sql2);
			Pelicula p = new Pelicula();
			rs2.next();
			int a = rs2.getInt("IdPelicula");
			p.setIdPelicula(a);
			p.setTitulo(rs2.getString("Titulo"));
			p.setDuracion(rs2.getString("Duracion"));
			p.setGeneroPe(rs2.getString("GeneroPe"));

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo4");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo 2");
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
		return idiom;
	}

	public String sesion(int NumP, Date date, String idioma) {
		 NoAsientosSQL asientos = new NoAsientosSQL();
		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;
		String a = null;
		String b = null;

		int i = 0;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");
			statement = connection.createStatement();
			String sql = "select Horario, IdSesion from sesion where IdPelicula ='" + NumP + "' and FechaSesion='"
					+ date + "'";
			rs = statement.executeQuery(sql);
			rs.next();
			String all = rs.getString("Horario");
			sesionId = rs.getInt("IdSesion");
			asientos.sesionId = NumP;
			a = all;
			String sql1 = "SELECT NombreCine, ci.IdCine, se.IdSesion from cine ci JOIN sala sa on sa.IdCine=ci.IdCine join sesion se on se.IdSala=sa.IdSala WHERE se.IdSesion ='"
					+ sesionId + "'";
			rs = statement.executeQuery(sql1);
			rs.next();
			String all1 = rs.getString("NombreCine");
			int all2 = rs.getInt("IdCine");
			b = all1;
			cineId = all2;
			Cine cine = new Cine();
			cine.setIdCine(cineId);

			while ((rs.next())) {

				i = i + 1;
			}

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo 5");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo 6");
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
		return a + " | " + b;
	}
}