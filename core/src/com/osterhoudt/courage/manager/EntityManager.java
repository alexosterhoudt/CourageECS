package com.osterhoudt.courage.manager;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.osterhoudt.courage.components.*;
import com.osterhoudt.courage.systems.*;


public class EntityManager {
    public Engine engine;
    public SpriteBatch batch;
    
    //Body playerBody = BodyManager.player;

    public EntityManager(Engine e, SpriteBatch batch){
        engine = e;

        // Create Systems
        RenderSystem rs = new RenderSystem(batch);
        //CollisionSystem cs = new CollisionSystem();
        //BoundsSystems bs = new BoundsSystems();
        MovementSystem ms = new MovementSystem();
        AnimationSystem as = new AnimationSystem();
        StateSystem ss = new StateSystem();
        PlayerSystem ps = new PlayerSystem();
        //CameraSystem cameraSystem = new CameraSystem();

        // Add systems to engine
        e.addSystem(rs);
        //e.addSystem(cs);
        //e.addSystem(bs);
        e.addSystem(ms);
        e.addSystem(as);
        e.addSystem(ss);
        e.addSystem(ps);
        //e.addSystem(cameraSystem);

        // Create entities
        Entity player = new Entity();
        PositionComponent p = new PositionComponent(100, 100);
        AnimationComponent a1 = new AnimationComponent(AnimationManager.spriteSheet, 100, AnimationManager.playerWest);
        SpriteComponent s = new SpriteComponent(new Texture(a1.getCurrentFrame().toString()));
        VelocityComponent v = new VelocityComponent(3, 3);
        StateComponent sC = new StateComponent();

        sC.set(PlayerComponent.STATE_IDLE);
        //a.animation.insert(PlayerComponent.STATE_IDLE, playeranim.get(0));

        player.add(p)
                .add(s)
                .add(v)
                .add(new PlayerComponent())
                //.add(new BoundsComponent(new Rectangle(p.x, p.y, s.sprite.getWidth(), s.sprite.getHeight())))
                .add(a1)
                .add(sC);
                //.add(new RenderableComponent());

        /*Entity enemy = new Entity();
        PositionComponent ep = new PositionComponent(200, 200);
        //CollisionComponent ec = new CollisionComponent(new Rectangle(p.x, p.y, 10, 10));
        SpriteComponent es = new SpriteComponent(new Texture("player2_idle_0.png"));
        VelocityComponent ev = new VelocityComponent(0, 0);
        AnimationComponent ea = new AnimationComponent(AnimationManager.spriteSheet, 200, AnimationManager.playerEast);

        enemy.add(ep)
                .add(es)
                .add(ev)
                .add(new BlobComponent())
                .add(new BoundsComponent(new Rectangle(ep.x, ep.y, es.sprite.getWidth(), es.sprite.getHeight())))
                //.add(ea)
                .add(new RenderableComponent());
		*/
        // Add entities to engine
        e.addEntity(player);
        //e.addEntity(enemy);
    }

    public void update(){
        engine.update(Gdx.graphics.getDeltaTime());
    }

}
