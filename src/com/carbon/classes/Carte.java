package com.carbon.classes;

import java.util.ArrayList;

public class Carte {
	public static int nombreCaseLargeur;
	public static int nombreCaseHauteur;
	public static ArrayList<Montagne> montagnes = new ArrayList<Montagne>();
	public static ArrayList<Tresor> tresors = new ArrayList<Tresor>();
	public static ArrayList<Aventurier> aventuriers = new ArrayList<Aventurier>();
//Representation de la carte à partir du fichier 
	public static void representer() {
		System.out.println("Representation de la carte");
		boolean found;
		for (int i = 0; i < nombreCaseLargeur; i++) {
			for (int j = 0; j < nombreCaseHauteur; j++) {
				found = false;
				for (Aventurier aventurier : aventuriers) {
					if (aventurier.getAxeHorizontale() == j && aventurier.getAxeVertical() == i) {
						System.out.print(aventurier.getNom() + "\t");
						found = true;
					}
				}
				for (Montagne montagne : montagnes) {
					if (montagne.getAxeHorizontale() == j && montagne.getAxeVertical() == i) {
						System.out.print("M\t");
						found = true;
					}
				}
				for (Tresor tresor : tresors) {
					if (tresor.getAxeHorizontale() == j && tresor.getAxeVertical() == i) {
						System.out.print("T(" + tresor.getNombreTresors() + ")\t");
						found = true;
					}
				}
				if (found == false) {
					System.out.print("-\t");
				}
			}
			System.out.println("");
		}
	}
	


	public static void parcourir() {

		for (Aventurier aventurier : aventuriers) {
			for (int i = 0; i <aventurier.getSequence().length(); i++) {
				seDeplacer(aventurier.getOrientation(), aventurier, aventurier.getSequence().charAt(i)+"");
			}
		}
	}

	private static Boolean seDeplacer(String orientation, Aventurier aventurier, String action) {
		switch (orientation) {
		// Orientation SUD
		case "S":
			switch (action) {			
				// Avancer
				case "A":
					return avancer(aventurier);
				// Reculer
				case "R":
					return reculer(aventurier);
				// Droite
				case "D":
					return allerAdroite(aventurier);
				// Gauche
				case "G":
					return allerAGauche(aventurier);
				default:
					break;
			}
			break;
			
			// Orientation NORD
		case "N":
				switch (action) {
				// Avancer
				case "A":
					return reculer(aventurier);					
				// Reculer
				case "R":
					return avancer(aventurier);					
				// Droite
				case "D":
					return allerAdroite(aventurier);
				// Gauche
				case "G":
					return allerAGauche(aventurier);
				default:
					break;
				}
			break;	
				
		// Orientation EST
	   case "E":
			switch (action) {
			// Avancer
			case "A":
				return allerAGauche(aventurier);
			// Reculer
			case "R":
				return allerAdroite(aventurier);
			// Droite
			case "D":
				return reculer(aventurier);
			// Gauche
			case "G":
				return avancer(aventurier);

			default:
				break;
			}
			break;
				
				// Orientation OUEST
		case "O":
				
				switch (action) {
				// Avancer
				case "A":
					return allerAdroite(aventurier);
				// Reculer
				case "R":
					return allerAGauche(aventurier);
				// Droite
				case "D":
					return avancer(aventurier);	
				// Gauche
				case "G":
					return reculer(aventurier);
								
				default:
					break;
				}
				break;
		default:
			break;
		}
		return true;
	}

	private static Boolean avancer(Aventurier aventurier) {
		if (aventurier.getAxeVertical() + 1 < nombreCaseLargeur) {
			for (Montagne montagne : montagnes) {
				if (montagne.getAxeHorizontale() == aventurier.getAxeHorizontale()
						&& montagne.getAxeVertical() == aventurier.getAxeVertical() + 1) {
					return false;
				}
			}
			return explorer(aventurier.getAxeVertical() + 1, aventurier.getAxeHorizontale(), aventurier);
		}  else {
			return false;
		}
	}

	private static  Boolean reculer(Aventurier aventurier) {
		if (aventurier.getAxeVertical() - 1 >= 0) {
			for (Montagne montagne : montagnes) {
				if (montagne.getAxeHorizontale() == aventurier.getAxeHorizontale()
						&& montagne.getAxeVertical() == aventurier.getAxeVertical() - 1) {
					return false;
				}
			}
			return explorer(aventurier.getAxeVertical() - 1, aventurier.getAxeHorizontale(), aventurier);

		}else {
			return false;
		}
	}

	private static Boolean allerAdroite(Aventurier aventurier) {
		if (aventurier.getAxeHorizontale() + 1 < nombreCaseHauteur) {
			for (Montagne montagne : montagnes) {
				if (montagne.getAxeHorizontale() == aventurier.getAxeHorizontale() + 1
						&& montagne.getAxeVertical() == aventurier.getAxeVertical()) {
					return false;
				}
			}
			return explorer(aventurier.getAxeVertical(), aventurier.getAxeHorizontale() + 1, aventurier);
		} else {
			return false;
		}
	}

	private static Boolean allerAGauche(Aventurier aventurier) {
		if (aventurier.getAxeHorizontale() - 1 >= 0) {
			for (Montagne montagne : montagnes) {
				if (montagne.getAxeHorizontale() == aventurier.getAxeHorizontale() - 1
						&& montagne.getAxeVertical() == aventurier.getAxeVertical()) {
					return false;
				}
			}
			return explorer(aventurier.getAxeVertical(), aventurier.getAxeHorizontale() - 1, aventurier);
		} else {
			return false;
		}
	}

	// chercher tresors
	private static boolean explorer(int axeVerticale, int axeHorizontale, Aventurier aventurier) {
		boolean tresorFound=false;
		for (Tresor tresor : tresors) {	

			if (tresor.getAxeVertical() == axeVerticale && tresor.getAxeHorizontale() == axeHorizontale && tresor.getNombreTresorsRestants()>0) {
				if(tresor.getNombreTresorsRestants()>0) {
					tresor.setNombreTresorsRestants(tresor.getNombreTresorsRestants()-1);
				}
				aventurier.ramasserTresor(tresor);
				tresorFound=true;
			}
		}
		aventurier.setAxeHorizontale(axeHorizontale);
		aventurier.setAxeVertical(axeVerticale);
		return tresorFound;
	}
}
