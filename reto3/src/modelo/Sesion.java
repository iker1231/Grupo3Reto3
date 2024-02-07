package modelo;

public class Sesion {
	private int idSesion;
	private String idioma;
	private float precio;
	private String fechaSesion;
	private int horario;
	/**
	 * @return the idSesion
	 */
	public int getIdSesion() {
		return idSesion;
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
