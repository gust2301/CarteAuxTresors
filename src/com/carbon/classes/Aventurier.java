package com.carbon.classes;

import java.util.ArrayList;

public class Aventurier {
	private int axeHorizontale;
	private int axeVertical;
	private String nom;
	private String orientation;
	private String sequence;
	private ArrayList<Tresor> tresors= new ArrayList<Tresor>();
	private int nombreTresorRamasse;

	public Aventurier() {
	}

	public Aventurier(String nom, int axeHorizontale, int axeVertical, String orientation, String sequence) {
		this.axeHorizontale = axeHorizontale;
		this.axeVertical = axeVertical;
		this.nom = nom;
		this.orientation = orientation;
		this.sequence = sequence;
	}




	@Override
	public String toString() {
		return "Aventurier [axeHorizontale=" + axeHorizontale + ", axeVertical=" + axeVertical + ", nom=" + nom
				+ ", orientation=" + orientation + ", sequence=" + sequence + ", tresors=" + tresors + "]";
	}

	public int getAxeHorizontale() {
		return axeHorizontale;
	}

	public void setAxeHorizontale(int axeHorizontale) {
		this.axeHorizontale = axeHorizontale;
	}

	public int getAxeVertical() {
		return axeVertical;
	}

	public void setAxeVertical(int axeVertical) {
		this.axeVertical = axeVertical;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public void avancer(int i, int j) {

	}

	public void reculer(int i, int j) {

	}

	public void allerADroite(int i, int j) {

	}

	public void allerAGauche(int i, int j) {

	}
	
	public ArrayList<Tresor> getTresors() {
		return tresors;
	}

	public void setTresors(ArrayList<Tresor> tresors) {
		this.tresors = tresors;
	}
	public int getNombreTresorRamasse() {
		return nombreTresorRamasse;
	}

	public void setNombreTresorRamasse(int nombreTresorRamasse) {
		this.nombreTresorRamasse = nombreTresorRamasse;
	}
	public void ramasserTresor(Tresor tresor) {
		Boolean found=false;
		for (Tresor tresor_ : tresors) {
			if(tresor.equals(tresor_)) {
				found=true;
			}
		}
		if(found==false)
		this.tresors.add(tresor);
		this.setNombreTresorRamasse(getNombreTresorRamasse()+1);
	}
	public int getTotalTresors() {
		int total=0;
		for (Tresor tresor : tresors) {
			total+=(tresor.getNombreTresors()-tresor.getNombreTresorsRestants());
		}
		return total;
	}
}
