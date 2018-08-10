package com.osterhoudt.courage.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.osterhoudt.courage.components.PlayerComponent;
import com.osterhoudt.courage.components.PositionComponent;
import com.osterhoudt.courage.components.StateComponent;
import com.osterhoudt.courage.components.VelocityComponent;

public class PlayerSystem extends IteratingSystem{
    private static final Family family = Family.all(PlayerComponent.class, StateComponent.class, PositionComponent.class, VelocityComponent.class).get();

    private ComponentMapper<PlayerComponent> pm;
    private ComponentMapper<StateComponent> sm;
    private ComponentMapper<PositionComponent> posM;
    private ComponentMapper<VelocityComponent> vm;

    public PlayerSystem() {
        super(family);

        pm = ComponentMapper.getFor(PlayerComponent.class);
        sm = ComponentMapper.getFor(StateComponent.class);
        posM = ComponentMapper.getFor(PositionComponent.class);
        vm = ComponentMapper.getFor(VelocityComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PlayerComponent p = pm.get(entity);
        StateComponent s = sm.get(entity);
        PositionComponent pos = posM.get(entity);
        VelocityComponent v = vm.get(entity);
    }

    public void hitEnemy(Entity entity){
        if(!family.matches(entity))
            return;

        StateComponent s = sm.get(entity);
        VelocityComponent v = vm.get(entity);

        System.out.println("hit");
        s.set(PlayerComponent.STATE_HIT);
    }
}
