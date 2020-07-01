package temperature;

import ecriture.Ecrire;
import lecture.Lire;

public class Main {

	public static void main(String[] args) {
		Ecrire premierInstEcrire = new Ecrire("D:\\kri\\ecrire.txt", 2.4);
		Lire lire = new Lire("D:\\kri\\ecrire.txt");

		Thread thread2 = new Thread(lire);
		Thread creation = new Thread(premierInstEcrire);

		creation.start();

		thread2.start();

	}

}
