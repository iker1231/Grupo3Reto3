package vista;

import javax.swing.JFrame;

import controlador.Conectorbd;
import controlador.GestorVentanas;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sql.SelectPeliSql;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.ListSelectionModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import vista.Error;
import modelo.Cliente;
import sql.ClientesSql;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import java.awt.List;
import java.awt.Scrollbar;
import javax.swing.JMenuBar;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;

public class SelectPelicula extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	public SelectPelicula(GestorVentanas v) {
		ClientesSql clientesSql = new ClientesSql();
		setLayout(null);
		SelectPeliSql sql = new SelectPeliSql();
		JButton btnExit = new JButton("Salir");
		btnExit.setBounds(10, 11, 89, 23);
		add(btnExit);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 411, 89, 23);
		add(btnAtras);

		JButton btnLogOut = new JButton("Cerrar Sesión");
		btnLogOut.setBounds(440, 11, 128, 23);
		add(btnLogOut);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "6-cine" }));
		comboBox.setBounds(399, 269, 120, 22);
		add(comboBox);

		JEditorPane dtrpnCartelera = new JEditorPane();
		dtrpnCartelera.setText("cartelera");
		dtrpnCartelera.setBounds(206, 88, 83, 155);
		add(dtrpnCartelera);

		JTextPane txtpnSinopsis = new JTextPane();
		txtpnSinopsis.setText("sinopsis");
		txtpnSinopsis.setBounds(187, 290, 120, 53);
		add(txtpnSinopsis);

		JComboBox comboBoxPelicula = new JComboBox();
		comboBoxPelicula.removeAllItems();
		String[] pelis = sql.nombrePelicula();
		for (int i = 0; i < pelis.length; i++) {
			comboBoxPelicula.addItem(pelis[i]);
		}
		comboBoxPelicula.setToolTipText("");
		comboBoxPelicula.setBounds(30, 87, 113, 22);
		add(comboBoxPelicula);

		JComboBox comboBoxIdioma = new JComboBox();
		comboBoxIdioma.setVisible(false);
		comboBoxIdioma.setModel(new DefaultComboBoxModel());
		comboBoxIdioma.setBounds(206, 257, 83, 22);
		add(comboBoxIdioma);

		JLabel lblNewLabel = new JLabel("3 fecha\r\n4 hora \r\n5 sesion");
		lblNewLabel.setBounds(400, 143, 143, 105);
		add(lblNewLabel);

		JLabel lblGenero = new JLabel("genero");
		lblGenero.setBounds(299, 88, 46, 14);
		add(lblGenero);

		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(299, 116, 46, 14);
		add(lblNewLabel_1_1);

		
		comboBoxPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxIdioma.setVisible(true);
				int a = (int) comboBoxPelicula.getSelectedIndex();
				String[] idiom = sql.idiomPeli(a);
				comboBoxIdioma.removeAllItems();
				for (int i = 0; i < idiom.length; i++) {
					comboBoxIdioma.addItem(idiom[i]);
				}
				repaint();
			}

		});
		
		comboBoxIdioma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				repaint();
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