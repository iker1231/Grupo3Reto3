package modelo;

public class Compra {
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
