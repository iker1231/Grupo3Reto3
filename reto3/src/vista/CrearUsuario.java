package vista;

import javax.swing.JFrame;

import controlador.Conectorbd;
import controlador.GestorVentanas;
import sql.ClientesSql;

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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.ListSelectionModel;
import java.beans.PropertyChangeListener;
import java.sql.SQLClientInfoException;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSpinner;

public class CrearUsuario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final char[] NullPointerException = null;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textFieldDNI;
	private JPasswordField passwordFieldPassword1;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTable table;
	private JPasswordField passwordFieldPassword2;
	ClientesSql clientesSql = new ClientesSql();

	public CrearUsuario(GestorVentanas v) {
		Cliente cliente = new Cliente();
		setLayout(null);

		JButton btnExit = new JButton("Salir");
		btnExit.setBounds(10, 11, 89, 23);
		add(btnExit);

		JButton btnAtras = new JButton("Atras/Cancelar");
		btnAtras.setBounds(10, 391, 140, 23);
		add(btnAtras);

		JButton btnCrear = new JButton("Crear");

		btnCrear.setBounds(481, 403, 89, 23);
		add(btnCrear);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(119, 74, 46, 14);
		add(lblDNI);

		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] { "Hombre", "Mujer" }));
		comboBoxGenero.setBounds(161, 166, 63, 22);
		add(comboBoxGenero);
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(161, 71, 86, 20);
		add(textFieldDNI);

		passwordFieldPassword1 = new JPasswordField();
		passwordFieldPassword1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String a = passwordFieldPassword1.getText();
				String b = passwordFieldPassword2.getText();
				if ((a.length() == 0) || (b.length() == 0)) {
					passwordFieldPassword1.setBackground(new Color(255, 153, 153));
					passwordFieldPassword2.setBackground(new Color(255, 153, 153));
				} else if ((a.length() != 0) && (b.length() != 0)) {
					if (a.equals(b)) {
						passwordFieldPassword1.setBackground(new Color(153, 255, 102));
						passwordFieldPassword2.setBackground(new Color(153, 255, 102));
					} else if (!a.equals(b)) {
						passwordFieldPassword1.setBackground(new Color(255, 153, 153));
						passwordFieldPassword2.setBackground(new Color(255, 153, 153));
					}
				}
				repaint();
			}

		});
		passwordFieldPassword1.setBackground(new Color(255, 255, 255));
		passwordFieldPassword1.setBounds(161, 102, 86, 20);
		add(passwordFieldPassword1);

		passwordFieldPassword2 = new JPasswordField();
		passwordFieldPassword2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String a = passwordFieldPassword1.getText();
				String b = passwordFieldPassword2.getText();
				if ((a.length() == 0) && (b.length() == 0)) {
					passwordFieldPassword1.setBackground(new Color(255, 153, 153));
					passwordFieldPassword2.setBackground(new Color(255, 153, 153));
				} else if ((a.length() != 0) && (b.length() != 0)) {
					if (a.equals(b)) {
						passwordFieldPassword1.setBackground(new Color(153, 255, 102));
						passwordFieldPassword2.setBackground(new Color(153, 255, 102));
					} else if (!a.equals(b)) {
						passwordFieldPassword1.setBackground(new Color(255, 153, 153));
						passwordFieldPassword2.setBackground(new Color(255, 153, 153));
					}
				}
				repaint();
			}
		});

		passwordFieldPassword2.setBounds(161, 133, 86, 20);
		add(passwordFieldPassword2);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(161, 199, 86, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(161, 230, 86, 20);
		add(textFieldApellidos);
		textFieldApellidos.setColumns(10);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		/*
		 * table.setModel(new javax.swing.table.DefaultTableModel(null, new String[] {
		 * // Defines TODOS los nombres de las columnas que tendrá la tabla "Codigo",
		 * "Cantidad", "Nombre", "Precio" }) {
		 * 
		 * Class[] types = new Class[] { // Defines el tipo que admitirá la COLUMNA,
		 * cada uno con el índice // correspondiente // Codigo (Integer), Cantidad
		 * (Integer), Nombre (String), Precio(Double) java.lang.Integer.class,
		 * java.lang.Integer.class, java.lang.String.class, java.lang.Double.class };
		 * 
		 * // Función que asignará el tipo de campo que asignaste previamente public
		 * Class getColumnClass(int columnIndex) { return types[4]; } });
		 */

		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column" }));

		table.setBounds(13, 456, 86, 14);
		add(table);

		JLabel lblContrasena1 = new JLabel("Contraseña");
		lblContrasena1.setBounds(82, 105, 69, 14);
		add(lblContrasena1);

		JLabel lblContrasena2 = new JLabel("Contraseña");
		lblContrasena2.setBounds(82, 136, 69, 14);
		add(lblContrasena2);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(105, 170, 38, 14);
		add(lblGenero);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(105, 202, 46, 14);
		add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setBounds(82, 233, 61, 14);
		add(lblApellidos);

		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String a = passwordFieldPassword1.getText();
				String b = passwordFieldPassword2.getText();
				if ((a.length() == 0) || (b.length() == 0)) {
					String a1 = "Las dos contraseñas deben ser iguales";
					Error error = new Error();
					error.error(a1);
				} else if ((a.length() != 0) && (b.length() != 0)) {
					if (a.equals(b)) {
						cliente.setDni(textFieldDNI.getText());
						cliente.setContrasena(passwordFieldPassword1.getText());
						cliente.setNombreCli(textFieldNombre.getText());
						cliente.setApellidoCli(textFieldApellidos.getText());
						cliente.setGeneroCli((String) comboBoxGenero.getSelectedItem());
						// dni largo mensaje de creado
						if (clientesSql.insertarCliente(cliente) == 1) {
							v.cambiarPanel(1);
							v.setVisible(true);
						} else {
							textFieldDNI.setText("");
							passwordFieldPassword1.setText("");
							textFieldNombre.setText("");
							textFieldApellidos.setText("");
							passwordFieldPassword2.setText("");
							passwordFieldPassword1.setBackground(new Color(255, 153, 153));
							passwordFieldPassword2.setBackground(new Color(255, 153, 153));
							repaint();
						}
					}
				}
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

	}
}