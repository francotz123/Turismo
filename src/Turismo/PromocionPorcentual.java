package Turismo;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {
	Integer descuento = 0;
	
	public PromocionPorcentual(ArrayList<Atraccion> nombreAtraccion, Integer tipo, String nombre, Integer descuento) {
		super(nombreAtraccion, tipo, nombre);
		if(descuento<= 100.0) {
			this.descuento = descuento;
		} else descuento = 0;
		this.beneficios();
		super.tiempoTotal();
	}


	@Override
	public void beneficios() {
		for (Atraccion atraccion : super.getAtracciones()) {
			super.totalPagar += atraccion.getCostoVisita();
		}
		
		this.descuento /= 100;
		super.totalPagar -= super.totalPagar*descuento;
	}
	
	@Override
	public String toString() {
		return  super.getNombre() + ", Las Atracciones que incluye son = "
				+super.getNombresAtraccion() + " tiempo que requiere: "+super.getTiempoTotal()+" horas. "+" Precio = $"+this.getTotalPagar()+" " ;
	}


	public Integer getDescuento() {
		return descuento;
	}


}
