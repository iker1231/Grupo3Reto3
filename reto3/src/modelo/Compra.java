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

	private static String dni;
	private static int idCompra;
	private static String fechaCompra;
	private static float precioTotal;
	private static float descuento;

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

	public Compra() {
		// TODO Auto-generated constructor stub
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
		this.precioTotal = this.precioTotal + precioTotal;
	}

	/**
	 * @return the descuento
	 */
	public float getDescuento() {
		return descuento;
	}

	/**
	 * @param porcent the descuento to set
	 */
	public void setDescuento(float porcent) {
		this.descuento = porcent;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", fechaCompra=" + fechaCompra + ", precioTotal=" + precioTotal
				+ ", descuento=" + descuento + "]";
	}
}
