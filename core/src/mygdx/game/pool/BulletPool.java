package mygdx.game.pool;

import mygdx.game.base.SpritesPool;
import mygdx.game.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

}
