package Turismo;

import java.util.ArrayList;


public abstract class Promocion extends Producto {
	
	ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	private String nombre;
	private Integer tipo = 0;

	private String nombresAtraccion="";
	Integer totalPagar = 0;
	Double tiempoTotal = 0.0 ;



	public Promocion(ArrayList<Atraccion> nombreAtraccion, Integer tipo, String nombre) {
		this.atracciones.addAll(nombreAtraccion);
		this.tipo = tipo;
		this.nombre = nombre;
	}

	public abstract void beneficios();

	public boolean puedeComprar(int presupuesto) {
		return this.getTotalPagar()<= presupuesto;	
	}
	
	public boolean tiempoDisponible(Double tiempoUser) {
		return this.getTiempoTotal() <= tiempoUser;
	}

	public void tiempoTotal() {
		for (Atraccion atraccion : this.getAtracciones()) {
			this.tiempoTotal+= atraccion.getPromedioTiempo();
		}
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Integer getTipo() {
		return tipo;
	}

	public String getNombresAtraccion() {
		this.nombresAtraccion="";
		for (Atraccion atraccion : atracciones) {
			this.nombresAtraccion +=  atraccion.getNombre()+", ";
		}
		return nombresAtraccion;
	}

	public Integer getTotalPagar() {
		return totalPagar;
	}

	public Double getTiempoTotal() {
		return tiempoTotal;
	}


}
