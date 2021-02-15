package mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import mygdx.game.base.BaseScreen;
import mygdx.game.math.Rect;
import mygdx.game.sprite.Background;
import mygdx.game.sprite.Ship;
import mygdx.game.sprite.Star;


public class GameScreen extends BaseScreen {

    private Background background;
    private Texture bg;

    private TextureAtlas atlasShip;
    private TextureAtlas atlas;
    private Star star;
    private static final int EMPTY =64;
    private Star[] stars;
    private Vector2 touch;
    private Ship ship;
    private TextureRegion region;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/backFon.jpg");
        atlas = new TextureAtlas(Gdx.files.internal("textures/menuAtlas.tpack"));
        region =  new TextureRegion(new Texture("textures/mainAtlas.png") , 916, 95, 195, 287);
        atlasShip = new TextureAtlas(Gdx.files.internal("textures/mainAtlas.tpack"));
        background = new Background(bg);
        stars = new Star[EMPTY];
        for (int i = 0; i < EMPTY; i++) {
            stars[i] = new Star(atlas);
        }
        ship =new Ship(region);
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        atlas.dispose();
        bg.dispose();
        super.dispose();
    }
    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (Star starR : stars) {
            starR.resize(worldBounds);
        }
        ship.resize(worldBounds);

    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
        ship.update(delta);
            }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return super.mouseMoved(screenX, screenY);
    }

    private void draw() {
        Gdx.gl.glClearColor(0.3f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        ship.draw(batch);

        batch.end();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        ship.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return false;
    }
}


