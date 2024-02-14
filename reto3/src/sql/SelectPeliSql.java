package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.Cliente;

public class SelectPeliSql {

	public String[] nombrePelicula() {
		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;
		String[] pelis = { "", "", "", "" };

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto3_grupo3", "grupo3", "Grupo_Tres_3");

			statement = connection.createStatement();

			String sql = "select Titulo from pelicula";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				int i = 0;
				String all = rs.getString("Titulo");
				//System.out.println(all);
				
					pelis[i]=all;
					System.out.println(pelis[i]);
				 i = i+1;
			
			}

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo 1");
		}
		return pelis;
	}

}
