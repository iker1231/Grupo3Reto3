package modelo;

import java.util.Objects;

public class Entrada {
	private int id_entrada;
	private String fechaEntrada;
	private String pelicula;
	private String horario;
	private String salaCine;
	private float precio;

	public Entrada() {
	}

	public Entrada(int id_entrada, String fechaEntrada, String pelicula, String horario, String salaCine,
			float precio) {
		this.id_entrada = id_entrada;
		this.fechaEntrada = fechaEntrada;
		this.pelicula = pelicula;
		this.horario = horario;
		this.salaCine = salaCine;
		this.precio = precio;
	}

	/**
	 * @return the id_entrada
	 */
	public int getId_entrada() {
		return id_entrada;
	}

	/**
	 * @param id_entrada the id_entrada to set
	 */
	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
	}

	/**
	 * @return the fechaEntrada
	 */
	public String getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * @param fechaEntrada the fechaEntrada to set
	 */
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	/**
	 * @return the pelicula
	 */
	public String getPelicula() {
		return pelicula;
	}

	/**
	 * @param pelicula the pelicula to set
	 */
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * @return the salaCine
	 */
	public String getSalaCine() {
		return salaCine;
	}

	/**
	 * @param salaCine the salaCine to set
	 */
	public void setSalaCine(String salaCine) {
		this.salaCine = salaCine;
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

	@Override
	public int hashCode() {
		return Objects.hash(fechaEntrada, horario, id_entrada, pelicula, precio, salaCine);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(fechaEntrada, other.fechaEntrada) && Objects.equals(horario, other.horario)
				&& id_entrada == other.id_entrada && Objects.equals(pelicula, other.pelicula)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio)
				&& Objects.equals(salaCine, other.salaCine);
	}

	@Override
	public String toString() {
		return "Entrada [id_entrada=" + id_entrada + ", fechaEntrada=" + fechaEntrada + ", pelicula=" + pelicula
				+ ", horario=" + horario + ", salaCine=" + salaCine + ", precio=" + precio + "]";
	}

}
