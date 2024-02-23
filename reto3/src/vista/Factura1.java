package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Window.Type;

public class Factura1 {

	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("Nombre CIne");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Factura1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setResizable(false);
		frame.setBounds(100, 100, 216, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblNewLabel.setBounds(10, 69, 68, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("idcine");
		lblNewLabel_1.setBounds(88, 77, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IdEntrada");
		lblNewLabel_2.setBounds(10, 11, 68, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setBounds(139, 6, 103, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Sala");
		lblNewLabel_4.setBounds(10, 105, 68, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NombrePeli");
		lblNewLabel_5.setBounds(10, 147, 68, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("x butaca");
		lblNewLabel_6.setBounds(88, 147, 56, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Precio total");
		lblNewLabel_7.setBounds(10, 200, 73, 14);
		frame.getContentPane().add(lblNewLabel_7);
	}
}
