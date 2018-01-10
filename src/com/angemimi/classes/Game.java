package com.angemimi.classes;

import java.util.UUID;

import com.angemimi.datas.Data;

import java.util.*;

public class Game {
	private UUID id;
	private int score;
	private ArrayList<Price> prices = new ArrayList<Price>();
	
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
	
	public void create(){
		Data.allGames.add(this);
	}
}
