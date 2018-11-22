package com.student.asvirido.game.trash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class StartView implements Screen {
    public StartView() {
        Gdx.app.log("start view", "init");
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255.0f, 255.0f, 230, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("StartView", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("StartView", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("StartView", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("StartView", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("StartView", "resume called");
    }

    @Override
    public void dispose() {
    }
}
