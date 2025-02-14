
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		int[] ubicacion = iniciacionPartida();
		menu(sn, ubicacion);

	}

	private static void menu(Scanner sn, int[] ubicacion) {
		int opcion = 0;

		do {
			try {
				System.out.println("\nPulsa 1. Busca Raptor");
				System.out.println("Pulsa 2. Captura Raptor");
				System.out.println("Pulsa 3. Mostrar Mapa");
				System.out.println("Pulsa 4. Salir");
				opcion = sn.nextInt();
				switch (opcion) {
				case 1:
					buscarRaptor(ubicacion, sn);
					break;
				case 2:
					capturarRaptor(ubicacion, sn);
					break;
				case 3:
					mostrarMapa(ubicacion, sn);
					break;

				default:

				}
			} catch (InputMismatchException e) {
				System.err.println("Intentaste escribir un caracter");
				sn.next();
			}

		} while (opcion != 4);

	}

	private static void mostrarMapa(int[] ubicacion, Scanner sn) {
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		for (int i = 0; i < ubicacion.length; i++) {
			if (ubicacion[i] == 1) {
				System.out.print("||  X  || ");
			} else {
				System.out.print("||  -  || ");
			}

		}
		System.out.println(
				"\n---------------------------------------------------------------------------------------------------");

	}

	private static void capturarRaptor(int[] ubicacion, Scanner sn) {

		System.out.println("dime donde realizo la captura?");
		int posicion = sn.nextInt();
		try {
			if (!(posicion <= 10 && posicion >= 1)) {
				throw new IllegalArgumentException();

			} else {
				if ((ubicacion[posicion - 1]) == 1) {
					System.out.println("!Bingo, aqui hay Movimiento!");
					ubicacion[posicion - 1] = 0;
				} else {
					System.out.println("!Nada, aqui no hay Movimiento!");
				}
			}

		} catch (IllegalArgumentException e) {
			System.err.println("NO EXISTE ESTA POSICION");
		}

	}

	private static void buscarRaptor(int[] ubicacion, Scanner sn) {

		System.out.println("dime una posicion de 1 a 10?");
		int posicion = sn.nextInt();
		try {
			if (!(posicion <= 10 && posicion >= 1)) {
				throw new IllegalArgumentException();

			} else {
				if ((ubicacion[posicion - 1]) == 1) {
					System.out.println("!Bingo, aqui hay Movimiento!");
				} else {
					System.out.println("!Nada, aqui no hay Movimiento!");
				}
			}

		} catch (IllegalArgumentException e) {
			System.err.println("NO EXISTE ESTA POSICION");
		}

	}

	private static int[] iniciacionPartida() {
		int[] ubicacion = new int[10];
		Random rn = new Random();
		for (int i = 0; i < ubicacion.length; i++) {
			ubicacion[i] = rn.nextInt(2);
		}
		return ubicacion;
	}

}
