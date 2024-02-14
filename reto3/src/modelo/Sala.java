package modelo;

public class Sala {
	private int idSala;
	private int idCine;
	private String nombreSala;

	/**
	 * @return the idSala
	 */
	public int getIdSala() {
		return idSala;
	}

	

	public int getIdCine() {
		return idCine;
	}



	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}



	public Sala(int idSala, int idCine, String nombreSala) {
		super();
		this.idSala = idSala;
		this.idCine = idCine;
		this.nombreSala = nombreSala;
	}



	/**
	 * @param idSala the idSala to set
	 */
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	/**
	 * @return the nombreSala
	 */
	public String getNombreSala() {
		return nombreSala;
	}

	/**
	 * @param nombreSala the nombreSala to set
	 */
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", nombreSala=" + nombreSala + "]";
	}

}
