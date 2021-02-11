package mygdx.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import mygdx.game.base.BaseScreen;
import mygdx.game.base.Sprite;
import mygdx.game.math.Rect;

public class Logo extends Sprite {
    private Vector2 v= new Vector2();
    private Vector2 base;

    public Logo (Texture texture) { super(new TextureRegion(texture));

    }
    @Override
    public void resize(Rect worldBounds) {
        this.pos.set(worldBounds.pos);
        setHeightProportion(0.3f);
    }
    public void move(Vector2 vector2) {
        if(!vector2.equals(pos)) {
            v = v.set(vector2.x - pos.x, vector2.y - pos.y).scl(0.1f);
            if (Math.abs(v.len() + pos.len()) < vector2.len()) {
                pos.x += v.x;
                pos.y += v.y;
            } else {
                pos.x = vector2.x;
                pos.y = vector2.y;
            }
        }
        }



}
