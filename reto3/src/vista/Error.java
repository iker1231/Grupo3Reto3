package vista;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class Error {
	public void error(String a) {
		JOptionPane.showMessageDialog(null, a, 
				null, JOptionPane.ERROR_MESSAGE);
	}
}
