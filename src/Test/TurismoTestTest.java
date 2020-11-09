package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Turismo.Atraccion;
import Turismo.Promocion;
import Turismo.PromocionPorcentual;
import Turismo.Usuario;

class TurismoTestTest {

	@Test
	void testPuedeComprarAtraccion() {
		boolean esperado = true;
		Usuario user = new Usuario("Pepe", 20, 5.0, "Aventura");
		Atraccion atraccion = new Atraccion("Atraccion1", 5, 2.0, 10, "Aventura");
		assertEquals(esperado, atraccion.puedeComprar(user.getPresupuesto()));
	}
	
	void testTieneTiempoAtraccion() {
		boolean esperado = true;
		Usuario user = new Usuario("Pepe", 20, 5.0, "Aventura");
		Atraccion atraccion = new Atraccion("Atraccion1", 5, 2.0, 10, "Aventura");
		assertEquals(esperado, atraccion.tiempoDisponible(user.getTimpoDisponible()));
	}
	
	void testPuedeComprarPromocion() {
		boolean esperado = true;
		ArrayList<Atraccion> listAtracciones = new ArrayList<Atraccion>();
		Atraccion atraccion = new Atraccion("Atraccion1", 5, 2.0, 10, "Aventura");
		listAtracciones.add(atraccion);
		PromocionPorcentual promocion1 = new PromocionPorcentual(listAtracciones, 1, "Promo1", 20);
		Usuario user = new Usuario("Pepe", 20, 5.0, "Aventura");
		
		assertEquals(esperado, promocion1.puedeComprar(user.getPresupuesto()));
	}
	
	void testTieneTiempoPromocion() {
		boolean esperado = true;
		ArrayList<Atraccion> listAtracciones = new ArrayList<Atraccion>();
		Atraccion atraccion = new Atraccion("Atraccion1", 5, 2.0, 10, "Aventura");
		listAtracciones.add(atraccion);
		PromocionPorcentual promocion1 = new PromocionPorcentual(listAtracciones, 1, "Promo1", 20);
		Usuario user = new Usuario("Pepe", 20, 5.0, "Aventura");
		
		assertEquals(esperado, promocion1.tiempoDisponible(user.getTimpoDisponible()));
	}

}
