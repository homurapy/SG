package mygdx.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import mygdx.game.base.BaseButton;
import mygdx.game.math.Rect;

public class ButtonExit extends BaseButton {

    private static final float HEIGHT = 0.2f;
    private static final float PADDING = 0.03f;

    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + PADDING);
        setRight(worldBounds.getRight() - PADDING);
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }
}
