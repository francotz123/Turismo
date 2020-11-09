package Turismo;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class Usuario {
	private int presupuesto;
	private double timpoDisponible;
	private String atraccionFav;
	private String nombre;
	private boolean compro = false;
	private int presupuestoAux;
	private double timpoDisponibleAux;
	


	private ArrayList<Atraccion> atraccionesConPreferencias = new ArrayList<Atraccion>();
	private ArrayList<Atraccion> atraccionesSinPrefenecias = new ArrayList<Atraccion>();
	private ArrayList<Atraccion> atraccionesCompradas = new ArrayList<Atraccion>();
	private ArrayList<Promocion> promocionesConPreferencias = new ArrayList<Promocion>();
	private ArrayList<Promocion> promocionesSinPreferencias = new ArrayList<Promocion>();
	private ArrayList<Promocion> promocionesCompradas = new ArrayList<Promocion>();
	
	public Usuario(String nombre, int presupuesto, double timpoDisponible, String atraccionFav) { //CONSTRUCTOR
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.timpoDisponible = timpoDisponible;
		this.atraccionFav = atraccionFav;
		this.presupuestoAux = presupuesto;
		this.timpoDisponibleAux = timpoDisponible;
	}


	@Override
	public String toString() { 
		return "Nombre: "+nombre+", Presupuesto: "+presupuesto+", TiempoDisponible: "+timpoDisponible+", AtraccionPreferida: "+atraccionFav;
	}
	
	
	/*--------------RECIBE LA LISTA DE TODAS LAS ATRACCIONES Y PROMOCIONES, BUSCA LAS QUE TENGAN PREFERENCIA CON EL USUARIO------------*/
	
	public void sugerirOpciones(ArrayList<Atraccion> listaAllAtracciones, ArrayList<Promocion> listaAllPromociones) {
		boolean controller = true;
		
		for (Atraccion atraccion : listaAllAtracciones) {
			if(atraccion.getTipoAtraccion().equals(this.getAtraccionFav()) && atraccion.getCostoVisita() <= this.getPresupuesto() 
					&& atraccion.getPromedioTiempo() <= this.getTimpoDisponible() ) {	
				atraccionesConPreferencias.add(atraccion);			
			}else {
				atraccionesSinPrefenecias.add(atraccion);
			}

		}
		
		for (Promocion promocion : listaAllPromociones) {
			for (Atraccion atraccion : promocion.atracciones) {
				if(atraccion.getTipoAtraccion().equals(this.getAtraccionFav()) && controller == true ) {
					promocionesConPreferencias.add(promocion);
					controller=false;
				}
			}	
			if(controller == true ) {
				promocionesSinPreferencias.add(promocion);
			} 
			controller=true;
		}

		Collections.sort(atraccionesSinPrefenecias, Collections.reverseOrder()); 	//ORDENA LAS LISTAS DE MAYOR A MENOR, POR PRECIO
		Collections.sort(atraccionesConPreferencias, Collections.reverseOrder());
		
		this.mostrarOpcion(atraccionesConPreferencias, atraccionesSinPrefenecias);
	}
	
	
	/*--------------METODO QUE ELIGE QUE OPCIONES MOSTRAR, SI CON PREFERENCIAS O SIN PREFERENCIAS------------*/
	
	
	private void mostrarOpcion(ArrayList<Atraccion> atraccionesConPreferencias, ArrayList<Atraccion> atraccionesSinPref) {
		System.out.println("Tu estado actual es: Monedas: "+this.getPresupuesto()+", Tiempo: "+this.getTimpoDisponible()+" horas");
		this.mostrarPromociones(promocionesConPreferencias);
		this.mostrarAtracciones(atraccionesConPreferencias);
		if(this.seguirComprando()) {
			System.out.println("También te podemos ofrecer otras opciones: \n");
			this.mostrarPromociones(promocionesSinPreferencias);
			this.mostrarAtracciones(atraccionesSinPref);
		}
		if(compro) {
			cerrarCompra(atraccionesCompradas,promocionesCompradas );
		}else {
			System.out.println("Usted no realizó ninguna compra.");
		}
	}
	
	
	/*------------------SUGERIR ATRACCIONES---------------------------------*/
	
	public void mostrarAtracciones(ArrayList<Atraccion> atraccionesDisponibles) {
		Scanner sc;
		for (Atraccion atraccion : atraccionesDisponibles) {
			if(atraccion.puedeComprar(this.getPresupuesto()) && atraccion.tiempoDisponible(this.getTimpoDisponible()) && this.seguirComprando()) {
				System.out.println(atraccion.toString() +" Deseas comprar? S/N");
				sc = new Scanner(System.in);
				String respuestaUser = sc.nextLine();
				if(respuestaUser.equals("S")) {
					this.compro = true;
					this.atraccionesCompradas.add(atraccion);
					this.presupuesto -= atraccion.getCostoVisita();
					this.timpoDisponible -= atraccion.getPromedioTiempo();
					System.out.println("Compraste: "+atraccion.getNombre());
				}
			}
		}
	}
	
	/*--------------------SUGERIR PROMOCIONES ------------------------*/
	
	public void mostrarPromociones(ArrayList<Promocion> promocionesLista){
		Scanner sc;
		for (Promocion promocion : promocionesLista) {
			if(promocion.puedeComprar(this.getPresupuesto()) && promocion.tiempoDisponible(this.getTimpoDisponible()) &&
					this.seguirComprando()) {
				System.out.println(promocion.toString() +" Deseas comprar? S/N");
				sc = new Scanner(System.in);
				String respuestaUser = sc.nextLine();
				if(respuestaUser.equals("S")) {

					for (Atraccion atraccion : promocion.getAtracciones()) {
						if(this.atraccionesConPreferencias.contains(atraccion) ) {
							atraccionesConPreferencias.remove(atraccion);
						}else if( this.atraccionesSinPrefenecias.contains(atraccion)) {
							atraccionesSinPrefenecias.remove(atraccion);
						}
					}
					
					this.compro = true;
					this.promocionesCompradas.add(promocion);
					this.presupuesto -= promocion.getTotalPagar();
					this.timpoDisponible -= promocion.getTiempoTotal();
					System.out.println("Compraste: "+promocion.getNombre());
					System.out.println("Tu estado actual es: Dinero: "+this.getPresupuesto()+", Tiempo: "+this.getTimpoDisponible()+" horas");
				}
			}
		}
	}


	
	/*--------------METODO PARA CERRAR COMPRA, MUESTRA RESUMEN DEL ITINERARIO Y GENERA ARCHIVO-----------------*/
	
	public void cerrarCompra(ArrayList<Atraccion> atraccionesCompradas,ArrayList<Promocion> promocionCompradas) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        int totalPagar = 0;
        Double totalHoras = 0.0;
        String nombresPack = "";
        String nombresAtraccion = "";
        String nombreFichero =this.getNombre()+" Compra.out";
        try
        {
            fichero = new FileWriter(nombreFichero);
            pw = new PrintWriter(fichero);
            
            for (Atraccion atraccion : atraccionesCompradas) {
            	nombresAtraccion += atraccion.getNombre()+", ";
				totalPagar += atraccion.getCostoVisita();
				totalHoras += atraccion.getPromedioTiempo();
			}
            for (Promocion promocion : promocionCompradas) {
            	nombresPack += promocion.getNombre()+", ";
				totalPagar += promocion.getTotalPagar();
				totalHoras += promocion.getTiempoTotal();
			}
            pw.println("Usuario "+this.nombre+":"+"\nMonedas: "+this.getPresupuestoAux()+"\nTiempo disponible: "+this.getTimpoDisponibleAux()+"\nPreferencias: "
            		+this.getAtraccionFav()+"\nPacks Comprados:"+nombresPack+"\nAtracciones compradas: "+nombresAtraccion+"\nTotal a pagar: " + totalPagar+"\nTotal Horas: "+totalHoras);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        System.out.println("Compra realizada!\n");
        System.out.println("Las atracciones que usted compro son: \n");
        for (Atraccion atraccion : atraccionesCompradas) {
			System.out.println(atraccion+"\n");
		}
        System.out.println("Total a pagar: "+totalPagar);
        System.out.println("Cantidad de horas: "+totalHoras);
	}
	

	
	/*--------------BOOLEANO PARA COMPROBAR SI SE PUEDE SEGUIR COMPRANDO------------*/
	
	private boolean seguirComprando() {
		return ( this.getPresupuesto() > 0 && this.getTimpoDisponible() > 0);
	}
	
	
	/*----------------GETTERS Y SETTERS------------------*/
	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTimpoDisponible() {
		return timpoDisponible;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getAtraccionFav() {
		return atraccionFav;
	}
	
	public double getTimpoDisponibleAux() {
		return timpoDisponibleAux;
	}

	public int getPresupuestoAux() {
		return presupuestoAux;
	}
	
}
