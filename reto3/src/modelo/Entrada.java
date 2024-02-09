package modelo;

import java.util.ArrayList;

public class Entrada {
	private int idEntrada;
	private ArrayList<Sesion> sesiones = null;

	/**
	 * 
	 */
	public Entrada() {
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




	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", fechaEmision="+ "]";
	}

	public ArrayList<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(ArrayList<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
}
