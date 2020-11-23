package com.carbon.classes;

public class Tresor {
	 private int axeHorizontale;
	 private int axeVertical;
	 private int nombreTresors;
	 private int nombreTresorsRestants;
	public Tresor() {
	}
	public Tresor(int axeHorizontale, int axeVertical, int nombreTresors) {
		this.axeHorizontale = axeHorizontale;
		this.axeVertical = axeVertical;
		this.nombreTresors = nombreTresors;
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
	public int getNombreTresors() {
		return nombreTresors;
	}
	public void setNombreTresors(int nombreTresors) {
		this.nombreTresors = nombreTresors;
	}
	public int getNombreTresorsRestants() {
		return nombreTresorsRestants;
	}
	public void setNombreTresorsRestants(int nombreTresorsRestants) {
		this.nombreTresorsRestants = nombreTresorsRestants;
	}
	@Override
	public String toString() {
		return "Tresor [axeHorizontale=" + axeHorizontale + ", axeVertical=" + axeVertical + ", nombreTresors="
				+ nombreTresors + ", nombreTresorsRestants=" + nombreTresorsRestants + "]";
	}

	 
}
