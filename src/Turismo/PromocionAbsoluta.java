package Turismo;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {
	
	 Integer total= 0;
	
	public PromocionAbsoluta(ArrayList<Atraccion> nombreAtraccion, Integer tipo, String nombre, Integer total) {
		super(nombreAtraccion, tipo, nombre);
		super.totalPagar = total;
		super.tiempoTotal();
	}

	@Override
	public void beneficios() {
	
	}

	


	public Integer getTotal() {
		return total;
	}

	public Integer getDescuento() {
		return total;
	}
	
	
	@Override
	public String toString() {
		return "Pack " + super.getNombre()+ ", nombresAtraccion="
				+ super.getNombresAtraccion() + " tiempo que requiere: "+super.getTiempoTotal()+" horas. "+ "precio = $"+super.getTotalPagar();
	}

}
