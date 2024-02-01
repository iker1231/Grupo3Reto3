package modelo;

public class Cliente {
 private int dni;
 private String fechaNacimiento;
 private String nombreCli;
 private String apellidoCli;
 private String generoCli;
 private String contraseña;
/**
 * @return the dni
 */
public int getDni() {
	return dni;
}
/**
 * @param dni the dni to set
 */
public void setDni(int dni) {
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
 * @return the contraseña
 */
public String getContraseña() {
	return contraseña;
}
/**
 * @param contraseña the contraseña to set
 */
public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}
@Override
public String toString() {
	return "Cliente [dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", nombreCli=" + nombreCli
			+ ", apellidoCli=" + apellidoCli + ", generoCli=" + generoCli + ", contraseña=" + contraseña + "]";
}
 
 
}