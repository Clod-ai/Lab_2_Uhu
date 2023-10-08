package testE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Empleados.Empleado;
import Empleados.Empleado.TipoEmpleado;

class EmpleadoTest {

	public TipoEmpleado tipo = TipoEmpleado.Vendedor;
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
		tipo = TipoEmpleado.Encargado;
		ventasMes = 990;
		horasExtra = 0;
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculaNominaBrutaEncargado() {
		tipo = TipoEmpleado.Encargado;
		float expected = 2500;
		float actaul = Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected,actaul);
	}

	@Test
	void testCalculoNominaNetaVendedor() {
		tipo = TipoEmpleado.Vendedor;
		float expected = 2000;
		float actaul = Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaOtro() {
		tipo = TipoEmpleado.Otro;
		ventasMes = 0;
		horasExtra=0;
		
		float expected = 0;
		float actaul = Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra);
		assertEquals(expected,actaul);
	}

	@Test
	void testCalculaNominaBrutaVentasNegativa() {

		tipo = TipoEmpleado.Vendedor;
		ventasMes = -500;
		horasExtra = 0;
		
		float expected = 2000;
		float actaul = Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra);
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaVentasMesMenos1000() {
		
		tipo = TipoEmpleado.Vendedor;
		ventasMes = 500;
		horasExtra = 0;
		
		float expected = 2000;
		float actaul = Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra);
		
		assertEquals(expected,actaul);
	}

	@Test
	void testCalculaNominaBrutaVentasMesEntre1000y1500() {

		ventasMes = 1250;
		
		float expected = 2600;
		float actaul = Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra);
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaVentasMesMayor1500() {

		tipo = TipoEmpleado.Encargado;
		ventasMes = 1750;
		horasExtra = 0;
		
		float expected = 2700;
		float actaul = Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra);
		System.out.println(actaul);
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaHorasExtraPositivas() {
		
		tipo = TipoEmpleado.Encargado;
		ventasMes = 1750;
		horasExtra = 2;
		
		float expected = 2760;
		float actaul = Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra);
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculaNominaBrutaHorasExtraNegativas() {
		
		tipo = TipoEmpleado.Otro;
		ventasMes=0;
		horasExtra = -1;
		
		float expected = -30;
		float actaul = Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra);
		
		assertEquals(expected,actaul);
	}

	@Test
	void testCalculoNominaNetaNegativa() {
		
		tipo = TipoEmpleado.Otro;
		horasExtra = -2;
		ventasMes = 500;
		
		float expected = -60;
		float actaul = Empleado.calculoNominaNeta(Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra));
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculoNominaNetaMenos2100() {
		
		tipo = TipoEmpleado.Vendedor;
		horasExtra = 0;
		ventasMes = 500;
		
		float expected = 2000;
		float actaul = Empleado.calculoNominaNeta(Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra));
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		
		tipo = TipoEmpleado.Vendedor;
		horasExtra = 1;
		ventasMes = 1000;
		
		float expected = (float) 1810.5;
		float actaul = Empleado.calculoNominaNeta(Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra));
		
		assertEquals(expected,actaul);
	}
	
	@Test
	void testCalculoNominaNetaMayor2500() {
		
		tipo = TipoEmpleado.Encargado;
		horasExtra = 0;
		ventasMes = 1000;
		
		float expected = 2132;
		float actaul = Empleado.calculoNominaNeta(Empleado.calculaNominaBruta(tipo, ventasMes, horasExtra));
		
		assertEquals(expected,actaul);
	}

}