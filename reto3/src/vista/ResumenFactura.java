package vista;

import javax.swing.JFrame;
import java.io.*;
import java.time.LocalDate;

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
import modelo.Cine;
import modelo.Cliente;
import modelo.Compra;
import modelo.NoEnBD;
import modelo.Pelicula2;
import sql.ClientesSql;

public class ResumenFactura extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	public static int contButacas;
	public static int precio;

	public ResumenFactura(GestorVentanas v) {
		Pelicula2 pelicula = new Pelicula2();
		NoEnBD butacas = new NoEnBD();
		ClientesSql clientesSql = new ClientesSql();
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

		JButton lblNPrevia = new JButton("Vista Previa Factura");
		lblNPrevia.setBounds(343, 98, 148, 23);
		add(lblNPrevia);

		JLabel lblNFact = new JLabel("¿Va a querer factura?");
		lblNFact.setHorizontalAlignment(SwingConstants.CENTER);
		lblNFact.setBounds(354, 147, 134, 14);
		add(lblNFact);

		JButton btnConfir = new JButton("Si");
		btnConfir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File fichero = new File("FichData.dat");
				DataOutputStream dataOS = null;
				Compra compra = new Compra();
				Cine cine = new Cine();
				try {
					FileWriter archivo = new FileWriter("src/factura/" + String.valueOf(compra.getIdCompra())  +".txt");
		            PrintWriter escribir = new PrintWriter(archivo);
		            
		            // Escribir contenido en el archivo
		            escribir.println(compra.getIdCompra());
		            escribir.println(cine.getNombreCine() + " | " + cine.getIdCine());
		            
		            // Cerrar el archivo
		            escribir.close();
		            archivo.close();
		            
		            System.out.println("El archivo alfa se ha creado correctamente.");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfir.setBounds(354, 172, 52, 23);
		add(btnConfir);

		JButton btnNega = new JButton("No");
		btnNega.setBounds(439, 172, 52, 23);
		add(btnNega);

		JLabel lblPrecio = new JLabel("Total a pagar:");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(48, 113, 86, 14);
		add(lblPrecio);

		JLabel lblPrecioInt = new JLabel("€");
		lblPrecioInt.setBounds(144, 113, 46, 14);
		add(lblPrecioInt);

		JLabel lblCantAsientos = new JLabel("Cantidad de butacas:");
		lblCantAsientos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantAsientos.setBounds(13, 88, 121, 14);
		add(lblCantAsientos);

		JLabel lblAsientos = new JLabel(Integer.toString(butacas.getButacas()));
		lblAsientos.setBounds(144, 88, 46, 14);
		add(lblAsientos);

		JLabel lblNumPeliculas = new JLabel(" Cantidad  de  peliculas:");
		lblNumPeliculas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumPeliculas.setBounds(0, 63, 134, 14);
		add(lblNumPeliculas);

		JLabel lblPeliculas = new JLabel(Integer.toString(pelicula.getContador()));
		lblPeliculas.setBounds(144, 63, 46, 14);
		add(lblPeliculas);
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
				// alfa
				if (ventanaYesNot == 0) {
					System.exit(0);
				} else if (ventanaYesNot == 1) {

				}
			}
		});
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(4);
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