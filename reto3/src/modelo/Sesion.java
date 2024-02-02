package modelo;

public class Sesion {
	private int idSesion;
	private String idioma;
	private float precio;
	private String fecha;
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
	 * @return the idioma
	 */
	public String getIdioma() {
		return idioma;
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
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Sesion [idSesion=" + idSesion + ", idioma=" + idioma + ", precio=" + precio + ", fecha=" + fecha + "]";
	}
	
	

}
