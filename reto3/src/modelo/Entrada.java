package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Entrada {
	private int idEntrada;
	private String fechaEmision;
	private ArrayList<Sesion> sesiones = null;

	public Entrada() {
	}

	public Entrada(int id_entrada, String fechaEntrada) {
		this.idEntrada = idEntrada;
		this.fechaEmision = fechaEmision;
	}

	/**
	 * @return the idEntrada
	 */
	public int getIdEntrada() {
		return idEntrada;
	}

	/**
	 * @param idEntrada the idEntrada to set
	 */
	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	/**
	 * @return the fechaEmision
	 */
	public String getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", fechaEmision=" + fechaEmision + "]";
	}

	

}
