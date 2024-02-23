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
import java.sql.Date;
import java.time.LocalDate;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import vista.Error;
import modelo.Cliente;
import modelo.Compra;
import modelo.Entrada;
import modelo.NoEnBD;
import modelo.Sesion;
import sql.ClientesSql;
import sql.CompraSQL;
import sql.NoAsientosSQL;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class NoAsientos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTable table;

	public NoAsientos(GestorVentanas v) {
		float precio = 0;
		CompraSQL compra = new CompraSQL();
		NoAsientosSQL asientos = new NoAsientosSQL();
		ClientesSql clientesSql = new ClientesSql();
		Sesion sesion = new Sesion();
		setLayout(null);

		JButton btnExit = new JButton("Salir");
		btnExit.setBounds(10, 11, 89, 23);
		add(btnExit);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 411, 89, 23);
		add(btnAtras);

		JButton btnLogOut = new JButton("Cerrar Sesión");
		btnLogOut.setBounds(440, 11, 128, 23);
		add(btnLogOut);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(450, 82, 100, 179);
		add(table);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(75, 79, 39, 20);
		add(spinner);
		
		JLabel lblPrecioFinal = new JLabel("Precio Final:");
		lblPrecioFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioFinal.setBounds(0, 302, 94, 14);
		add(lblPrecioFinal);
		
		JLabel lblShowPrecio = new JLabel("0€");
		lblShowPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblShowPrecio.setBounds(104, 302, 46, 14);
		add(lblShowPrecio);
		
		JLabel lblPrecioEntrada = new JLabel("Precio Entrada:");
		lblPrecioEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioEntrada.setBounds(0, 277, 94, 14);
		add(lblPrecioEntrada);
		
		JLabel lblShowPrecioEtrada = new JLabel("0€");
		lblShowPrecioEtrada.setHorizontalAlignment(SwingConstants.LEFT);
		lblShowPrecioEtrada.setBounds(104, 277, 46, 14);
		add(lblShowPrecioEtrada);
		
		JLabel lblDescuento = new JLabel("-X%");
		lblDescuento.setBounds(149, 302, 46, 14);
		add(lblDescuento);
		
		JButton btnContinuar = new JButton("siguiente");
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			//genero compra en bbdd uso su id en entrada y despues de crear todas las entradas termino compra
			public void mouseClicked(MouseEvent e) {
				Compra comprada = new Compra();
				
				int a = compra.compra1();
				Entrada entrada = new Entrada();
				entrada.setIdSesion(sesion.getIdSesion());
				Date date = Date.valueOf(LocalDate.now());
				entrada.setFechaEmision(date);
				for (int i =0; i <= (int) spinner.getValue(); i++) {
					compra.entrada();
					
					
					
				}
				CompraSQL loco = new CompraSQL();
				NoEnBD butacas = new NoEnBD();
				butacas.setButacas((int) spinner.getValue());
				int ventanaYesNot = JOptionPane.showConfirmDialog(null, "¿Seguir comprando?", v.getTitle(),
						JOptionPane.YES_NO_OPTION);
				// 0=yes, 1=no, 2=cancel
				if (ventanaYesNot == 0) {
					v.cambiarPanel(3);
					v.setVisible(true);
				} else if (ventanaYesNot == 1) {
					compra.compra2();
					v.cambiarPanel(5);
					v.setVisible(true);
					
				}
			}
		});
		btnContinuar.setBounds(479, 411, 89, 23);
		add(btnContinuar);
		
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				float a = 0;
				float porcent = 0;
				Compra comprada = new Compra();
				
				lblShowPrecioEtrada.setText(Float.toString(asientos.precio()) + "€");
				lblShowPrecio.setText(Float.toString(asientos.precio()) + "€");
				if (!spinner.getValue().toString().equals("1")) {
					if ((int) spinner.getValue() <= 5) {
						porcent =  Integer.parseInt(spinner.getValue().toString()) *10;
					} else {
						porcent = 50;
					}
					comprada.setDescuento(porcent);
					a = ((asientos.precio()*Integer.parseInt(spinner.getValue().toString())) - porcent/100 * (asientos.precio()*Integer.parseInt(spinner.getValue().toString())));
					comprada.setPrecioTotal(a);
					lblShowPrecio.setText(Float.toString(a) + "€");
					lblDescuento.setText(Float.toString(porcent) + "%");
					
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
				v.cambiarPanel(3);
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