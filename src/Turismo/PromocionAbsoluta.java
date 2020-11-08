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
		return "Pack " + super.getNombre()+ ", nombresAtraccion="
				+ super.getNombresAtraccion() + "precio = $"+this.getTotal() ;
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getDescuento() {
		return total;
	}
}
