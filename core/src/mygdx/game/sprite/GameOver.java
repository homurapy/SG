package mygdx.game.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import mygdx.game.base.BaseButton;
import mygdx.game.math.Rect;
import mygdx.game.screen.GameScreen;

public class GameOver extends BaseButton {

    private static final float HEIGHT = 0.1f;


    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);

        setWidth(worldBounds.getHalfWidth());
    }

    @Override
    public void action() {

    }
}
