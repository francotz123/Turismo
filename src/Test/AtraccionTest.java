package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Turismo.Atraccion;
import Turismo.Promocion;
import Turismo.PromocionPorcentual;
import Turismo.Usuario;

class TurismoTest {

	/*---------------------TEST CLASS ATRACCION-----------------------*/
	@Test
	void testAtraccionPuedeSeguirComprando() {
		Usuario usuario1 = new Usuario("Juan", 25, 3.0, "Paisaje");
		Atraccion atraccion = new Atraccion("Atraccion1", 25, 2.0 , 12, "Paisaje");
		boolean esperado = true;
		assertEquals(esperado, atraccion.puedeComprar(usuario1.getPresupuesto())); ;
	}
	
	@Test
	void testAtraccionTiempoDisponible() {
		Usuario usuario1 = new Usuario("Juan", 25, 3.0, "Paisaje");
		Atraccion atraccion = new Atraccion("Atraccion1", 25, 2.0 , 12, "Paisaje");
		boolean esperado = true;
		assertEquals(esperado, atraccion.tiempoDisponible(usuario1.getTimpoDisponible()));
	}

	/*---------------------TEST CLASS PROMOCION-----------------------*/
	
	@Test
	void testPromocionPuedeSeguirComprando() {
		Usuario usuario1 = new Usuario("Juan", 25, 3.0, "Paisaje");
		Atraccion atraccion = new Atraccion("Atraccion1", 25, 2.0 , 12, "Paisaje");
		ArrayList<Atraccion> nombreAtraccion = new ArrayList<Atraccion>();
		nombreAtraccion.add(atraccion);
		PromocionPorcentual promo1 = new PromocionPorcentual(nombreAtraccion, 1,"Promo1" , 20);
		boolean esperado = true;
		assertEquals(esperado, promo1.puedeComprar(usuario1.getPresupuesto())) ;
	}
}
