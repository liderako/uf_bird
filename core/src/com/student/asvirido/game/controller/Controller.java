package com.student.asvirido.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.student.asvirido.game.model.Model;
import com.student.asvirido.game.view.AssetLoader;
import com.student.asvirido.game.view.GameRenderer;
import com.student.asvirido.game.view.StartRenderer;

public class Controller implements Screen {
    private static Controller controller = new Controller();
    private GameRenderer gameRenderer;
    private StartRenderer startRenderer;
    private Model model;

    private float runTime;
    private final float gameWidth = 136;
    private String statusView = "Start";
    private float gameHeight;
    private int midPointY;
    public Controller() {
        init();
    }

    public static Controller getController() {
        return (controller);
    }

    public void onClickBird() {
        if (statusView.equals("Game") && Model.isAlive()) {
            model.onClickBird();
            AssetLoader.flap.play();
        }
        else if (statusView.equals("Start")) {
            statusView = "Game";
        }
        else if (statusView.equals("GameOver")) {
            statusView = "Start";
            init();
        }
    }

    @Override
    public void render(float delta) {
        if (statusView.equals("Start")) {
            runTime += delta;
            startRenderer.render(runTime, delta);
        }
        else if (statusView.equals("Game")) {
            runTime += delta;
            model.update(delta);
            gameRenderer.render(runTime);
            if (!Model.isAlive()) {
                statusView = "GameOver";
            }
        }
        else {
            gameRenderer.render(0);
        }
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

    private void init() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        runTime = 0;
        gameHeight = screenHeight / (screenWidth / gameWidth);

        midPointY = (int) (gameHeight / 2);
        model = new Model(midPointY);
        gameRenderer = new GameRenderer((int) gameHeight, midPointY );
        startRenderer = new StartRenderer((int) gameHeight, midPointY );
        Gdx.input.setInputProcessor(new InputHandler());
    }

    public String getStatusView() {
        return statusView;
    }
}
