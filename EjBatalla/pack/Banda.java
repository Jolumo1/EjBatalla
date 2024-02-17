package pack;

import java.util.Arrays;
import java.util.Random;

public class Banda {

	// Creamos la clase Banda, que tiene como atributos un nombre de Banda aleatorio
	// que se elige de una lista en un array en el momento de la generación del
	// objeto Banda y otro atributo que es un array de objetos Individuo, para
	// llenarlos con los dos tipos de soldado que hemos creado

	public String nombre;
	public Individuos[] soldados;

	
	//Constructor
	public Banda(Individuos[] soldados) {
		Random aleatorio = new Random();

		String[] nombresBandas = { "Los Zetas", "Cártel de Sinaloa", "Cártel del Golfo", "Los Caballeros Templarios",
				"Cártel de Juárez", "La Mara Salvatrucha (MS-13)", "Cártel de Tijuana", "Cártel de los Beltrán Leyva",
				"Barrio Azteca", "Los Urabeños", "Cártel de Cali", "Los Rastrojos", "Cártel de Medellín", "Los Rudos",
				"La Unión Tepito", "Cártel de los Soles", "Los Tucanes de Tijuana", "Los Pelones", "Los Pepes",
				"Los Zodíaco" };

		this.nombre = nombresBandas[aleatorio.nextInt(20)];
		this.soldados = soldados;

	}

	
	public boolean bandaFrita() {
		//metodo que devuelve un booleano si todos los soldados de una banda han muerto
		for (int i = 0; i < soldados.length; i++) {
			if (soldados[i].getVida() > 0){
				return false;
			}

		}

		return true;

	}
	
	
	
	
	//Metodo para imprimir los soldados vivos de una banda.
	public void mostrarBanda() {

		System.out.println();
		System.out.println("\033[34m BANDA: \033[31m" + this.nombre.toUpperCase() + "\033[30m");

		for (int i = 0; i < soldados.length; i++) {

			if (soldados[i].getVida() != 0) {

				System.out.println(soldados[i]);
			}
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Individuos[] getSoldados() {
		return soldados;
	}

	public void setSoldados(Individuos[] soldados) {
		this.soldados = soldados;
	}

	
	
	
	
}
