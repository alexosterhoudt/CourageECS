package com.osterhoudt.courage.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.osterhoudt.courage.components.AnimationComponent;
import com.osterhoudt.courage.components.PlayerComponent;
import com.osterhoudt.courage.components.PositionComponent;
import com.osterhoudt.courage.components.StateComponent;
import com.osterhoudt.courage.components.VelocityComponent;
import com.osterhoudt.courage.manager.AnimationManager;

public class MovementSystem extends EntitySystem {

    private ImmutableArray<Entity> players;

    private ComponentMapper<PositionComponent> pm;
    private ComponentMapper<VelocityComponent> vm;
    private ComponentMapper<StateComponent> sm;
    private ComponentMapper<AnimationComponent> am;
    private ComponentMapper<PlayerComponent> playerM;

    public MovementSystem(){
        pm = ComponentMapper.getFor(PositionComponent.class);
        vm = ComponentMapper.getFor(VelocityComponent.class);
        sm = ComponentMapper.getFor(StateComponent.class);
        am = ComponentMapper.getFor(AnimationComponent.class);
        playerM = ComponentMapper.getFor(PlayerComponent.class);
    }

    public void addedToEngine(Engine engine){
        players = engine.getEntitiesFor(Family.all(PositionComponent.class, VelocityComponent.class, StateComponent.class, AnimationComponent.class, PlayerComponent.class).get());
    }

    public void update(float delta){
        for(int i = 0; i < players.size(); ++i){
            Entity player = players.get(i);
            VelocityComponent v = vm.get(player);
            v.velocityX = 3f;
            v.velocityY = 3f;
            boolean left = Gdx.input.isKeyPressed(Input.Keys.A);
            boolean right = Gdx.input.isKeyPressed(Input.Keys.D);
            boolean up = Gdx.input.isKeyPressed(Input.Keys.W);
            boolean down = Gdx.input.isKeyPressed(Input.Keys.S);

            if(left)
                moveWest(player, delta);

            if(right)
                moveEast(player, delta);

            if(up)
                moveNorth(player, delta);

            if(down)
                moveSouth(player, delta);

            if(left && up)
                moveNorthWest(player, delta);

            if(right && up)
                moveNorthEast(player, delta);

            if(left && down)
                moveSouthWest(player, delta);

            if(right && down)
                moveSouthEast(player, delta);

            if(!left && !right && !up && !down)
                idle(player, delta);
        }
    }

    public void moveWest(Entity entity, float delta){
        StateComponent state = sm.get(entity);
        PositionComponent p = pm.get(entity);
        VelocityComponent v = vm.get(entity);

        p.x -= v.velocityX * 50 * delta;
        state.set(PlayerComponent.STATE_WEST);
    }

    public void moveEast(Entity entity, float delta){
        StateComponent state = sm.get(entity);
        PositionComponent p = pm.get(entity);
        VelocityComponent v = vm.get(entity);

        p.x += v.velocityX * 50 * delta;
        state.set(PlayerComponent.STATE_EAST);
    }

    public void moveNorth(Entity entity, float delta){
        StateComponent state = sm.get(entity);
        PositionComponent p = pm.get(entity);
        VelocityComponent v = vm.get(entity);

        p.y += v.velocityX * 50 * delta;
        state.set(PlayerComponent.STATE_NORTH);
    }

    public void moveSouth(Entity entity, float delta){
        StateComponent state = sm.get(entity);
        PositionComponent p = pm.get(entity);
        VelocityComponent v = vm.get(entity);

        p.y -= v.velocityX * 50 * delta;
        state.set(PlayerComponent.STATE_SOUTH);
    }

    public void moveNorthWest(Entity entity, float delta){
        StateComponent state = sm.get(entity);
        PositionComponent p = pm.get(entity);
        VelocityComponent v = vm.get(entity);

        p.x -= v.velocityX * 3.25 * delta;
        p.y += v.velocityX * 3.25 * delta;
        state.set(PlayerComponent.STATE_NORTHWEST);
    }

    public void moveNorthEast(Entity entity, float delta){
        StateComponent state = sm.get(entity);
        PositionComponent p = pm.get(entity);
        VelocityComponent v = vm.get(entity);

        p.x += v.velocityX * 3.25 * delta;
        p.y += v.velocityX * 3.25 * delta;
        state.set(PlayerComponent.STATE_NORTHEAST);
    }

    public void moveSouthWest(Entity entity, float delta){
        StateComponent state = sm.get(entity);
        PositionComponent p = pm.get(entity);
        VelocityComponent v = vm.get(entity);

        p.x -= v.velocityX * 3.25 * delta;
        p.y -= v.velocityY * 3.25 * delta;
        state.set(PlayerComponent.STATE_SOUTHWEST);
    }

    public void moveSouthEast(Entity entity, float delta){
        StateComponent state = sm.get(entity);
        PositionComponent p = pm.get(entity);
        VelocityComponent v = vm.get(entity);

        p.x += v.velocityX * 3.25 * delta;
        p.y -= v.velocityY * 3.25 * delta;
        state.set(PlayerComponent.STATE_SOUTHEAST);
    }

    public void idle(Entity entity, float delta){
        StateComponent state = sm.get(entity);
        PositionComponent p = pm.get(entity);
        VelocityComponent v = vm.get(entity);
        AnimationComponent a = new AnimationComponent(AnimationManager.spriteSheet, 100, AnimationManager.playerEast);

        v.velocityX = 0;
        v.velocityY = 0;
        state.set(PlayerComponent.STATE_IDLE);
    }

}
