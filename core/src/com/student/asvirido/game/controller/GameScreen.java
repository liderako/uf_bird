package com.student.asvirido.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.student.asvirido.game.model.Model;
import com.student.asvirido.game.view.GameRenderer;

public class GameScreen implements Screen {
    private GameRenderer gameRenderer;
    private Model model;

    public GameScreen() {
        Gdx.app.log("gamescreen view", "init");
//        model = new Model(Gdx.graphics.getWidth() и Gdx.graphics.getHeight());
        gameRenderer = new GameRenderer(model);
    }

    @Override
    public void render(float delta) {
        Gdx.app.log("GameScreen FPS", (1 / delta) + " ");

        Gdx.gl.glClearColor(255, 255.0f, 230, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        model.update(delta);
        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
    }
}
