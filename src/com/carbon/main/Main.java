package com.carbon.main;

import com.carbon.classes.Carte;
import com.carbon.files.Fichier;

public class Main {

	public static void main(String[] args) {
		
		Fichier f = new Fichier();
		//Lecture du fichier d'entree
		f.lire();
		//Representation de la carte
		Carte.representer();
		//Parcours et recherche de tresors
		Carte.parcourir();
		//Ecriture et affichage du resultat
		f.Ecrire();
	}

}
