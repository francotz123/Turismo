package Turismo.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import Turismo.Atraccion;
import Turismo.Producto;
import Turismo.Promocion;
import Turismo.PromocionAbsoluta;
import Turismo.PromocionAxB;
import Turismo.PromocionPorcentual;


public class LeerPromocion extends Producto {
	
	static ArrayList<Promocion> promocionList = new ArrayList<Promocion>();
	static ArrayList<Atraccion> atraccionPromocion = new ArrayList<Atraccion>();
	static ArrayList<PromocionPorcentual> promocionesPorc = new ArrayList<PromocionPorcentual>();
	static ArrayList<PromocionAbsoluta> promocionesAbs = new ArrayList<PromocionAbsoluta>();
	static ArrayList<PromocionAxB> promocionesAxB = new ArrayList<PromocionAxB>();
	static ArrayList<Atraccion> atraccionFree = new ArrayList<Atraccion>();

	public void getPromocion(String file) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(file));
		sc.useLocale(Locale.ENGLISH);
		String control= "-";
		String controlGratis= ",";
		Double descuento = 0.0;
		Integer total = 0;
		String atraccionGratis ="";
		
		while(sc.hasNext()) {
			boolean seguir = true;
			Integer tipo = sc.nextInt();
			String nombre = sc.next();
			
			if(tipo == 1) {
				 descuento = sc.nextDouble();
			}else if(tipo == 2){
				total = sc.nextInt();
			}
			while(seguir){
				String nombre1 = sc.next();
				if(nombre1.equals(controlGratis)) {
					atraccionGratis= sc.next();
				}
				for (Atraccion atraccion : LeerAtraccion.atraccionList) {
					//System.out.println(atraccion.getNombre());
					if(atraccion.getNombre().equals(nombre1)) {		
					atraccionPromocion.add(atraccion);
					}
					if(atraccion.getNombre().equals(atraccionGratis)) {		
						atraccionFree.add(atraccion);
						atraccionGratis="";
						}
				}
				
				if(nombre1.equals(control)) {
					seguir = false;
					nombre1 = "";
				}
			}
			
			switch(tipo) {
			case 1:
				
				PromocionPorcentual packAventura = new PromocionPorcentual(atraccionPromocion, tipo,nombre,descuento);
				promocionesPorc.add(packAventura);
				break;
			case 2:
				PromocionAbsoluta packDegustacion = new PromocionAbsoluta(atraccionPromocion, tipo,nombre,total);
				promocionesAbs.add(packDegustacion);
				break;
			case 3:
				PromocionAxB packPaisaje = new PromocionAxB(atraccionPromocion, tipo,nombre,atraccionFree);
				promocionesAxB.add(packPaisaje);
				break;
			}
			atraccionPromocion.clear();
			atraccionFree.clear();
		}
		sc.close();
	}
	
	public void generarLista() throws FileNotFoundException {
		getPromocion("C:/Users/ragon/OneDrive/Escritorio/SoyProgramador/Turismo/promociones.in");
	}
	
	public void leerPromocionesPorc() {
		for (PromocionPorcentual atraccion : promocionesPorc) {
			System.out.println(atraccion);
		}
	}
	
	public void leerPromocionesAbs() {
		for (PromocionAbsoluta atraccion : promocionesAbs) {
			System.out.println(atraccion);
		}
	}
		public void leerPromocionesAxB() {
			for (PromocionAxB atraccion : promocionesAxB) {
				System.out.println(atraccion);
			}
			
	}
}
