package com.angemimi.classes;

import java.util.UUID;

public class Price {
	private UUID id;
	private String name;
	private String urlImg;
	
	public Price(){}
	public Price(UUID id, String name, String img){
		this.id = id;
		this.name = name;
		this.urlImg = img;
	}
}
