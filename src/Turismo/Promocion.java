package Turismo;

import java.util.ArrayList;


public abstract class Promocion extends Producto {
	ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	private String nombre;
	private Integer tipo = 0;
	String nombresAtraccion=" ";
	
	public Promocion(ArrayList<Atraccion> nombreAtraccion, Integer tipo, String nombre) {
		this.atracciones.addAll(nombreAtraccion);
		this.tipo = tipo;
		this.nombre = nombre;
	}

	public abstract void beneficios() ;

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
		for (Atraccion atraccion : atracciones) {
			 nombresAtraccion +=  atraccion.getNombre()+", ";
			}
		return nombresAtraccion;
	}

}
