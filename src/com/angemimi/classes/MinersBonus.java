package com.angemimi.classes;

public class MinersBonus extends Bonus {
	private int number = 0;
	private int price = 50;
	private int nbPierre = 1;
	
	public MinersBonus(){ super();}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNbPierre() {
		return nbPierre;
	}
	public void setNbPierre(int nbPierre) {
		this.nbPierre = nbPierre;
	}
}
