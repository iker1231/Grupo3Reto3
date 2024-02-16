package modelo;

import java.util.Objects;

public class Cine {
	@Override
	public int hashCode() {
		return Objects.hash(idCine, nombreCine);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return idCine == other.idCine && Objects.equals(nombreCine, other.nombreCine);
	}

	private int idCine;
	private String nombreCine;

	
	public Cine(int idCine, String nombreCine) {
		this.idCine = idCine;
		this.nombreCine = nombreCine;
	}

	/**
	 * @return the idCine
	 */
	public int getIdCine() {
		return idCine;
	}

	/**
	 * @param idCine the idCine to set
	 */
	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

	/**
	 * @return the nombreCine
	 */
	public String getNombreCine() {
		return nombreCine;
	}

	/**
	 * @param nombreCine the nombreCine to set
	 */
	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	@Override
	public String toString() {
		return "Cine [idCine=" + idCine + ", nombreCine=" + nombreCine + "]";
	}

}
