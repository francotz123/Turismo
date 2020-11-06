package Turismo;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {

	public PromocionAxB(ArrayList<Atraccion> nombreAtraccion, Integer tipo, String nombre) {
		super(nombreAtraccion, tipo, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void beneficios() {
		Double benef= 0.0;
		for (Atraccion atraccion : super.getAtracciones()) {
			benef += atraccion.getCostoVisita();
		}

	}
	
	@Override
	public String toString() {
		for (Atraccion atraccion : atracciones) {
		nombresAtraccion +=  atraccion.getNombre()+" ";
		}
		return "Pack " + nombre + ", tipo=" + tipo + ", nombresAtraccion="
				+ nombresAtraccion + "precio =" ;
	}


}
