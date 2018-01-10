package com.angemimi.classes;

import java.util.UUID;

import com.angemimi.datas.Data;

public class LimitTimeGame extends Game{
	private double time;
	
	public LimitTimeGame(){
		super();
		this.time = 0.55;
	}
	
	public LimitTimeGame(double time){
		super();
		this.time = time;
	}
	
	public LimitTimeGame(UUID id, int score, double time){
		super(id, score);
		this.time = time;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
}
