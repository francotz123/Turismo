package Turismo.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import Turismo.Atraccion;
import Turismo.Producto;

public class LeerAtraccion extends Producto {
	static ArrayList<Atraccion> atraccionList = new ArrayList<Atraccion>(); 
	
	public  ArrayList<Atraccion> getAtraccion(String file ) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(file));
		sc.useLocale(Locale.ENGLISH);
		
		while(sc.hasNext()) {
			String nombre = sc.next();
			Integer costoVisita = sc.nextInt();
			Double promedioTiempo = sc.nextDouble();
			Integer cupoVisitantes = sc.nextInt();
			String tipoAtraccion= sc.next();
			Atraccion nuevaAtraccion = new Atraccion(nombre, costoVisita, promedioTiempo, cupoVisitantes, tipoAtraccion);
			atraccionList.add(nuevaAtraccion);
		}
		sc.close();
		return atraccionList;
	}
	
	
	public void leerAtracciones() {
		for (Atraccion atraccion : atraccionList) {
			System.out.println(atraccion);
		}
	}
	public void generarLista() throws FileNotFoundException {
		atraccionList = this.getAtraccion("atracciones.in");
	}


	public static ArrayList<Atraccion> getAtraccionList() {
		return atraccionList;
	}





	
	
	
}
