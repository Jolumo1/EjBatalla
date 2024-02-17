package pack;

import java.util.Random;

public class Batalla {

	public static void main(String[] args) {
		Random aleatorio = new Random();
		boolean finJuego = false;
		int ronda = 1, primero = 0;

		// Creamos dos arrays de objetos Banda y los cargamos de Soldados mediante el
		// método crearSoldado
		Banda banda1 = new Banda(crearSoldados());
		Banda banda2 = new Banda(crearSoldados());

		// Listamos las bandas

		System.out.println("ESTAS SON LAS BANDAS ENFRENTADAS:");
		banda1.mostrarBanda();
		System.out.println();
		banda2.mostrarBanda();

		// Tiramos una moneda para ver quien empieza

		primero = aleatorio.nextInt(2);

		//segun el resultado se aplica un case u otro

		switch (primero) {

		    case 0:

		        System.out.println();
		        System.out.println("Empieza " + banda1.nombre);

		        do {
		            System.out.println("RONDA " + ronda);

		            alAtaque(banda1, banda2);
		            alAtaque(banda2, banda1);

		            banda1.mostrarBanda();
		            System.out.println();
		            banda2.mostrarBanda();

		            finJuego = bandaMuerta(banda1, banda2);

		            ronda++;
		        } while (finJuego==false);

		        break;

		    case 1:
		        
		        
		        System.out.println();
		        System.out.println("Empieza " + banda2.nombre);

		        do {
		            System.out.println("RONDA " + ronda);
		            alAtaque(banda2, banda1);
		            alAtaque(banda1, banda2);

		            System.out.println();
		            System.out.println("Estos son los supervivientes ");
		            System.out.println();
		            
		            
		            banda1.mostrarBanda();
		            System.out.println();
		            banda2.mostrarBanda();

		            
		            finJuego = bandaMuerta(banda1, banda2);
		            
		            ronda++;
		        } while (finJuego==false);

		        break;

		    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	} // -----------------------------------FIN_MAIN------------------------------------------------------

	public static boolean bandaMuerta(Banda banda1, Banda banda2) {

		if (banda1.bandaFrita()) {
			System.out.println();
			System.out.println("La banda " + banda1.nombre + " ha sido aniquilada");
			System.out.println();
			System.out.println("Gana la banda " + banda2.nombre);
			System.out.println();
			return true;
		} else if (banda2.bandaFrita()) {
			System.out.println();
			System.out.println("La banda " + banda2.nombre + " ha sido aniquilada");
			System.out.println();
			System.out.println("Gana la banda " + banda1.nombre);
			System.out.println();
			return true;
		} else {
			System.out.println();
			System.out.println("Aun hay soldados en pie, que siga el combate!");
			System.out.println();
			
			return false;
		}

	}

	public static void alAtaque(Banda bandaAtaca, Banda bandaRecibe) {
		Random aleatorio = new Random();
		int plantaAtacada, vidaRestante, valorAtaque;

		// Metodo para atacar

		for (int i = 0; i < bandaAtaca.soldados.length; i++) {
			// recorremos el array de atacantes y verificamos si esta vivo
			if (bandaAtaca.soldados[i].getVida() > 0) {
// Si el atacante es francotirador, obtenemos su nivel de ataque
				if (bandaAtaca.soldados[i] instanceof Francotirador) {
					valorAtaque = ((Francotirador) bandaAtaca.soldados[i]).getDanio();

					for (int j = 0; j < bandaRecibe.soldados.length; j++) {
						// Comparamos el francotirador con todo el array de banda que recibe el ataque y
						// comparamos la posicion
						if (bandaAtaca.soldados[i].getPosicion() == bandaRecibe.soldados[j].getPosicion()) {

							vidaRestante = bandaRecibe.soldados[j].getVida();
							// obtenemos el valor de vida que le queda al soldado que esta en la misma
							// posicion y le restamos el valor del ataque.
							bandaRecibe.soldados[j].setVida(vidaRestante - valorAtaque);
						}
					}
//Aqui si el atacante es Lanzacohetes, obtenemos su nivel de alcance
				} else if (bandaAtaca.soldados[i] instanceof LanzaCohetes) {

					int alcanceSoldado = ((LanzaCohetes) bandaAtaca.soldados[i]).getAlcance();

					if (aleatorio.nextInt(2) == 0) {
						// Tiramos una moneda, si sale 0, el ataque es hacia arriba y se suma el alcance
						// a un numero aleatorio que determina la planta.
						// Si sale 1 es negativo y restamos el alcance al numero aleatorio.

						plantaAtacada = (aleatorio.nextInt(10) + 1) + alcanceSoldado;

					} else {
						plantaAtacada = (aleatorio.nextInt(10) + 1) - alcanceSoldado;

					}
					// Con esto verificamos que el resultado no se pase de 10 o este por debajo de
					// 1, si es así la planta atacada es igual a la posicion donde esta el soldado

					if (plantaAtacada > 10 || plantaAtacada < 1) {
						plantaAtacada = bandaAtaca.soldados[i].getPosicion();

					}

					// Recorremos el array de la banda que recibe el ataque, poniendo a 0 la vida de
					// todos los soldados cuya posicion sea igual al valor de plantaAtacada.
					for (int j = 0; j < bandaRecibe.soldados.length; j++) {

						if (bandaRecibe.soldados[j].getPosicion() == plantaAtacada) {
							bandaRecibe.soldados[j].vida = 0;

						}
					}

				}

			}

		}
	}

	public static Individuos[] crearSoldados() {
		// creamos el array de soldados que rellenara la banda.
		Random aleatorio = new Random();

		Individuos soldados[] = new Individuos[15];

		// Se va rellenando una posicion del array soldados en funcion de si sale 1 o 0
		// en un aleatorio, poniedno asi Francotiradores o lanzacohetes, hasta llenar el
		// array.

		for (int i = 0; i < soldados.length; i++)
			if (aleatorio.nextInt(2) == 0) {
				soldados[i] = crearFrancotirador();
			} else {
				soldados[i] = crearLanzaCohetes();
			}

		return soldados;

	}

	public static Francotirador crearFrancotirador() {
		// crea un objeto Francotirador
		Francotirador SoldadoFrancotirador = new Francotirador();

		return SoldadoFrancotirador;

	}

	public static LanzaCohetes crearLanzaCohetes() {
		// crea un objeto LanzaCohetes
		LanzaCohetes SoldadoLanzaCohetes = new LanzaCohetes();
		return SoldadoLanzaCohetes;
	}

}
