package Turismo;


import java.util.LinkedList;


public class Usuario {
	private int presupuesto;
	private double timpoDisponible;
	private String atraccionFav;
	private String nombre;
	
	public Usuario(String nombre, int presupuesto, double timpoDisponible, String atraccionFav) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.timpoDisponible = timpoDisponible;
		this.atraccionFav = atraccionFav;
	}

	@Override
	public String toString() {
		return "Nombre: "+nombre+", Presupuesto: "+presupuesto+", TiempoDisponible: "+timpoDisponible+", AtraccionPreferida: "+atraccionFav;
	}

	public  void leerAtracciones(LinkedList<Usuario> lista) {
		for(Usuario users:lista ) {
			System.out.println(users);
		}
	}
	
	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTimpoDisponible() {
		return timpoDisponible;
	}

	public void setTimpoDisponible(double timpoDisponible) {
		this.timpoDisponible = timpoDisponible;
	}

	public String getAtraccionFav() {
		return atraccionFav;
	}

	public void setAtraccionFav(String atraccionFav) {
		this.atraccionFav = atraccionFav;
	}
	
}
