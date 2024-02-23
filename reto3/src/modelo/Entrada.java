package modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Entrada {
	@Override
	public int hashCode() {
		return Objects.hash(idCompra, idEntrada, idSesion);
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
		return idCompra == other.idCompra && idEntrada == other.idEntrada && idSesion == other.idSesion;
	}

	private static int idEntrada;
	private static int idCompra;
	private static Date FechaEmision;
	private static int idSesion;
	
	
	public static Date getFechaEmision() {
		return FechaEmision;
	}

	public static void setFechaEmision(Date localDate) {
		FechaEmision = localDate;
	}



	/**
	 * 
	 */
	public Entrada() {
	}

	public Entrada(int idEntrada, int idCompra, int idSesion, Date FechaEmision) {
		super();
		this.idEntrada = idEntrada;
		this.idCompra = idCompra;
		this.idSesion = idSesion;
		this.FechaEmision = FechaEmision;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
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
		return "Entrada [idEntrada=" + idEntrada + ", fechaEmision=" + "]";
	}

}
