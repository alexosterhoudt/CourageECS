package com.osterhoudt.courage.manager;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

/**
 * Created by alex on 9/30/2015.
 */
public class AnimationManager {
    public static TextureAtlas spriteSheet = new TextureAtlas("Spritesheet.atlas");
    public static Array<Sprite> playerWest = spriteSheet.createSprites("PlayerWest");
    public static Array<Sprite> playerEast = spriteSheet.createSprites("PlayerEast");
    public static Array<Sprite> playerIdleSouth = spriteSheet.createSprites("PlayerIdleSouth");
    public static Array<Sprite> playerIdleWest = spriteSheet.createSprites("PlayerIdleWest");
}
