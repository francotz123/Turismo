package Turismo;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {
	Double descuento = 0.0;
	Double totalPagar = 0.0;
	public PromocionPorcentual(ArrayList<Atraccion> nombreAtraccion, Integer tipo, String nombre, Double descuento) {
		super(nombreAtraccion, tipo, nombre);
		if(descuento<= 100.0) {
			this.descuento = descuento;
		} else descuento = 0.0;
		this.beneficios();
	}

	@Override
	public void beneficios() {
		for (Atraccion atraccion : super.getAtracciones()) {
			this.totalPagar += atraccion.getCostoVisita();
		}
		
		this.descuento /= 100;
		this.totalPagar -= this.totalPagar*descuento;
	}
	
	@Override
	public String toString() {
		return "Pack: " + super.getNombre() + ", Las Atracciones que incluye son = "
				+super.getNombresAtraccion() + " precio = $"+this.getTotalPagar() ;
	}

	public Double getTotalPagar() {
		return totalPagar;
	}

	public Double getDescuento() {
		return descuento;
	}

}
