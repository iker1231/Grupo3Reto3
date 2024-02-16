package modelo;

import java.util.Objects;

public class Compra {
	@Override
	public int hashCode() {
		return Objects.hash(descuento, dni, fechaCompra, idCompra, precioTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return descuento == other.descuento && Objects.equals(dni, other.dni)
				&& Objects.equals(fechaCompra, other.fechaCompra) && idCompra == other.idCompra
				&& Float.floatToIntBits(precioTotal) == Float.floatToIntBits(other.precioTotal);
	}

	private String dni;
	private int idCompra;
	private String fechaCompra;
	private float precioTotal;
	private int descuento;

	/**
	 * @return the idCompra
	 */
	public int getIdCompra() {
		return idCompra;
	}

	public Compra(int idCompra, String fechaCompra, float precioTotal, int descuento, String dni) {
		super();
		this.idCompra = idCompra;
		this.fechaCompra = fechaCompra;
		this.precioTotal = precioTotal;
		this.descuento = descuento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @param idCompra the idCompra to set
	 */
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	/**
	 * @return the fechaCompra
	 */
	public String getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	/**
	 * @return the precioTotal
	 */
	public float getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param precioTotal the precioTotal to set
	 */
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * @return the descuento
	 */
	public int getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", fechaCompra=" + fechaCompra + ", precioTotal=" + precioTotal
				+ ", descuento=" + descuento + "]";
	}
}
