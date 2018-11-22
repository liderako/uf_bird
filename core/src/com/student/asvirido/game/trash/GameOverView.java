package com.student.asvirido.game.trash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameOverView implements Screen {
    public GameOverView() {
        Gdx.app.log("start view", "init");
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255.0f, 255.0f, 0, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameOverView", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameOverView", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameOverView", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameOverView", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameOverView", "resume called");
    }

    @Override
    public void dispose() {
    }
}