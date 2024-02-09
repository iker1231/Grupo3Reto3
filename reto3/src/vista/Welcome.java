package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controlador.GestorVentanas;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Welcome extends JPanel{

	private static final long serialVersionUID = 1L;


	/**
	 * Create the application.
	 * @param v 
	 */
	public Welcome(GestorVentanas v) {
		setSize(v.getSize());

		// Establecer el color de fondo y límites del panel
		this.setBackground(new Color(204, 204, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setBounds(100, 100, 450, 300);
		
		// cambiar imagen
		JLabel lblIcono = new JLabel();
		Image img= new ImageIcon(Welcome.class.getResource("/fotos/logo.png")).getImage();
		ImageIcon img2=new ImageIcon(img.getScaledInstance(190, 130, Image.SCALE_SMOOTH));
		lblIcono.setIcon(img2);
		add(lblIcono);

		// Agregar un MouseListener al panel
		addMouseListener(new MouseListener() {
			//a
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			/**
			 * Se le llama cuando se hace clic en cualquier parte del panel. Cambia el panel
			 * a través de la instancia de VentanaPrincipal y hace visible la ventana.
			 * 
			 * @param e El evento del mouse.
			 */
			@Override
			public void mouseClicked(MouseEvent e) {

				v.cambiarPanel(1);
				v.setVisible(true);

			}
			
		});

	}
}
