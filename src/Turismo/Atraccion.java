package Turismo;

public class Atraccion extends Producto {
	private int costoVisita;
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
		
		return this.nombre+"; "+this.costoVisita+" ; "+this.promedioTiempo+" ; "+this.cupoVisitantes+"; "+this.tipoAtraccion;
	}
	

	public int getCostoVisita() {
		return costoVisita;
	}

	public void setCostoVisita(int costoVisita) {
		this.costoVisita = costoVisita;
	}

	public double getPromedioTiempo() {
		return promedioTiempo;
	}

	public void setPromedioTiempo(double promedioTiempo) {
		this.promedioTiempo = promedioTiempo;
	}

	public int getCupoVisitantes() {
		return cupoVisitantes;
	}

	public void setCupoVisitantes(int cupoVisitantes) {
		this.cupoVisitantes = cupoVisitantes;
	}

	public String getTipoAtraccion() {
		return tipoAtraccion;
	}
	public String getNombre() {
		return nombre;
	}

	public void setTipoAtraccion(String tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}
	
	
}
