package Turismo;

import java.util.ArrayList;


public abstract class Promocion extends Producto {
	ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	String nombre;
	Integer tipo = 0;
	String nombresAtraccion = " ";
	
	
	public Promocion(ArrayList<Atraccion> nombreAtraccion, Integer tipo, String nombre) {
		this.atracciones.addAll(nombreAtraccion);
		this.tipo = tipo;
		this.nombre = nombre;
	}

	public abstract void beneficios() ;

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

}
