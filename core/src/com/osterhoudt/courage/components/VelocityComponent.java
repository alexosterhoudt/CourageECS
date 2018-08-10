package com.osterhoudt.courage.components;

import com.badlogic.ashley.core.Component;

public class VelocityComponent implements Component{

	public float velocityX, velocityY;
	
	public VelocityComponent(float velocityX, float velocityY) {
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}
	
}
