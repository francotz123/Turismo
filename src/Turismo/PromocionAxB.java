package Turismo;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {
	ArrayList<Atraccion> atraccionFree;
	ArrayList<Atraccion> nombresFree;
	String nombresFrees = " ";

	private Double totalPagar = 0.0;
	public PromocionAxB(ArrayList<Atraccion> nombreAtraccion, Integer tipo, String nombre,ArrayList<Atraccion> atraccionFree) {
		super(nombreAtraccion, tipo, nombre);
		this.atraccionFree = atraccionFree;
		this.beneficios();
	}

	@Override
	public void beneficios() {
		Double descuento = 0.0;
		for (Atraccion atraccion : super.getAtracciones()) {
			this.totalPagar += atraccion.getCostoVisita();
		}
		for (Atraccion atraccion :atraccionFree) {
			descuento += atraccion.getCostoVisita();
			nombresFrees += atraccion.getNombre()+", ";
			
		}
		this.totalPagar -=descuento ;
	}
	
	@Override
	public String toString() {
		return "Pack: " + super.getNombre() + "- Atracciones que incluye: "+super.getNombresAtraccion()+" obten gratis "+this.getNombresFrees()+" total a pagar: $"+this.getTotalPagar();
	}

	public String getNombresFrees() {
		return nombresFrees;
	}

	public Double getTotalPagar() {
		return totalPagar;
	}

}
