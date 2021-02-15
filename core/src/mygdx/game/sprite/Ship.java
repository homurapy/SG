package mygdx.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import mygdx.game.base.Sprite;
import mygdx.game.math.Rect;

public class Ship extends Sprite {

    private static final float HEIGHT = 0.2f;
    private static final float PADDING = 0.03f;
    private TextureRegion region;
    private Vector2 v;
    private Vector2 touch ;


    public Ship(TextureRegion region) {
        super(region);
        v=new Vector2();
        touch = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + PADDING);
    }

    @Override
    public void update(float delta) {
        System.out.println(touch);
        System.out.println(pos);
        if (pos.x != touch.x) {
            if (Math.abs(pos.x - touch.x) > Math.abs(v.x)) {
                pos.x += v.x;
            }
            else {pos.x = touch.x;}
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
    this.touch.set(touch);
    v.set(this.touch.cpy().sub(pos)).scl(0.01f);
        return false;
    }
}
