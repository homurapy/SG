package mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import mygdx.game.base.BaseScreen;
import mygdx.game.math.Rect;
import mygdx.game.sprite.Background;
import mygdx.game.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Background background;
    private Texture bg;
    private Texture logotype;
    private Logo log;
    private Vector2 touch;


    @Override
    public void show() {
        super.show();
        bg = new Texture("backFon.jpg");
        logotype = new Texture("badlogic.jpg");
        background = new Background(bg);
        log = new Logo(logotype);
        touch = new Vector2();

    }

    @Override
    public void render(float delta) {
        System.out.println(touch);
        batch.begin();
        background.draw(batch);
        log.draw(batch);
        batch.end();

        if (touch.x != 0) {
            log.move(touch);
        }

    }

    @Override
    public void dispose() {
        logotype.dispose();
        bg.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        log.resize(worldBounds);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchUp screenX = " + screenX + " screenY = " + screenY);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY).mul(getScreenToWorld());
        touchUp(touch, pointer, button);
        return false;
    }
}


