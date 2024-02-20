package pack;

import java.util.Random;

public abstract class Individuos {

	// Creamos la clase padre con los atributos que heredarán las demas clases, el
	// nombre es elegido de forma aleatoria entre 50 opciones, se elegirá uno cada
	// vez que se cree un objeto de la subclase.
	// Vida se asigna a 9 y posicion se define de forma aleatoria entre 1 y 10 que
	// son las plantas.

	protected String nombre;
	protected int vida, posicion;
	protected boolean vivo = true;

	public Individuos() {

		Random aleatorio = new Random();
		String[] listaNombres = { "Bartolomé Pérez", "Crispín López", "Demetrio Ruiz", "Eustaquio Fernández",
				"Florencio Díaz", "Gervasio Rodríguez", "Higinio Sánchez", "Isidoro Martínez", "Jenaro Gómez",
				"Leovigildo Ramírez", "Marcial González", "Nicanor Martín", "Obdulio Pérez", "Pancracio Gutiérrez",
				"Quiteria Martínez", "Remigio Sánchez", "Sabas Fernández", "Teodosio Ramírez", "Urbano González",
				"Valeriano Pérez", "Wenceslao Gómez", "Xenón López", "Yago Sánchez", "Zacarías Rodríguez",
				"Aureliano Martínez", "Brígida Díaz", "Clemente Pérez", "Dorotea Gómez", "Ezequiel Ramírez",
				"Fabián González", "Genoveva Martín", "Hermenegildo Pérez", "Irene Gutiérrez", "Justino Rodríguez",
				"Liberata López", "Marciana Martínez", "Néstor Ramírez", "Octavio González", "Porfirio Pérez",
				"Quirico Gómez", "Rufina Sánchez", "Salomé Martín", "Tiburcio Díaz", "Ulpiano Pérez", "Vicenta Gómez",
				"Walfredo Ramírez", "Ximeno López", "Ysabel Martínez", "Zósimo Fernández" };

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

		} else
			this.vida = vida;

	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

}
