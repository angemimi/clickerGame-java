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
	public void setId(UUID id) {
		this.id = id;
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
	
	public void create(Player player, String typeGame, double time){
		Game game = null;
		switch(typeGame){
			case "standard":
				game = new StandardGame();
				game.create();
			break;
			case "limitTime":
				if(time != 0){
					game = new LimitTimeGame(time);
					game.create();
				} else {
					game = new LimitTimeGame();
					game.create();
				}
			break;
		}
		game.create();
		player.games.add(game);
		player.playGame = game;
		Data.players.add(player);
	}
	public Game getPlayGame() {
		return playGame;
	}
	public void setPlayGame(Game playGame) {
		this.playGame = playGame;
	}
}
