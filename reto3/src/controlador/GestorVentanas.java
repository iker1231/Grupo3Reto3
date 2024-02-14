package controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLayeredPane;

import vista.Pelicula;
import vista.Welcome;
import vista.Login;
import vista.CrearUsuario;

public class GestorVentanas extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	//ahshs
	public GestorVentanas() {
		setSize(600, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Cine Elorrieta");
	}
	//esto
	public void lanzarVentana() {
		this.cambiarPanel(0);
		this.setVisible(true);
	}
	public void cambiarPanel(int identificadorDePanel) {
		switch (identificadorDePanel) {
		case 0:
			setContentPane(new Welcome(this));
			break;

		case 1:
			setContentPane(new Login(this));
			break;
			
		case 2:
			setContentPane(new CrearUsuario(this));
			break;
			
		case 3:
			setContentPane(new Pelicula(this));
			break;
			/*
		case 8:
			setContentPane(new EdicionAdministrador(this));
			break;
		case 9:
			setContentPane(new Prueba(this));
			break;
			*/
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			Conectorbd gestion = new Conectorbd();
			
			GestorVentanas ventanaPrincipal = new GestorVentanas();
			ventanaPrincipal.lanzarVentana();
	}
}
