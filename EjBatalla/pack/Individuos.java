package pack;

import java.util.Arrays;
import java.util.Random;

public abstract class Individuos {

	// Creamos la clase padre con los atributos que heredarán las demas clases, el
	// nombre es elegido de forma aleatoria entre 50 opciones, se elegirá uno cada
	// vez que se cree un objeto de la subclase.
	// Vida se asigna a 9 y posicion se define de forma aleatoria entre 1 y 10 que
	// son las plantas.

	public String nombre;
	public int vida, posicion;
	public boolean vivo = true;

	public Individuos() {

		Random aleatorio = new Random();
		String[] listaNombres = { "Bartolomé", "Crispín", "Demetrio", "Eustaquio", "Florencio", "Gervasio", "Higinio",
				"Isidoro", "Jenaro", "Leovigildo", "Marcial", "Nicanor", "Obdulio", "Pancracio", "Quiteria", "Remigio",
				"Sabas", "Teodosio", "Urbano", "Valeriano", "Wenceslao", "Xenón", "Yago", "Zacarías", "Aureliano",
				"Brígida", "Clemente", "Dorotea", "Ezequiel", "Fabián", "Genoveva", "Hermenegildo", "Irene", "Justino",
				"Liberata", "Marciana", "Néstor", "Octavio", "Porfirio", "Quirico", "Rufina", "Salomé", "Tiburcio",
				"Ulpiano", "Vicenta", "Walfredo", "Ximeno", "Ysabel", "Zósimo" };

		this.nombre = listaNombres[aleatorio.nextInt(49)];
		this.vida = 9;
		this.posicion = aleatorio.nextInt(10) + 1;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if (vida <= 0) {
			this.vida = 0;

		}else this.vida=vida;

	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

}
