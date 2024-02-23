package modelo;

import java.util.ArrayList;

public class Pelicula2 {

	private static ArrayList<Integer> idPelicula = new ArrayList<Integer>();
	private static ArrayList<String> titulo = new ArrayList<String>();
	private static ArrayList<String> generoPe = new ArrayList<String>();
	private static ArrayList<String> duracion = new ArrayList<String>();
	private static int contador = 0;

	/**
	 * @param idPelicula
	 * @param titulo
	 * @param generoPe
	 * @param duracion
	 */
	public Pelicula2(int idPelicula, String titulo, String generoPe,
			String duracion) {
		this.idPelicula.add(idPelicula) ;
		this.titulo.add(titulo);
		this.generoPe.add(generoPe);
		this.duracion.add(duracion);
	}

	public Pelicula2() {
	}

	/**
	 * @return the idPelicula
	 */
	public ArrayList<Integer> getIdPelicula() {
		return idPelicula;
	}

	/**
	 * @param idPelicula the idPelicula to set
	 */
	public void setIdPelicula(ArrayList<Integer> idPelicula) {
		this.idPelicula = idPelicula;
	}

	/**
	 * @return the titulo
	 */
	public ArrayList<String> getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(ArrayList<String> titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the generoPe
	 */
	public ArrayList<String> getGeneroPe() {
		return generoPe;
	}

	/**
	 * @param generoPe the generoPe to set
	 */
	public void setGeneroPe(ArrayList<String> generoPe) {
		this.generoPe = generoPe;
	}

	/**
	 * @return the duracion
	 */
	public ArrayList<String> getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(ArrayList<String> duracion) {
		this.duracion = duracion;
	}
	

	public static int getContador() {
		return contador;
	}

	public static void setContador() {
		Pelicula2.contador++;
	}
}
