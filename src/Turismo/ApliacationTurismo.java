package Turismo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Turismo.Controllers.LeerUsuario;
import Turismo.Controllers.LeerAtraccion;
import Turismo.Controllers.LeerPromocion;


public class ApliacationTurismo {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		LeerUsuario usuarios = new LeerUsuario();
		usuarios.generarLista();
		LeerAtraccion atracciones = new LeerAtraccion();
		atracciones.generarLista();
		LeerPromocion promociones = new LeerPromocion();
		promociones.generarLista();
		for (Usuario users : LeerUsuario.getUserList()) {
			System.out.println("Bienvenido "+users.getNombre()+"!\n");
			ofrecerAtracciones(users, LeerAtraccion.getAtraccionList(), LeerPromocion.getPromocionList());
			
			System.out.println("--------------");
			
		}
		
	}
	
	public static void ofrecerAtracciones(Usuario user, ArrayList<Atraccion> atracciones, ArrayList<Promocion> promociones ) {
		user.sugerirOpciones(atracciones,promociones);
	}
}
