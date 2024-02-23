package modelo;

public class NoEnBD {
	private static int butacas = 0;

	public static int getButacas() {
		return butacas;
	}

	public static void setButacas(int butacas) {
		NoEnBD.butacas = NoEnBD.butacas + butacas;
	}
	

}
