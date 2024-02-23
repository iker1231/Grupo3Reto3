package testJunit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Sesion;
import sql.ClientesSql;
import sql.NoAsientosSQL;
import sql.SelectPeliSql;

class TestLogin {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	/*
	 * @Test(expected = SQLException.class) public void loginCorrecto() {
	 * validarLoginString = ("78998078J", String ) }
	 * 
	 * //
	 * 
	 * @Test public void UsuarioCorrecto (){
	 * 
	 * }
	 * 
	 */

	@Test
	public void testValidarLoginIncorrecto() {
		ClientesSql clientesSql = new ClientesSql();

		// Intenta validar con un DNI y contraseña que no están en la base de datos
		boolean resultado = clientesSql.validarLogin("DNI_no_existente", "contrasena_no_existente");

		// Debería devolver falso, ya que el usuario y/o contraseña no están en la base
		// de datos
		assertFalse(resultado);
	}

	@Test
	public void testValidarLoginCorrecto() {
		ClientesSql clientesSql = new ClientesSql();

		// Aquí podrías agregar un cliente a la base de datos con un DNI y contraseña
		// conocidos
		// Y luego intentar validar con esos valores
		// En este ejemplo, asumimos que ya se agregó el usuario "DNI_existente" con
		// contraseña "contrasena_existente"

		boolean resultado = clientesSql.validarLogin("12345678V", "abcd");

		// Debería devolver verdadero, ya que el usuario y contraseña están en la base
		// de datos
		assertTrue(resultado);
		
	}
	/*
	@Test
	public void testValidar8Peliculas() {
		SelectPeliSql selectPeliSql = new SelectPeliSql();
		int contadorPeliculas=8;
		boolean resultadoPelis =false;
		
		
	for(int i=0; i<=8; i++) {
		
		
	}
	}
	
*/
	@Test
	public void testValidarCines() {
		SelectPeliSql selectPeliSql = new SelectPeliSql();
		 Date fecha = Date.valueOf("2024-02-19");
        String hora = "16:00:00";
        ArrayList<String> resultado = selectPeliSql.sesion(1, fecha, hora);
       
        assertTrue(!resultado.isEmpty());
	}
	
	@Test
	public void testValidarSesiones() {
		SelectPeliSql selectPeliSql = new SelectPeliSql();
		//Con la peli dos en el idioma castellano salen dos sesiones, a las 16 y a las 19.
		  ArrayList<String> resultado = selectPeliSql.horario(2, "Castellano");
		  
		  assertTrue(!resultado.isEmpty());
	}
	
	@Test
	public void testPrecioPelicula() throws SQLException {
        NoAsientosSQL noAsientosSQL = new NoAsientosSQL();
        SelectPeliSql selectPeliSql = new SelectPeliSql();
        
        LocalDate fecha = LocalDate.parse("2024-02-19");
        String hora = "16:00:00";
        
        selectPeliSql.sesion(2, Date.valueOf(fecha), hora.toString());
		float precio = noAsientosSQL.precio();

		 assertEquals(8.50, precio);		
	}
	
	@Test
	public void testValidarSalas() {
		SelectPeliSql selectPeliSql = new SelectPeliSql();
		 Date fecha = Date.valueOf("2024-02-19");
        String hora = "16:00:00";
        ArrayList<String> resultado = selectPeliSql.sesion(1, fecha, hora);
       
        assertTrue(resultado.equals("Tolstoi"));
	}
	
	
	

}
