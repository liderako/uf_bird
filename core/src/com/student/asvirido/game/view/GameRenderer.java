package com.student.asvirido.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.student.asvirido.game.model.Model;

public class GameRenderer {
    private Model model;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    public GameRenderer(Model model) {
        this.model = model;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, 204);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    public void render() {

    }

    private void blackScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
