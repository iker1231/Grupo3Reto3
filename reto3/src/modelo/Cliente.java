package modelo;

import java.util.Objects;

public class Cliente {
	@Override
	public int hashCode() {
		return Objects.hash(apellidoCli, contrasena, dni, fechaNacimiento, generoCli, nombreCli);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellidoCli, other.apellidoCli) && Objects.equals(contrasena, other.contrasena)
				&& Objects.equals(dni, other.dni) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(generoCli, other.generoCli) && Objects.equals(nombreCli, other.nombreCli);
	}

	private String dni;
	private String fechaNacimiento;
	private String nombreCli;
	private String apellidoCli;
	private String generoCli;
	private String contrasena;

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	public Cliente(String dni, String fechaNacimiento, String nombreCli, String apellidoCli, String generoCli,
			String contrasena) {
		super();
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreCli = nombreCli;
		this.apellidoCli = apellidoCli;
		this.generoCli = generoCli;
		this.contrasena = contrasena;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the nombreCli
	 */
	public String getNombreCli() {
		return nombreCli;
	}

	/**
	 * @param nombreCli the nombreCli to set
	 */
	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}

	/**
	 * @return the apellidoCli
	 */
	public String getApellidoCli() {
		return apellidoCli;
	}

	/**
	 * @param apellidoCli the apellidoCli to set
	 */
	public void setApellidoCli(String apellidoCli) {
		this.apellidoCli = apellidoCli;
	}

	/**
	 * @return the generoCli
	 */
	public String getGeneroCli() {
		return generoCli;
	}

	/**
	 * @param generoCli the generoCli to set
	 */
	public void setGeneroCli(String generoCli) {
		this.generoCli = generoCli;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contraseña) {
		this.contrasena = contraseña;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", nombreCli=" + nombreCli
				+ ", apellidoCli=" + apellidoCli + ", generoCli=" + generoCli + ", contrasena=" + contrasena + "]";
	}
 
}
