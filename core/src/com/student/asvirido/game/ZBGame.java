package com.student.asvirido.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.student.asvirido.game.controller.Controller;
import com.student.asvirido.game.view.AssetLoader;

public class ZBGame extends Game {
    @Override
    public void create() {
        Gdx.app.log("ZBGame", "created");
        AssetLoader.load();
        setScreen(Controller.getController());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
