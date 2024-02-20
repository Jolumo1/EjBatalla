package pack;

import java.util.Random;

public class Banda {

	// Creamos la clase Banda, que tiene como atributos un nombre de Banda aleatorio
	// que se elige de una lista en un array en el momento de la generación del
	// objeto Banda y otro atributo que es un array de objetos Individuo, para
	// llenarlos con los dos tipos de soldado que hemos creado

	protected String nombre;
	protected Individuos[] soldados;

	// Constructor
	public Banda(Individuos[] soldados) {
		Random aleatorio = new Random();

		String[] nombresBandas = { "Los Zetas", "Cártel de Sinaloa", "Cártel del Golfo", "Los Caballeros Templarios",
				"Cártel de Juárez", "La Mara Salvatrucha (MS-13)", "Cártel de Tijuana", "Mafia Siciliana",
				"Cosa Nostra", "Las Triadas Chinas", "Cártel de Cali", "La Yakuza", "Cártel de Medellín", "Hells Angels",
				"La Camorra", "Son of Anarchy", "Cobra Kai", "Los Vengadores", "Los Pepes",
				"Los Hermanos Dalton" };

		this.nombre = nombresBandas[aleatorio.nextInt(20)];
		this.soldados = soldados;

	}

	public void moverSoldados() {
		Random aleatorio = new Random();
		int NuevaPosicionLanzaCohetes;
			
		
		System.out.println("Los supervivientes de \033[31m" + nombre  + "\033[30m se están rehubicando...");
		

		for (int i = 0; i < soldados.length; i++) {
			// recorremos el array de soldados y verificamos si esta vivo
			if (soldados[i].getVida() > 0) {
				// Si es francotirador se saca un num aleatorio entre 1 y 10 y se modifica su
				// posicion a ese numero.
				if (soldados[i] instanceof Francotirador) {
					((Francotirador) soldados[i]).setPosicion(aleatorio.nextInt(10) + 1);

					// si es lanzacohetes, se tira un aleatorio que elige si se suma o se resta el
					// num aleatorio a su posicion actual.
				} else if (soldados[i] instanceof LanzaCohetes) {

					if (aleatorio.nextInt(2) == 0) {

						NuevaPosicionLanzaCohetes = ((LanzaCohetes) soldados[i]).getPosicion() + aleatorio.nextInt(10)
								+ 1;

					} else {
						NuevaPosicionLanzaCohetes = ((LanzaCohetes) soldados[i]).getPosicion() - aleatorio.nextInt(10)
								+ 1;
					}
					// Si la nueva posición es mayor a 10 o menor a 1, se queda como estaba.
					if (NuevaPosicionLanzaCohetes > 10 || NuevaPosicionLanzaCohetes < 1) {
						NuevaPosicionLanzaCohetes = soldados[i].getPosicion();

					}
					// cargamos en el objeto la nueva posicion tras todas las comprobaciones.
					((LanzaCohetes) soldados[i]).setPosicion(NuevaPosicionLanzaCohetes);

				}

			}

		}

	}

	public boolean bandaFrita() {
		// metodo que devuelve un booleano si todos los soldados de una banda han muerto
		for (int i = 0; i < soldados.length; i++) {
			if (soldados[i].getVida() > 0) {
				return false;
			}

		}

		return true;

	}

	// Metodo para imprimir los soldados vivos de una banda.
	public void mostrarBanda() {

		System.out.println();
		System.out.println("================== \033[34m BANDA: \033[31m" + nombre.toUpperCase() + "\033[30m==================");

		for (int i = 0; i < soldados.length; i++) {

			if (soldados[i].getVida() != 0) {

				System.out.println(soldados[i]);
			}
		}
		System.out.println();
	}

	public String getNombre() {

		return "\033[31m" + nombre.toUpperCase() + "\033[30m";
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
