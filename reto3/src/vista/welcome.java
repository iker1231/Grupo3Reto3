package vista;

import controlador.Conectorbd;

public class welcome {
	public static void main(String[] args){
		Conectorbd gestion = new Conectorbd();
		int n = 10;
		while (n>0) {	 
			System.out.println(n);
			n = n-1;
		}
	}

}