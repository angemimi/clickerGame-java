package com.angemimi.classes;

import java.util.UUID;

public class Bonus {
	private UUID id;
	
	public Bonus(){
		this.id = UUID.randomUUID();
	}
	
	public UUID getId(){
		return id;
	}
}
