package com.osterhoudt.courage;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.osterhoudt.courage.manager.EntityManager;

public class Courage extends Game {

	SpriteBatch batch;
	EntityManager entityManager;
	public static OrthographicCamera cam;
	
	@Override
	public void create() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		Engine engine = new Engine();
		batch = new SpriteBatch();
		entityManager = new EntityManager(engine, batch);
		cam = new OrthographicCamera();
		cam.setToOrtho(false, w / 2, h / 2);
		
	}
	
	@Override
	public void render() {
		//Gdx.gl.glClearColor(0.647059f, 0.164706f, 0.164706f, 1);
		Gdx.gl.glClearColor(0.67f, 0.49f, 0.29f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		entityManager.update();
		batch.end();
	}
	
}
