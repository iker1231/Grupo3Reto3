package modelo;

public class Pelicula {

	private int idPelicula;
	private String titulo;
	private String generoPe;
	private String duracion;

	/**
	 * @param idPelicula
	 * @param titulo
	 * @param generoPe
	 * @param duracion
	 */
	public Pelicula(int idPelicula, String titulo, String generoPe, String duracion) {
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.generoPe = generoPe;
		this.duracion = duracion;
	}
	//a
	/**
	 * @return the idPelicula
	 */
	public int getIdPelicula() {
		return idPelicula;
	}

	/**
	 * @param idPelicula the idPelicula to set
	 */
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the generoPe
	 */
	public String getGeneroPe() {
		return generoPe;
	}

	/**
	 * @param generoPe the generoPe to set
	 */
	public void setGeneroPe(String generoPe) {
		this.generoPe = generoPe;
	}

	/**
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Peliculas [idPelicula=" + idPelicula + ", titulo=" + titulo + ", generoPe=" + generoPe + ", duracion="
				+ duracion + "]";
	}
}
