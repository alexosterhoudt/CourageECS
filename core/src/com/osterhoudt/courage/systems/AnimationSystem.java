package com.osterhoudt.courage.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.osterhoudt.courage.components.AnimationComponent;

public class AnimationSystem extends EntitySystem{

	private ImmutableArray<Entity> entities;
	
	public AnimationSystem() {
		
	}
	
	public void addedToEngine(Engine engine) {
		entities = engine.getEntitiesFor(Family.all(AnimationComponent.class).get());
	}
	
	public void update(float delta) {
		for(int i = 0; i < entities.size(); ++i) {
			Entity entity = entities.get(i);
			
			AnimationComponent a = entity.getComponent(AnimationComponent.class);
			
			a.timer += System.currentTimeMillis() - a.lastTime;
			a.lastTime = System.currentTimeMillis();
			
			if(a.timer > a.speed) {
				a.index++;
				a.timer = 0;
				if(a.index >= a.animation.size)
					a.index = 0;
			}
		}
	}
	
}
