package mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import mygdx.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture img1;
    private Vector2 touch;
    private Vector2 start;
    private Vector2 v;

    @Override
    public void show() {
        super.show();
        img1 =new Texture("backFon.jpg");
        img = new Texture("badlogic.jpg");
        start=new Vector2(0,0);
        touch = new Vector2();
    }

    @Override
    public void render(float delta) {
//        Gdx.gl.glClearColor(0.3f, 0.6f, 0.4f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (touch != null) {
            float line = (1/touch.cpy().sub(start).len());
           v=touch.cpy().sub(start).scl(line);
        }
        batch.begin();
        batch.draw(img1,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getWidth());
        batch.end();

        batch.begin();
        batch.draw(img, start.x, start.y);
        batch.end();
if (touch.cpy().sub(start).len()>1){
            start.add(v);
        }


    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("touchDown screenX = " +screenX +" screenY "+ (Gdx.graphics.getHeight() - screenY));
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                touch.y += 10;
                break;
            case Input.Keys.DOWN:
                touch.y -= 10;
                break;
            case Input.Keys.RIGHT:
                touch.x += 10;
                break;
            case Input.Keys.LEFT:
                touch.x -= 10;
                break;
        }
        return false;
    }
}
