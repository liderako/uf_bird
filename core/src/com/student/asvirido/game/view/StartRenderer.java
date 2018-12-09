package com.student.asvirido.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.student.asvirido.game.model.Model;
import com.student.asvirido.game.model.object.GameHandler;
import com.student.asvirido.game.model.object.type.enemy.Pipes;

public class StartRenderer {
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private int midPointY;

    // Game Assets
    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid;
    private GameHandler handler;

    public StartRenderer(int gameHeight, int midPointY) {

        this.midPointY = midPointY;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        handler = new GameHandler(midPointY + 66);
        initAssets();
    }


    public void render(float runTime, float delta) {
        blackScreen();
        renderShapeRenderer();
        renderTextureObjects(runTime);
        handler.update(delta);
    }

    private void renderShapeRenderer() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        renderShapeDirt();
        renderShapeBackground();
        shapeRenderer.end();
    }

    private void renderShapeDirt() {
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);
    }

    private void renderShapeBackground() {
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);
    }

    private void renderTextureObjects(final float runTime) {
        batcher.begin();
        renderBackground();
        renderBird(runTime);
        renderGrass();
        batcher.end();
    }

    private void renderGrass() {
        for (int i = 0; i < Model.getPipesHandler().getGrounds().size(); i++) {
            batcher.draw(
                    grass,
                    handler.getGrounds().get(i).getX(),
                    handler.getGrounds().get(i).getY(),
                    handler.getGrounds().get(i).getWidth(),
                    handler.getGrounds().get(i).getHeight()
            );
        }
    }


    private void renderBackground() {
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);
    }

    private void renderBird(float runTime) {
        batcher.enableBlending();
            batcher.draw(
                    (TextureRegion) birdAnimation.getKeyFrame(runTime),
                    Model.getBird().getX(),
                    Model.getBird().getY(),
                    Model.getBird().getWidth() / 2.0f,
                    Model.getBird().getHeight() / 2.0f,
                    Model.getBird().getWidth(),
                    Model.getBird().getHeight(),
                    1,
                    1,
                    Model.getBird().getRotation()
            );
    }

    private void blackScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void initAssets() {
        bg = AssetLoader.bg;
        grass = AssetLoader.grass;
        birdAnimation = AssetLoader.birdAnimation;
        birdMid = AssetLoader.bird;
    }

}
