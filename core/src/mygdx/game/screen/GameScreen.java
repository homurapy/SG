package mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import mygdx.game.base.BaseScreen;
import mygdx.game.math.Rect;
import mygdx.game.sprite.Background;
import mygdx.game.sprite.Star;


public class GameScreen extends BaseScreen {

    private Background background;
    private Texture bg;

    private TextureAtlas atlas;
    private Star star;
    private static final int EMPTYSTAR =256;
    private Star[] stars;
    private Vector2 touch;


    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/backFon.jpg");
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("textures/menuAtlas.tpack"));
        background = new Background(bg);
        stars = new Star[EMPTYSTAR];
        for (int i = 0; i < EMPTYSTAR; i++) {
            stars[i] = new Star(atlas);
        }
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

    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
    }

    private void draw() {
        Gdx.gl.glClearColor(0.3f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
//        buttonExit.draw(batch);
//        buttonPlay.draw(batch);
        batch.end();
    }
}


