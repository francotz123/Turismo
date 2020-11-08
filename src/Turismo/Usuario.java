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
	
	private ArrayList<Atraccion> atraccionesConPreferencias = new ArrayList<Atraccion>();
	private ArrayList<Atraccion> atraccionesSinPrefenecias = new ArrayList<Atraccion>();
	private ArrayList<Atraccion> atraccionesCompradas = new ArrayList<Atraccion>();
	
	public Usuario(String nombre, int presupuesto, double timpoDisponible, String atraccionFav) { //CONSTRUCTOR
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.timpoDisponible = timpoDisponible;
		this.atraccionFav = atraccionFav;
	}

	@Override
	public String toString() { 
		return "Nombre: "+nombre+", Presupuesto: "+presupuesto+", TiempoDisponible: "+timpoDisponible+", AtraccionPreferida: "+atraccionFav;
	}
	
	
	
	/*--------------METODO QUE ELIGE QUE OPCIONES MOSTRAR, SI CON PREFERENCIAS O SIN PREFERENCIAS------------*/
	
	
	public void mostrarOpcion(ArrayList<Atraccion> atraccionesConPreferencias, ArrayList<Atraccion> atraccionesSinPref) {
		this.generarOpciones(atraccionesConPreferencias);
		if(this.seguirComprando()) {
			System.out.println("También te podemos ofrecer otras atracciones: \n");
			this.generarOpciones(atraccionesSinPref);
		}
		if(compro) {
			cerrarCompra(atraccionesCompradas);
		}
	}
	
	/*--------------RECIBE LA LISTA DE TODAS LAS ATRACCIONES Y BUSCA LAS QUE TENGAN PREFERENCIA CON EL USUARIO------------*/
	
	public void atraccionesOpcionales(ArrayList<Atraccion> listaAtracciones) {
		for (Atraccion atraccion : listaAtracciones) {
			if(atraccion.getTipoAtraccion().equals(this.getAtraccionFav()) && atraccion.getCostoVisita() <= this.getPresupuesto() 
					&& atraccion.getPromedioTiempo() <= this.getTimpoDisponible() ) {	
				atraccionesConPreferencias.add(atraccion);			
			}else {
				atraccionesSinPrefenecias.add(atraccion);
			}

		}
		Collections.sort(atraccionesSinPrefenecias, Collections.reverseOrder()); 	//ORDENA LAS LISTAS DE MAYOR A MENOR, POR PRECIO
		Collections.sort(atraccionesConPreferencias, Collections.reverseOrder());
		mostrarOpcion(atraccionesConPreferencias, atraccionesSinPrefenecias);
	}
	
	/*------------------METODO PARA GENERAR LISTAS QUE SE LE MOSTRARA AL USUARIO---------------------------------*/
	
	public void generarOpciones(ArrayList<Atraccion> atraccionesDisponibles) {
		Scanner sc;
		System.out.println("Tu estado actual es: Dinero: "+this.getPresupuesto()+", Tiempo: "+this.getTimpoDisponible()+" horas\n");
		
		for (Atraccion atraccion : atraccionesDisponibles) {
			if(atraccion.puedeComprar(this.getPresupuesto()) && atraccion.tiempoDisponible(this.getTimpoDisponible()) && this.seguirComprando()) {
				System.out.println(atraccion.toString() +"Deseas comprar? S/N");
				sc = new Scanner(System.in);
				String respuestaUser = sc.nextLine();
				if(respuestaUser.equals("S")) {
					this.compro = true;
					atraccionesCompradas.add(atraccion);
					this.presupuesto -= atraccion.getCostoVisita();
					this.timpoDisponible -= atraccion.getPromedioTiempo();
					System.out.println("Compraste: "+atraccion.getNombre());
					System.out.println("Tu estado actual es: Dinero: "+this.getPresupuesto()+", Tiempo: "+this.getTimpoDisponible()+" horas");

				}

			}
			
		}
	
	}
	
	

	/*--------------METODO PARA CERRAR COMPRA, MUESTRA RESUMEN DEL ITINERARIO Y GENERA ARCHIVO-----------------*/
	
	public void cerrarCompra(ArrayList<Atraccion> atraccionesCompradas) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        int totalPagar = 0;
        Double totalHoras = 0.0;
        String nombreFichero =this.getNombre()+" Compra.out";
        try
        {
            fichero = new FileWriter(nombreFichero);
            pw = new PrintWriter(fichero);
            
            for (Atraccion atraccion : atraccionesCompradas) {
				totalPagar += atraccion.getCostoVisita();
				totalHoras += atraccion.getPromedioTiempo();
			}
            pw.println("Total a pagar: " + totalPagar+"\n Total Horas: "+totalHoras);

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

	
}
