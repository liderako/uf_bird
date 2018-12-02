package com.student.asvirido.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.student.asvirido.game.controller.GameScreen;

public class ZBGame extends Game {
    @Override
    public void create() {
        Gdx.app.log("ZBGame", "created");
        setScreen(new GameScreen());
    }
}
