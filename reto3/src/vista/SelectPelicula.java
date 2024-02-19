package vista;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Locale;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;

import controlador.GestorVentanas;
import modelo.Pelicula;
import vista.Error;
import sql.ClientesSql;
import sql.SelectPeliSql;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JSpinner;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class SelectPelicula extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	

	public SelectPelicula(GestorVentanas v) {
		ClientesSql clientesSql = new ClientesSql();
		Pelicula p = new Pelicula();
		setLayout(null);
		
		SelectPeliSql pelisSql = new SelectPeliSql();
		JButton btnExit = new JButton("Salir");
		btnExit.setBounds(10, 11, 89, 23);
		add(btnExit);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 410, 89, 23);
		add(btnAtras);

		JButton btnLogOut = new JButton("Cerrar Sesión");
		btnLogOut.setBounds(440, 11, 128, 23);
		add(btnLogOut);

		JComboBox comboBoxCine = new JComboBox();
		comboBoxCine.setBounds(353, 305, 120, 22);
		add(comboBoxCine);

		JEditorPane dtrpnCartelera = new JEditorPane();
		dtrpnCartelera.setVisible(false);
		dtrpnCartelera.setText("cartelera");
		dtrpnCartelera.setBounds(39, 117, 89, 155);
		add(dtrpnCartelera);

		JTextPane txtpnSinopsis = new JTextPane();
		txtpnSinopsis.setVisible(false);
		txtpnSinopsis.setText("sinopsis");
		txtpnSinopsis.setBounds(20, 319, 120, 53);
		add(txtpnSinopsis);

		JComboBox comboBoxPelicula = new JComboBox();
		comboBoxPelicula.removeAllItems();
		String[] pelis = pelisSql.nombrePelicula();
		for (int i = 0; i < pelis.length; i++) {
			comboBoxPelicula.addItem(pelis[i]);
		}
		comboBoxPelicula.setToolTipText("");
		comboBoxPelicula.setBounds(30, 87, 113, 22);
		add(comboBoxPelicula);

		JComboBox comboBoxIdioma = new JComboBox();
		comboBoxIdioma.setVisible(false);
		comboBoxIdioma.setModel(new DefaultComboBoxModel());
		comboBoxIdioma.setBounds(39, 286, 83, 22);
		add(comboBoxIdioma);

		JLabel lblGenero = new JLabel("genero");
		lblGenero.setVisible(false);
		lblGenero.setBounds(132, 117, 46, 14);
		add(lblGenero);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setVisible(false);
		dateChooser.setLocale(new Locale("es"));
		dateChooser.setDateFormatString("yyyy-MM-dd");
		//dateChooser.getJCalendar().setMinSelectableDate(new java.util.Date());
		dateChooser.setBounds(269, 87, 128, 34);
		add(dateChooser);

		Button buttonFechHora = new Button("Buscar Sesión");
		buttonFechHora.setVisible(false);
		buttonFechHora.setBounds(374, 154, 83, 22);
		add(buttonFechHora);

		Label labelFecha = new Label("Fecha");
		labelFecha.setVisible(false);
		labelFecha.setBounds(297, 59, 62, 22);
		add(labelFecha);
		
		JComboBox comboBoxSesion = new JComboBox();
		comboBoxSesion.setVisible(false);
		comboBoxSesion.setBounds(353, 238, 120, 22);
		add(comboBoxSesion);
		
		JLabel lblAviso = new JLabel("Hora no activa");
		lblAviso.setForeground(Color.RED);
		lblAviso.setBounds(450, 67, 101, 14);
		add(lblAviso);
		
		JButton btnNoAsientos = new JButton("Seguir");
		btnNoAsientos.setBounds(479, 410, 89, 23);
		add(btnNoAsientos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(440, 87, 95, 22);
		add(comboBox);
		
		btnNoAsientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(4);
				v.setVisible(true);
				
			}
		});

		buttonFechHora.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if (dateChooser.getDate() == null) {
					String a1 = "Inserte una fecha";
					Error error = new Error();
					error.error(a1);
				} else {
					String str = sdf.format(dateChooser.getDate());
					Date date = Date.valueOf(str);
					String idioma = (String) comboBoxIdioma.getSelectedItem();
					//Falta Hora
					
					int numP = (int) comboBoxPelicula.getSelectedIndex();
					
					String a = pelisSql.sesion(numP, date, idioma);
					comboBoxSesion.setVisible(true);
					comboBoxSesion.setModel(new DefaultComboBoxModel(new String[] {a}));
					
				}
			}
		});

		comboBoxPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxIdioma.setVisible(true);
				dtrpnCartelera.setVisible(true);
				lblGenero.setVisible(true);
				txtpnSinopsis.setVisible(true);
				int numP = (int) comboBoxPelicula.getSelectedIndex();
				String[] idiom = pelisSql.idiomPeli(numP);
				comboBoxIdioma.removeAllItems();
				for (int i = 0; i < idiom.length; i++) {
					comboBoxIdioma.addItem(idiom[i]);
				}
				// genero no funciona, el dato almacenado en pelicula no sale con el get, se
				// envian los datos desde el sql pelis
				lblGenero.setText(p.getGeneroPe());
				lblGenero.repaint();
				repaint();
			}

		});
		
		
		comboBoxIdioma.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				labelFecha.setVisible(true);
				dateChooser.setVisible(true);


				buttonFechHora.setVisible(true);
				repaint();
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});

		btnExit.addMouseListener(new MouseAdapter() {
			/**
			 * Se llama cuando se hace clic en el botón "Salir". Cierra la aplicación al
			 * llamar a System.exit(0).
			 * 
			 * @param e es el evento del mouse.
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				int ventanaYesNot = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", v.getTitle(),
						JOptionPane.YES_NO_OPTION);
				// 0=yes, 1=no, 2=cancel
				if (ventanaYesNot == 0) {
					System.exit(0);
				} else if (ventanaYesNot == 1) {

				}
			}
		});
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(1);
				v.setVisible(true);
			}
		});
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Sesion cerrada");
				v.cambiarPanel(1);
				v.setVisible(true);
			}
		});

	}
}