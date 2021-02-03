package mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarGame extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;
	SpriteBatch spriteBatch;
	Texture img1;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		spriteBatch = new SpriteBatch();
		img1 = new Texture("backFon.jpg");

	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		spriteBatch.draw(img1, 0,0, Gdx.graphics.getWidth(),Gdx.graphics.getWidth());
		spriteBatch.end();
		batch.begin();
		batch.draw(img, Gdx.graphics.getWidth()/2, Gdx.graphics.getWidth()/2);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
