package ecriture;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ecrire implements Runnable {
	private String path;
	private Double tempeature;
	private String str;

	public Ecrire(String path, Double temperature) {
		this.path = path;
		this.tempeature = temperature;
	}

	public boolean fichierExist() {

		if (new File(path).isFile()) {
			return true;
		}

		return false;
	}

	public void acquisition() {

		FileWriter fw;
		try {
			fw = new FileWriter(this.path);
			@SuppressWarnings("resource")
			BufferedWriter write = new BufferedWriter(fw);
			write.write("" + str);
			write.close();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enregistrement() {

		if (!fichierExist()) {

			try {
				new File(path).createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un a et une acquisition :");
		str = sc.nextLine();

		while (str.contains("a")) {

			str = str.replace('a', ' ');

			acquisition();

			System.out.println("Veuillez saisir un a et une acqcuisition :");
			str = sc.nextLine();

		}
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(500);
				enregistrement();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
