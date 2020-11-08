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
	static ArrayList<Atraccion> atraccionFree = new ArrayList<Atraccion>();

	public void getPromocion(String file) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(file));
		sc.useLocale(Locale.ENGLISH);
		String control= "-"; 			// controlador de fin de linea, significando que lo siguiente es otra promocion
		String controlGratis= ","; 		// Sstring necesario para identifcar donde la atraccion gratis, en el caso de promocion AxB
		Double descuento = 0.0; 		//Booleano con el descuento en las promociones porcentuales
		Integer total = 0;				//interger con el total a pagar en las promociones absolutas
		String atraccionGratis =""; 
		
		while(sc.hasNext()) {
			boolean seguir = true;
			Integer tipo = sc.nextInt();
			String nombre = sc.next();
			
			if(tipo == 1) {						//Dependiento el tipo de promocion, lo que lee es el descuento (porcentual) o el monto total (absoluto) 
				 descuento = sc.nextDouble();
			}else if(tipo == 2){
				total = sc.nextInt();
			}
			
			while(seguir){
				String nombre1 = sc.next();					//si no se guarda en una variable, cada vez que se usa next(), no se puede volver a utilizar lo que lea
				if(nombre1.equals(controlGratis)) {			// si el string que leyó, es igual al controladorGratis (,), quiere decir que lo que sigue es la atraccion gratis 	
					atraccionGratis= sc.next();		
				}
				for (Atraccion atraccion : LeerAtraccion.atraccionList) {	//Buscamos en toda la lista de atracciones, las atracciones que coinciden con las de las promociones
					//System.out.println(atraccion.getNombre());
					if(atraccion.getNombre().equals(nombre1)) {		
					atraccionPromocion.add(atraccion);
					}
					if(atraccion.getNombre().equals(atraccionGratis)) {		//Buscamos la atraccion que encontramos gratis en la promocion	
						atraccionFree.add(atraccion);	
						atraccionGratis="";
					}
				}
				
				if(nombre1.equals(control)) {	// si encontramos el control "-", dejamos de seguir buscando
					seguir = false;
					nombre1 = "";
				}
			}
			
			switch(tipo) {
			case 1:
				
				PromocionPorcentual packAventura = new PromocionPorcentual(atraccionPromocion, tipo,nombre,descuento);
				promocionList.add(packAventura);
				
				break;
			case 2:
				PromocionAbsoluta packDegustacion = new PromocionAbsoluta(atraccionPromocion, tipo,nombre,total);
				promocionList.add(packDegustacion);
				break;
			case 3:
				PromocionAxB packPaisaje = new PromocionAxB(atraccionPromocion, tipo,nombre,atraccionFree);
				promocionList.add(packPaisaje);
				break;
			}
			atraccionPromocion.clear();
			atraccionFree.clear();
		}
		sc.close();
	}
	
	public void generarLista() throws FileNotFoundException {
		getPromocion("promociones.in");
	}
	
	public void leerPromociones() {
		for (Promocion promocion : promocionList) {
			System.out.println(promocion.toString());
		}	
	}
	
}
