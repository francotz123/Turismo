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
		for(int i = 0; i< atraccionList.size();i++ ) {
		System.out.println(atraccionList.get(i).getNombre());
		}
	}
	public void generarLista() throws FileNotFoundException {
		atraccionList = this.getAtraccion("C:/Users/ragon/OneDrive/Escritorio/SoyProgramador/Turismo/atracciones.in");
	}


	public ArrayList<Atraccion> getAtraccionList() {
	
		return atraccionList;
	}





	
	
	
}