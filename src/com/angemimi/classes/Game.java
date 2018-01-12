package com.angemimi.classes;

import java.util.UUID;

import com.angemimi.datas.Data;

import java.util.*;

public class Game {
	private UUID id;
	private int score;
	private int nbPiece;
	private int nbDiamond;
	private ArrayList<Price> prices = new ArrayList<Price>();
	private MinersBonus miner = new MinersBonus();
	private ChariotBonus chariot = new ChariotBonus();
	
	public Game(){
		this.id = UUID.randomUUID();
		this.score = 0;
	}
	
	public Game(UUID id, int score){
		this.id = id;
		this.score = score;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getNbPiece() {
		return nbPiece;
	}
	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}
	public int getNbDiamond() {
		return nbDiamond;
	}
	public void setNbDiamond(int nbDiamond) {
		this.nbDiamond = nbDiamond;
	}
	public ArrayList<Price> getPrices() {
		return prices;
	}
	public void setPrices(ArrayList<Price> prices) {
		this.prices = prices;
	}
	public MinersBonus getMiner() {
		return miner;
	}
	public void setMiner(MinersBonus miner) {
		this.miner = miner;
	}
	public ChariotBonus getChariot(){
		return chariot;
	}
	public void setChariot(ChariotBonus chariot){
		this.chariot = chariot;
	}
	
	// Enregistrement de la partie dans la variable data
	public void create(){
		Data.allGames.put(this.getId(),this);
	}
	
	// Recherche d'une partie
	public Game retrieve(UUID id){
		return Data.allGames.get(id);
	}
	
	public void updateToData(Game g){
		Data.allGames.get(g.getId()).setNbDiamond(g.getNbDiamond());
		Data.allGames.get(g.getId()).setNbPiece(g.getNbPiece());
		Data.allGames.get(g.getId()).setScore(g.getScore());
		Data.allGames.get(g.getId()).setPrices(g.getPrices());
	}
	
	public void deleteToData(Game g){
		Data.allGames.remove(g.getId());
	}
}
