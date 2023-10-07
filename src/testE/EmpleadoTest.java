package testE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTest {

	public enum TipoEmpleado{Vendedor, Encargado, Otro};
	public float ventasMes;
	public float horasExtra;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		TipoEmpleado tipo = Encargado;
		ventasMes = 1000;
		horaExtra = 2;
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculaNominaBrutaEncargado() {
		TipoEmpleado tipo = Encargado;
		int expected = 2,660;
		int actaul = calculaNominaBruta(tipo, ventasMes, horaExtra);
		assertEquals(expected,actaul);
	}

	@Test
	void testCalculoNominaNetaVendedor() {
		TipoEmpleado tipo = Vendedor;
		int expected = 2,160;
		int actaul = calculaNominaBruta(tipo, ventasMes, horaExtra);
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaOtro() {
		TipoEmpleado tipo = Otro;
		int expected = 60;
		int actaul = calculaNominaBruta(tipo, ventasMes, horaExtra);
		assertEquals(expected,actaul);
	}

	@Test
	void testCalculaNominaBrutaVentasNegativa() {

		ventasMes = -50;
		
		int expected = 2,560;
		int actaul = calculaNominaBruta(tipo, ventasMes, horaExtra);
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaVentasMesMenos1000() {
		
		ventasMes = 999;
		
		int expected = 2,560;
		int actaul = calculaNominaBruta(tipo, ventasMes, horaExtra);
		
		assertEquals(expected,actaul);
	}

	@Test
	void testCalculaNominaBrutaVentasMesEntre1000y1500() {

		ventasMes = 1250;
		
		int expected = 2,660;
		int actaul = calculaNominaBruta(tipo, ventasMes, horaExtra);
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaVentasMesMayor1500() {

		ventasMes = 1750;
		
		int expected = 2,760;
		int actaul = calculaNominaBruta(tipo, ventasMes, horaExtra);
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaHorasExtraPositivas() {
		
		horaExtra = 2;
		
		int expected = 2,660;
		int actaul = calculaNominaBruta(tipo, ventasMes, horaExtra);
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaHorasExtraNegativas() {
		
		horaExtra = -2;
		
		int expected = 2,540;
		int actaul = calculaNominaBruta(tipo, ventasMes, horaExtra);
		
		assertEquals(expected,actaul);
	}

	@Test
	void testCalculoNominaNetaNegativa() {
		
		TipoEmpleado tipo = Otro;
		horaExtra = -2;
		ventasMes = 500;
		
		int expected = -60;
		int actaul = calculoNominaNeta(calculaNominaBruta(tipo, ventasMes, horaExtra));
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculoNominaNetaMenos2100() {
		
		TipoEmpleado tipo = Vendedor;
		horaExtra = 0;
		ventasMes = 500;
		
		int expected = 2000;
		int actaul = calculoNominaNeta(calculaNominaBruta(tipo, ventasMes, horaExtra));
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		
		TipoEmpleado tipo = Vendedor;
		horaExtra = 1;
		ventasMes = 1000;
		
		int expected = 1,836;
		int actaul = calculoNominaNeta(calculaNominaBruta(tipo, ventasMes, horaExtra));
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculoNominaNetaMayor2500() {
		
		TipoEmpleado tipo = Encargado;
		horaExtra = 0;
		ventasMes = 1000;
		
		int expected = 2,132;
		int actaul = calculoNominaNeta(calculaNominaBruta(tipo, ventasMes, horaExtra));
		
		assertEquals(expected,actaul);
	}

}
