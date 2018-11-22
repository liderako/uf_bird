package com.student.asvirido.game.trash;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.student.asvirido.game.trash.GameOverView;
import com.student.asvirido.game.trash.StartView;

public class ZBGame extends Game {
    @Override
    public void create() {
        Gdx.app.log("ZBGame", "created");
        setScreen(new StartView());
        setScreen(new GameOverView());
    }
}
