package com.angemimi.classes;

import java.util.ArrayList;
import java.util.UUID;

import com.angemimi.datas.Data;

public class Player {
	private UUID id;
	private String name;
	private ArrayList<Game> games = new ArrayList<Game>();
	private int higthScore = 0;
	private ArrayList<Price> prices = new ArrayList<Price>();
	private Game playGame;
	
	public Player(){}
	public Player(String name){
		this.id = UUID.randomUUID();
		this.name = name;
	}
	public Player(UUID id, String name){
		this.id = id;
		this.name = name;
	}
	public Player(UUID id, String name, ArrayList<Game> games, int higthScore, ArrayList<Price> prices) {
		this.id = id;
		this.name = name;
		this.games = games;
		this.prices = prices;
		this.higthScore = higthScore;
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Game> getGames() {
		return games;
	}
	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}
	public int getHigthScore() {
		return higthScore;
	}
	public void setHigthScore(int higthScore) {
		this.higthScore = higthScore;
	}
	public ArrayList<Price> getPrices() {
		return prices;
	}
	public void setPrices(ArrayList<Price> prices) {
		this.prices = prices;
	}
	public Game getPlayGame() {
		return playGame;
	}
	public void setPlayGame(Game playGame) {
		this.playGame = playGame;
	}
	
	public void create(Player player, String typeGame, double time){
		Game game = new Game();
		if(typeGame == "standard"){
			game = new StandardGame();
		}
		if(typeGame == "limitTime"){
			if(time != 0){
				game = new LimitTimeGame(time);
			} else {
				game = new LimitTimeGame();
			}
		}
		game.create();
		player.getGames().add(game);
		player.setPlayGame(game);
		Data.players.put(player.getId(),player);
	}
	
	public Player retrieve(UUID id){
		return Data.players.get(id);
	}
	
	public void updateToData(Player p){
		Data.players.get(p.getId()).setHigthScore(p.higthScore);
		Data.players.get(p.getId()).setGames(p.getGames());
		Data.players.get(p.getId()).setName(p.getName());
		Data.players.get(p.getId()).setPlayGame(p.getPlayGame());
		Data.players.get(p.getId()).setPrices(p.getPrices());
	}
}
