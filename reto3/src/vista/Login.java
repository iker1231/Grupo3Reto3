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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.ListSelectionModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import vista.Error;
import modelo.Cliente;

public class Login extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;

	public Login() {
		// TODO Auto-generated constructor stub
	}
	//as
	public Login(GestorVentanas v) {

		setLayout(null);

		JButton btnExit = new JButton("Salir");
		btnExit.setBounds(10, 11, 89, 23);
		add(btnExit);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 413, 89, 23);
		add(btnAtras);

		JButton btnLogOut = new JButton("Cerrar Sesión");
		btnLogOut.setBounds(440, 11, 128, 23);
		add(btnLogOut);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(166, 166, 46, 14);
		add(lblDNI);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(126, 227, 86, 14);
		add(lblPassword);

		textField_1 = new JTextField();
		textField_1.setBounds(272, 163, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);

		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(310, 292, 89, 23);
		add(btnLogIn);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(272, 224, 86, 20);
		add(passwordField_1);

		JButton btnCrear = new JButton("Nuevo usuario");
		btnCrear.setBounds(130, 292, 150, 23);
		add(btnCrear);
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
				v.cambiarPanel(0);
				v.setVisible(true);
			}
		});
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String a = "No hay sesión iniciada";
				Error error = new Error();
				error.error(a);
			}
		});
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// llamar y comparar dnis
				v.cambiarPanel(3);
				v.setVisible(true);
			}
		});
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(2);
				v.setVisible(true);
			}
		});

	}
}