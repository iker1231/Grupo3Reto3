package modelo;

public class Cine {
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
