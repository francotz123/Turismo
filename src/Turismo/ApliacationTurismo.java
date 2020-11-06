package Turismo;

import java.io.FileNotFoundException;
import Turismo.Controllers.LeerUsuario;
import Turismo.Controllers.LeerAtraccion;
import Turismo.Controllers.LeerPromocion;


public class ApliacationTurismo {

	
	public static void main(String[] args) throws FileNotFoundException {
		LeerUsuario usuarios = new LeerUsuario();
		usuarios.generarLista();
		usuarios.leerUsuarios();	
		System.out.println("--------------------------");
		LeerAtraccion atracciones = new LeerAtraccion();
		atracciones.generarLista();
		atracciones.leerAtracciones();	
		System.out.println("--------------------------");
		atracciones.getAtraccionList();
		LeerPromocion promociones = new LeerPromocion();
		promociones.generarLista();
		promociones.leerPromocionesPorc();
		System.out.println("--------------------------");
		
		promociones.leerPromocionesAbs();
		System.out.println("--------------------------");
		promociones.leerPromocionesAxB();
		
		
	}

}
