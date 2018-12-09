package com.student.asvirido.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.student.asvirido.game.controller.Controller;
import com.student.asvirido.game.model.Model;
import com.student.asvirido.game.model.object.type.enemy.Pipes;

public class GameRenderer {
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private int midPointY;

    // Game Assets
    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid;
    private TextureRegion skullUp, skullDown, bar;
    private int viewPortWidth = 136;
    public GameRenderer(int gameHeight, int midPointY) {

        this.midPointY = midPointY;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, viewPortWidth, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        initAssets();
    }


    public void render(float runTime) {
        blackScreen();

        renderShapeRenderer();
        renderTextureObjects(runTime);
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
        renderPipes();
        renderCurrentScope("" + Model.getAmountPoint());
        if (Controller.getController().getStatusView().equals("GameOver")) {
            renderGameOver();
        }
        batcher.end();
    }

    private void renderCurrentScope(String amount) {
        AssetLoader.shadow.draw(batcher, amount, (viewPortWidth / 2) - (3 * amount.length()), 12);
        AssetLoader.font.draw(batcher, "" + amount,
                (viewPortWidth / 2) - (3 * amount.length() - 1), 11);
    }

    private void renderGameOver() {
        AssetLoader.shadow.draw(batcher, "Game Over", viewPortWidth / 6,50);
        AssetLoader.font.draw(batcher, "Game Over", viewPortWidth / 6,50);

        AssetLoader.shadow.draw(batcher, "Try again?", viewPortWidth / 6,70);
        AssetLoader.font.draw(batcher, "Try again?", viewPortWidth / 6,70);
    }

    private void renderGrass() {
        for (int i = 0; i < Model.getPipesHandler().getGrounds().size(); i++) {
            batcher.draw(
                    grass,
                    Model.getPipesHandler().getGrounds().get(i).getX(),
                    Model.getPipesHandler().getGrounds().get(i).getY(),
                    Model.getPipesHandler().getGrounds().get(i).getWidth(),
                    Model.getPipesHandler().getGrounds().get(i).getHeight()
            );
        }
    }

    private void renderPipes() {
        for (int i = 0; i < Model.getPipesHandler().getPipes().size(); i++) {
            renderBar(i);
            batcher.draw(
                    skullUp,
                    Model.getPipesHandler().getPipes().get(i).getX() - 1,
                    Model.getPipesHandler().getPipes().get(i).getY() + Model.getPipesHandler().getPipes().get(i).getHeight() - Pipes.SKULL_HEIGHT,
                    Pipes.SKULL_WIDTH,
                    Pipes.SKULL_HEIGHT
            );
            batcher.draw(
                    skullDown,
                    Model.getPipesHandler().getPipes().get(i).getX() - 1,
                    Model.getPipesHandler().getPipes().get(i).getY() + Model.getPipesHandler().getPipes().get(i).getHeight() + Pipes.VERTICAL_GAP,
                    Pipes.SKULL_WIDTH,
                    Pipes.SKULL_HEIGHT);
        }
    }

    private void renderBar(int i) {
        batcher.enableBlending();
        batcher.draw(
                bar,
                Model.getPipesHandler().getPipes().get(i).getX(),
                Model.getPipesHandler().getPipes().get(i).getY(),
                Model.getPipesHandler().getPipes().get(i).getWidth(),
                Model.getPipesHandler().getPipes().get(i).getHeight()
        );
        batcher.draw(
                bar,
                Model.getPipesHandler().getPipes().get(i).getX(),
                Model.getPipesHandler().getPipes().get(i).getY() + Model.getPipesHandler().getPipes().get(i).getHeight() + Pipes.VERTICAL_GAP,
                Model.getPipesHandler().getPipes().get(i).getWidth(),
                midPointY + 66 - (Model.getPipesHandler().getPipes().get(i).getHeight() + Pipes.VERTICAL_GAP)
        );
    }

    private void renderBackground() {
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, midPointY + 23, viewPortWidth, 43);
    }

    private void renderBird(float runTime) {
        batcher.enableBlending();
        if (Model.getBird().shouldntFlap()) {
            batcher.draw(
                    birdMid,
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
        else {
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
        skullUp = AssetLoader.skullUp;
        skullDown = AssetLoader.skullDown;
        bar = AssetLoader.bar;
    }

}
