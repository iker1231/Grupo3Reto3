package modelo;

import java.util.Objects;

public class Sesion {
	@Override
	public int hashCode() {
		return Objects.hash(fechaSesion, horario, idPelicula, idSala, idSesion, idioma, precio);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sesion other = (Sesion) obj;
		return Objects.equals(fechaSesion, other.fechaSesion) && horario == other.horario
				&& idPelicula == other.idPelicula && idSala == other.idSala && idSesion == other.idSesion
				&& Objects.equals(idioma, other.idioma)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio);
	}

	private static  int idSesion;
	private static int idPelicula;
	private static int idSala;
	private static String idioma;
	private static float precio;
	private static String fechaSesion;
	private static int horario;
	/**
	 * @return the idSesion
	 */
	public int getIdSesion() {
		return idSesion;
	}
  


	public Sesion(int idSesion, int idPelicula, int idSala, String idioma, float precio, String fechaSesion,
			int horario) {
		super();
		this.idSesion = idSesion;
		this.idPelicula = idPelicula;
		this.idSala = idSala;
		this.idioma = idioma;
		this.precio = precio;
		this.fechaSesion = fechaSesion;
		this.horario = horario;
	}



	public Sesion() {
	}



	public int getIdPelicula() {
		return idPelicula;
	}



	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}



	public int getIdSala() {
		return idSala;
	}



	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}



	public String getIdioma() {
		return idioma;
	}



	/**
	 * @param idSesion the idSesion to set
	 */
	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	/**
	 * @param idioma the idioma to set
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
  
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return the fechaSesion
	 */
	public String getFechaSesion() {
		return fechaSesion;
	}

	/**
	 * @param fechaSesion the fechaSesion to set
	 */
	public void setFechaSesion(String fecha) {
		this.fechaSesion = fecha;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Sesion [idSesion=" + idSesion + ", idioma=" + idioma + ", precio=" + precio + ", fechaSesion="
				+ fechaSesion + "]";
	}

}
