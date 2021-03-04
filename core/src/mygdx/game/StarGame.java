package mygdx.game;

import com.badlogic.gdx.Game;

import mygdx.game.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

}
