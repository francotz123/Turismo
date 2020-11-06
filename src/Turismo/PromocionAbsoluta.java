package Turismo;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {
	
	 Integer total= 0;
	
	public PromocionAbsoluta(ArrayList<Atraccion> nombreAtraccion, Integer tipo, String nombre, Integer total) {
		super(nombreAtraccion, tipo, nombre);
		this.total = total;
	}

	@Override
	public void beneficios() {
	
	}

	
	@Override
	public String toString() {
		for (Atraccion atraccion : atracciones) {
		nombresAtraccion +=  atraccion.getNombre()+" ";
		}
		return "Pack " + nombre + ", tipo=" + tipo + ", nombresAtraccion="
				+ nombresAtraccion + "precio ="+total ;
	}

	public Integer getDescuento() {
		return total;
	}
}
