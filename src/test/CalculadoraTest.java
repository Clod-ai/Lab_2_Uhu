package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Pakete.Calculadora;

class CalculadoraTest {
	
	private int value1;
	private int value2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each");
		value1 = 6;
		value2 = 3;
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each");
	}

	@Test
	void testSuma() {
		int expected = 9;
		int actual=Calculadora.suma(value1,value2);
		assertEquals(expected,actual);
	}

	@Test
	void testResta() {
		int expected = 3;
		int actual=Calculadora.resta(value1,value2);
		assertEquals(expected,actual);
	}

	@Test
	void testMultiplicacion() {
		int expected = 18;
		int actual=Calculadora.multiplicacion(value1,value2);
		assertEquals(expected,actual);
	}

	@Test
	void testDivide() {
		int expected = 2;
		int actual=Calculadora.divide(value1,value2);
		assertEquals(expected,actual);
	}
	
	@Test
	void testDividePor0() {
		int expected = -1;
		value2 =0;
		int actual=Calculadora.divide(value1,value2);
		assertEquals(expected,actual);
	}

}
