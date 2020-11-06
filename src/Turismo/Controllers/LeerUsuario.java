package Turismo.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import Turismo.Usuario;

public class LeerUsuario {
	
	static ArrayList<Usuario> userList = new ArrayList<Usuario>(); 
	
	private ArrayList<Usuario> getUsuarios(String file ) throws FileNotFoundException{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Scanner sc = new Scanner(new File(file));
		sc.useLocale(Locale.ENGLISH);
		while(sc.hasNext()) {
			String nombre = sc.next();
			Integer presupuesto = sc.nextInt();
			Double tiempo = sc.nextDouble();
			String lugarFav= sc.next();
			Usuario nuevoUsuario = new Usuario(nombre, presupuesto, tiempo, lugarFav);
			usuarios.add(nuevoUsuario);
		}
		sc.close();
		return usuarios;
	}
	
	public void leerUsuarios() {
		for(int i = 0; i< userList.size();i++ ) {
			System.out.println(userList.get(i));
		}
	}
	public void generarLista() throws FileNotFoundException {
		userList = this.getUsuarios("C:/Users/ragon/OneDrive/Escritorio/SoyProgramador/Turismo/usuarios.in");
	}
	
}
