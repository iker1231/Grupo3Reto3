package modelo;

import java.util.ArrayList;

public class Proyeccion {
	private ArrayList<Pelicula> peliculas = null;
	private ArrayList<Sala> salas = null;
	/**
	 * @return the peliculas
	 */
	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}
	/**
	 * @param peliculas the peliculas to set
	 */
	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	/**
	 * @return the salas
	 */
	public ArrayList<Sala> getSalas() {
		return salas;
	}
	/**
	 * @param salas the salas to set
	 */
	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	
}
