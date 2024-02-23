package sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
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
		String[] pelis = { " ", "", "", "", "", "", "", "", "" };

		int i = 1;

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

	public ArrayList<String> idiomPeli(int NumP) {
		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;
		ArrayList<String> idiom = new ArrayList<String>();
		idiom.add(" ");
		int i = 1;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");
			statement = connection.createStatement();

			darpeli(NumP);
			// NumP++;
			String sql1 = "select Idioma from sesion where IdPelicula ='" + NumP + "' group by Idioma";
			rs = statement.executeQuery(sql1);

			while ((rs.next())) {
				String all = rs.getString("Idioma");
				idiom.add(all);
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
		SelectPelicula select = new SelectPelicula(null);

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

			statement = connection.createStatement();
			NumP++;
			String sql2 = "select * from pelicula where IdPelicula ='" + NumP + "' ";
			rs2 = statement.executeQuery(sql2);
			Pelicula p = new Pelicula();
			rs2.next();
			int a = rs2.getInt("IdPelicula");
			p.setIdPelicula(a);
			p.setTitulo(rs2.getString("Titulo"));
			p.setDuracion(rs2.getString("Duracion"));
			p.setGeneroPe(rs2.getString("GeneroPe"));
			p.almacenar();

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

	public ArrayList<String> sesion(int NumP, Date date, String hora) {
		NoAsientosSQL asientos = new NoAsientosSQL();
		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;
		String all;
		Sesion sesion= new Sesion();
		Cine cine = new Cine();
		ArrayList<String> horarioCine = new ArrayList<String>();
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		ArrayList<String> c = new ArrayList<String>();
		int i = 0;
		

		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");
			statement = connection.createStatement();
			// NumP++;
			/*
			 * String sql = "select IdSesion from sesion where IdPelicula ='" + NumP +
			 * "' and FechaSesion='" + date + "'"; rs = statement.executeQuery(sql);
			 * 
			 * while ((i <= 3) && (rs.next())) { String all = rs.getString("Horario");
			 * sesionId = rs.getInt("IdSesion"); asientos.sesionId = NumP; a.add(all); i++;
			 * }
			 */
			String sql = "SELECT NombreCine, sa.NombreSala, ci.IdCine, se.IdSesion\r\n"
					+ "from cine ci \r\n"
					+ "JOIN sala sa on sa.IdCine=ci.IdCine join sesion se on se.IdSala=sa.IdSala \r\n"
					+ "WHERE se.IdPelicula = '" + NumP + "' and se.FechaSesion = '"+date+"' and se.Horario = '"+ hora+"'";
			rs = statement.executeQuery(sql);

			while ((i <= 3) && (rs.next())) {
				all = rs.getString("NombreSala");
				a.add(all);
				all = rs.getString("NombreCine");
				cine.setNombreCine(all);
				b.add(all);
				sesionId = rs.getInt("IdSesion");
				sesion.setIdSesion(sesionId);
				asientos.sesionId = NumP;
				int all1 = rs.getInt("IdCine");
				cineId = all1;
				
				i++;
			}
			/*
			String sql1 = "SELECT NombreCine, ci.IdCine, se.IdSesion from cine ci JOIN sala sa on sa.IdCine=ci.IdCine join sesion se on se.IdSala=sa.IdSala WHERE se.IdSesion ='"
					+ sesionId + "'";
			ResultSet rs1 = statement.executeQuery(sql1);
			i = 0;

			while (i <= 3) {
				if (rs1.next()) {
					String all1 = rs1.getString("NombreCine");
					int all2 = rs1.getInt("IdCine");
					cineId = all2;
					b.add(all1);
					i++;
				} else if (!rs1.next()) {
					String alfa = b.get(0).toString();
					b.add(alfa);

					i++;
				}
			}
			*/
			cine.setIdCine(cineId);

			for (int j = 0; j < a.size(); j++) {
				horarioCine.add(a.get(j) + " | " + b.get(j));
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
		return horarioCine;
	}

	public ArrayList<String> horario(int NumP, String idioma) {
		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;
		ArrayList<String> horas = new ArrayList<String>();

		int i = 1;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

			statement = connection.createStatement();

			String sql = "SELECT DISTINCT Horario FROM `sesion` WHERE IdPelicula='" + NumP + "'and Idioma = '" + idioma
					+ "' ";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String all = rs.getString("Horario");
				horas.add(all);
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
		return horas;
	}
}