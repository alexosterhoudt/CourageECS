package com.osterhoudt.courage.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.osterhoudt.courage.Courage;
import com.osterhoudt.courage.components.*;
import com.osterhoudt.courage.manager.AnimationManager;

/**
 * Created by alex on 9/20/2015.
 */
public class RenderSystem extends EntitySystem {
    public ImmutableArray<Entity> entities;
    public static SpriteBatch batch;

    public RenderSystem(SpriteBatch batch){
        this.batch = batch;
    }

    public void addedToEngine(Engine engine){
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, SpriteComponent.class, AnimationComponent.class).get());
    }

    public void update(float delta){
        for(int i = 0; i < entities.size(); ++i){
            Entity entity = entities.get(i);

            //BodyComponent bc = entity.getComponent(BodyComponent.class);
            PositionComponent pc = entity.getComponent(PositionComponent.class);
            SpriteComponent sc = entity.getComponent(SpriteComponent.class);
            //SpriteComponent coll = new SpriteComponent(new Texture("collRect.png"));
            //BoundsComponent bc = entity.getComponent(BoundsComponent.class);
            AnimationComponent ac = entity.getComponent(AnimationComponent.class);
            AnimationComponent ac2 = entity.getComponent(AnimationComponent.class);
            StateComponent s = entity.getComponent(StateComponent.class);
            //SpriteComponent bg = new SpriteComponent(new Texture("bg.png"));

            //batch.draw(coll.sprite.getTexture(), 200, 200, 100, 100);
            if(s.get() == PlayerComponent.STATE_WEST){
                ac.animation = AnimationManager.playerWest;
                batch.draw(ac.getCurrentFrame(), pc.x, pc.y, sc.sprite.getWidth(), sc.sprite.getHeight());
            }
            else if(s.get() == PlayerComponent.STATE_NORTHWEST){
                ac.animation = AnimationManager.playerWest;
                batch.draw(ac.getCurrentFrame(), pc.x, pc.y, sc.sprite.getWidth(), sc.sprite.getHeight());
            }
            else if(s.get() == PlayerComponent.STATE_EAST){
                ac.animation = AnimationManager.playerEast;
                batch.draw(ac.getCurrentFrame(), pc.x, pc.y, sc.sprite.getWidth() , sc.sprite.getHeight());
            }
            else if(s.get() == PlayerComponent.STATE_NORTHEAST){
                ac.animation = AnimationManager.playerEast;
                batch.draw(ac.getCurrentFrame(), pc.x, pc.y, sc.sprite.getWidth(), sc.sprite.getHeight());
            }
            else if(s.get() == PlayerComponent.STATE_SOUTHWEST){
                ac.animation = AnimationManager.playerWest;
                batch.draw(ac.getCurrentFrame(), pc.x, pc.y, sc.sprite.getWidth(), sc.sprite.getHeight());
            }
            else if(s.get() == PlayerComponent.STATE_SOUTHEAST){
                ac.animation = AnimationManager.playerEast;
                batch.draw(ac.getCurrentFrame(), pc.x, pc.y, sc.sprite.getWidth(), sc.sprite.getHeight());
            }
            else if(s.get() == PlayerComponent.STATE_IDLE){
            	ac.animation = AnimationManager.playerIdleWest;
                batch.draw(sc.sprite.getTexture(), pc.x, pc.y, sc.sprite.getWidth(), sc.sprite.getHeight());
            }
            //batch.draw(coll.sprite.getTexture(), bc.bounds.getX(), bc.bounds.getY(), bc.bounds.getWidth() * 2, bc.bounds.getHeight() * 2);
        }
    }
}
