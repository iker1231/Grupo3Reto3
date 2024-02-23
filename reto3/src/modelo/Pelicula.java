package modelo;

public class Pelicula {

	private static int idPelicula;
	private static String titulo;
	private static String generoPe;
	private static String duracion;

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

	public Pelicula() {
	}

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
	public void almacenar() {
		Pelicula2 pelicula = new Pelicula2(getIdPelicula(), getTitulo(), getGeneroPe(), getDuracion());
		Pelicula2 peli = new Pelicula2();
		peli.setContador();
	}
}
