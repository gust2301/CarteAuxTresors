package com.carbon.classes;

public class Montagne {
	 private int axeHorizontale;
	 private int axeVertical;
	 public Montagne() {		 
	 }
	public Montagne(int axeHorizontale, int axeVertical) {
		this.axeHorizontale = axeHorizontale;
		this.axeVertical = axeVertical;
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
	@Override
	public String toString() {
		return "Montagne [axeHorizontale=" + axeHorizontale + ", axeVertical=" + axeVertical + "]";
	}
	 
}
