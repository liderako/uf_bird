package com.student.asvirido.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.student.asvirido.game.model.Model;
import com.student.asvirido.game.view.GameRenderer;

public class Controller implements Screen {
    private static Controller controller = new Controller();
    private GameRenderer gameRenderer;
    private Model model;

    private float runTime;
    private final float gameWidth = 136;

    public Controller() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        runTime = 0;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);
        model = new Model(midPointY);
        gameRenderer = new GameRenderer((int) gameHeight, midPointY );
        Gdx.input.setInputProcessor(new InputHandler());
    }

    public static Controller getController() {
        return (controller);
    }

    public void onClickBird() {
        model.onClickBird();
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        model.update(delta);
        gameRenderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("Controller", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("Controller", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("Controller", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("Controller", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("Controller", "resume called");
    }

    @Override
    public void dispose() {
    }
}
