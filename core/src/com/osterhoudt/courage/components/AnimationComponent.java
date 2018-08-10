package com.osterhoudt.courage.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class AnimationComponent implements Component{

	public int speed, index;
	public long lastTime, timer;
	public TextureAtlas spriteSheet;
	public Array<Sprite> animation;
	
	public AnimationComponent(TextureAtlas spriteSheet, int speed, Array<Sprite> animation) {
		this.speed = speed;
		this.animation = animation;
		index = 0;
		lastTime = System.currentTimeMillis();
		timer = 0;
		this.spriteSheet = spriteSheet;
	}
	
	public Sprite getCurrentFrame() {
		return animation.get(index);
	}
	
}
