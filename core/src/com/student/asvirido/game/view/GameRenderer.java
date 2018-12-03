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
import com.student.asvirido.game.model.object.type.enemy.Pipes;

public class GameRenderer {
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private int midPointY;
    private int gameHeight;

    // Game Assets
    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid, birdDown, birdUp;
    private TextureRegion skullUp, skullDown, bar;

    public GameRenderer(int gameHeight, int midPointY) {

        this.gameHeight = gameHeight;
        this.midPointY = midPointY;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, gameHeight);

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

        // testing
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(Model.getBird().getBoundingCircle().x, Model.getBird().getBoundingCircle().y, Model.getBird().getBoundingCircle().radius);



        /*
         * Извините за беспорядок ниже. Временный код для теста границ
         * прямоугольников.
         */
        // Верхний блок для труб 1, 2 и 3
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(0).getBarUp().x, Model.getPipesHandler().getPipes().get(0).getBarUp().y,
                Model.getPipesHandler().getPipes().get(0).getBarUp().width, Model.getPipesHandler().getPipes().get(0).getBarUp().height);
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(1).getBarUp().x, Model.getPipesHandler().getPipes().get(1).getBarUp().y,
                Model.getPipesHandler().getPipes().get(1).getBarUp().width, Model.getPipesHandler().getPipes().get(1).getBarUp().height);
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(2).getBarUp().x, Model.getPipesHandler().getPipes().get(2).getBarUp().y,
                Model.getPipesHandler().getPipes().get(2).getBarUp().width, Model.getPipesHandler().getPipes().get(2).getBarUp().height);

        // Нижний блок для труб 1, 2 и 3
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(0).getBarDown().x, Model.getPipesHandler().getPipes().get(0).getBarDown().y,
                Model.getPipesHandler().getPipes().get(0).getBarDown().width, Model.getPipesHandler().getPipes().get(0).getBarDown().height);
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(1).getBarDown().x, Model.getPipesHandler().getPipes().get(1).getBarDown().y,
                Model.getPipesHandler().getPipes().get(1).getBarDown().width, Model.getPipesHandler().getPipes().get(1).getBarDown().height);
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(2).getBarDown().x, Model.getPipesHandler().getPipes().get(2).getBarDown().y,
                Model.getPipesHandler().getPipes().get(2).getBarDown().width, Model.getPipesHandler().getPipes().get(2).getBarDown().height);

        // Черепа для верхних труб 1, 2 и 3
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(0).getSkullUp().x, Model.getPipesHandler().getPipes().get(0).getSkullUp().y,
                Model.getPipesHandler().getPipes().get(0).getSkullUp().width, Model.getPipesHandler().getPipes().get(0).getSkullUp().height);
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(1).getSkullUp().x, Model.getPipesHandler().getPipes().get(1).getSkullUp().y,
                Model.getPipesHandler().getPipes().get(1).getSkullUp().width, Model.getPipesHandler().getPipes().get(1).getSkullUp().height);
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(2).getSkullUp().x, Model.getPipesHandler().getPipes().get(2).getSkullUp().y,
                Model.getPipesHandler().getPipes().get(2).getSkullUp().width, Model.getPipesHandler().getPipes().get(2).getSkullUp().height);

        // Черепа для нижних труб 1, 2 and 3
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(0).getSkullDown().x, Model.getPipesHandler().getPipes().get(0).getSkullDown().y,
                Model.getPipesHandler().getPipes().get(0).getSkullDown().width, Model.getPipesHandler().getPipes().get(0).getSkullDown().height);
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(1).getSkullDown().x, Model.getPipesHandler().getPipes().get(1).getSkullDown().y,
                Model.getPipesHandler().getPipes().get(1).getSkullDown().width, Model.getPipesHandler().getPipes().get(1).getSkullDown().height);
        shapeRenderer.rect(Model.getPipesHandler().getPipes().get(2).getSkullDown().x, Model.getPipesHandler().getPipes().get(2).getSkullDown().y,
                Model.getPipesHandler().getPipes().get(2).getSkullDown().width, Model.getPipesHandler().getPipes().get(2).getSkullDown().height);

        shapeRenderer.end();
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
        batcher.end();
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
        batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);
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
        birdDown = AssetLoader.birdDown;
        birdUp = AssetLoader.birdUp;
        skullUp = AssetLoader.skullUp;
        skullDown = AssetLoader.skullDown;
        bar = AssetLoader.bar;
    }

}
