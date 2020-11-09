package Turismo;

public class Atraccion extends Producto implements Comparable<Atraccion> {
	
	private Integer costoVisita;
	private double promedioTiempo;
	private int cupoVisitantes;
	private String tipoAtraccion;
	private String nombre;

	
	public Atraccion(String nombre, int costoVisita, double promedioTiempo, int cupoVisitantes, String tipoAtraccion) {
		this.nombre = nombre;
		this.costoVisita = costoVisita;
		this.promedioTiempo = promedioTiempo;
		this.cupoVisitantes = cupoVisitantes;
		this.tipoAtraccion = tipoAtraccion;
	}
	
	public String toString() {
		
		return "Nombre atraccion: "+this.nombre+"\nCosto: "+this.costoVisita+"\nTiempo que requiere: "+this.promedioTiempo+"\nCupo total: "+this.cupoVisitantes+"\nTipo de atraccion: "+this.tipoAtraccion+"\n\r";
	}
	
	public boolean puedeComprar(int presupuesto) {
		return this.getCostoVisita() <= presupuesto;	
	}
	
	public boolean tiempoDisponible(Double tiempoUser) {
		return this.getPromedioTiempo() <= tiempoUser;
	}

	public int getCostoVisita() {
		return costoVisita;
	}

	public double getPromedioTiempo() {
		return promedioTiempo;
	}
	
	public int getCupoVisitantes() {
		return cupoVisitantes;
	}

	public String getTipoAtraccion() {
		return tipoAtraccion;
	}
	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Atraccion t) {
		return costoVisita.compareTo(t.getCostoVisita());
	}

}
