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

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "6-cine" }));
		comboBox.setBounds(399, 269, 120, 22);
		add(comboBox);

		JEditorPane dtrpnCartelera = new JEditorPane();
		dtrpnCartelera.setVisible(false);
		dtrpnCartelera.setText("cartelera");
		dtrpnCartelera.setBounds(39, 117, 83, 155);
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

		JLabel lblNewLabel = new JLabel("3 fecha\r\n4 hora \r\n5 sesion");
		lblNewLabel.setBounds(353, 301, 143, 105);
		add(lblNewLabel);

		JLabel lblGenero = new JLabel("genero");
		lblGenero.setVisible(false);
		lblGenero.setBounds(132, 117, 46, 14);
		add(lblGenero);

		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(20, 411, 60, 21);
		add(lblNewLabel_1_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setVisible(false);
		dateChooser.setLocale(new Locale("es"));
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.getJCalendar().setMinSelectableDate(new java.util.Date());
		dateChooser.setBounds(269, 87, 128, 34);
		add(dateChooser);

		Button buttonFechHora = new Button("Buscar Sesión");
		buttonFechHora.setVisible(false);
		buttonFechHora.setBounds(386, 175, 83, 22);
		add(buttonFechHora);

		Panel panel = new Panel();
		panel.setForeground(Color.LIGHT_GRAY);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBounds(428, 87, 128, 34);
		add(panel);

		JSpinner spinnerHora = new JSpinner();
		spinnerHora.setVisible(false);
		spinnerHora.setModel(new SpinnerNumberModel(15, 14, 23, 1));
		panel.add(spinnerHora);

		JLabel lblDosPuntos = new JLabel(":");
		lblDosPuntos.setVisible(false);
		panel.add(lblDosPuntos);

		JSpinner spinnerMinutos = new JSpinner();
		spinnerMinutos.setVisible(false);
		spinnerMinutos.setModel(new SpinnerNumberModel(0, -1, 60, 1));
		panel.add(spinnerMinutos);

		Label labelFecha = new Label("Fecha");
		labelFecha.setVisible(false);
		labelFecha.setBounds(297, 59, 62, 22);
		add(labelFecha);

		Label labelHora = new Label("Hora");
		labelHora.setVisible(false);
		labelHora.setBounds(467, 59, 62, 22);
		add(labelHora);

		spinnerHora.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int z = (int) spinnerHora.getValue();
				if (z == 23) {
					spinnerHora.setValue(15);
				}
				if (z == 14) {
					spinnerHora.setValue(22);
				}
			}
		});

		spinnerMinutos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int z = (int) spinnerMinutos.getValue();
				if (z == 60) {
					spinnerMinutos.setValue(0);
				}
				if (z == -1) {
					spinnerMinutos.setValue(59);
				}
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
					System.out.println(date);
					int z = (int) spinnerMinutos.getValue();
					int b = (int) spinnerHora.getValue();
					
					int numP = (int) comboBoxPelicula.getSelectedIndex();
					pelisSql.sesion(numP, date , z , b);
					System.out.println(pelisSql.sesion(numP, date , ABORT, numP));
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
				labelHora.setVisible(true);
				spinnerHora.setVisible(true);
				spinnerMinutos.setVisible(true);
				lblDosPuntos.setVisible(true);
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