package com.carbon.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.carbon.classes.Aventurier;
import com.carbon.classes.Carte;
import com.carbon.classes.Montagne;
import com.carbon.classes.Tresor;

public class Fichier {
	private BufferedReader b;

	// Lecture du fichier d'entrée
	public void lire() {

		try {

			File f = new File("src/com/carbon/files/inputFile.txt");

			b = new BufferedReader(new FileReader(f));

			String readLine = "";
			String trimedLine = "";
			String[] datas;
			while ((readLine = b.readLine()) != null) {
				trimedLine = readLine.replaceAll("\s", "");
				datas = trimedLine.split("-");
				if (readLine.charAt(0) != '#') {
					if (readLine.charAt(0) == 'C') {
						Carte.nombreCaseHauteur = Integer.parseInt(datas[1] + "");
						Carte.nombreCaseLargeur = Integer.parseInt(datas[2] + "");
					}
					if (readLine.charAt(0) == 'M') {
						Montagne montagne = new Montagne();
						montagne.setAxeHorizontale(Integer.parseInt(trimedLine.charAt(2) + ""));
						montagne.setAxeVertical(Integer.parseInt(trimedLine.charAt(4) + ""));
						Carte.montagnes.add(montagne);
					}
					if (readLine.charAt(0) == 'T') {
						Tresor tresor = new Tresor();
						tresor.setAxeHorizontale(Integer.parseInt(datas[1] + ""));
						tresor.setAxeVertical(Integer.parseInt(datas[2] + ""));
						tresor.setNombreTresors(Integer.parseInt(datas[3] + ""));
						tresor.setNombreTresorsRestants(Integer.parseInt(datas[3] + ""));
						Carte.tresors.add(tresor);
					}

					if (readLine.charAt(0) == 'A') {
						Aventurier aventurier = new Aventurier();
						aventurier.setNom(datas[1]);
						aventurier.setAxeHorizontale(Integer.parseInt(datas[2] + ""));
						aventurier.setAxeVertical(Integer.parseInt(datas[3] + ""));
						aventurier.setOrientation(datas[4]);
						aventurier.setSequence(datas[5]);
						aventurier.setNombreTresorRamasse(0);
						Carte.aventuriers.add(aventurier);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Ecrire sur le fichier de sortie
	public void Ecrire() {
		System.out.println("\nFormat de sortie de la carte");
		PrintWriter writer;
		try {
			writer = new PrintWriter("src/com/carbon/files/outputFile.txt", "UTF-8");

			String writeLine = "";
			writeLine += "C - " + Carte.nombreCaseLargeur + " - " + Carte.nombreCaseHauteur + "\n";

			for (Montagne montagne : Carte.montagnes) {

				writeLine += "M - " + montagne.getAxeHorizontale() + " - " + montagne.getAxeVertical() + "\n";

			}
			writeLine += "# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Trésors ramassés}\n";
			for (Aventurier aventurier : Carte.aventuriers) {
				for (Tresor tresor : aventurier.getTresors()) {
					if (!(aventurier.getAxeHorizontale() == tresor.getAxeHorizontale()
							&& aventurier.getAxeVertical() == tresor.getAxeVertical())) {
						int TresorRamasses = tresor.getNombreTresors() - tresor.getNombreTresorsRestants();
						writeLine += "T - " + tresor.getAxeHorizontale() + " - " + tresor.getAxeVertical() + " - "
								+ TresorRamasses + "\n";
					}
				}
			}
			writeLine += "# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}\n";

			for (Aventurier aventurier : Carte.aventuriers) {
				writeLine += "A - " + aventurier.getNom() + " - " + aventurier.getAxeHorizontale() + " - "
						+ aventurier.getAxeVertical() + " - " + aventurier.getOrientation() + " - "
						+ aventurier.getNombreTresorRamasse() + "\n";
			}
			writer.println(writeLine);
			writer.close();
			System.out.println(writeLine);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
	}
}
