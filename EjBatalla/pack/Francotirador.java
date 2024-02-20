package pack;

import java.util.Random;

public class Francotirador extends Individuos {

	// Creamos la clase hijo Francotirador, que hereda nombre, vida, posicion y vivo
	// de la clase padre Individuos y añade la variable danio, que se genera de
	// forma aleatoria entre 1 y 9

	private int danio;

	public Francotirador() {

		Random aleatorio = new Random();
		this.danio = aleatorio.nextInt(9) + 1;

	}

	@Override
	public String toString() {
		System.out.printf("\033[34m 🔫 Francotirador:   %-20s Vida=%-10d Posición=%-10s Daño=%-13d" + "\033[30m", 
				nombre, vida, posicion, danio);
		return "";
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

}
