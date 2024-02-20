package pack;

import java.util.Random;

public class LanzaCohetes extends Individuos {

	// Creamos la clase hijo LanzaCohetes, que hereda nombre, vida, posicion y vivo
	// de la clase padre Individuos y añade la variable alcance, que se genera de
	// forma aleatoria entre 1 y 10. que son las plantas del edificio.

	private int alcance;

	public LanzaCohetes() {

		Random aleatorio = new Random();
		this.alcance = aleatorio.nextInt(10) + 1;
	}

	public String toString() {
		System.out.printf("\033[35m 🚀 LanzaCohetes:    %-20s Vida=%-10d Posición=%-10s Alcance=%-10d" + "\033[30m",
				nombre, vida, posicion, alcance);
		return "";
	}

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

}
