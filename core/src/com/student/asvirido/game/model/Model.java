package com.student.asvirido.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.student.asvirido.game.model.object.GameHandler;
import com.student.asvirido.game.model.object.type.Bird;
import com.student.asvirido.game.view.AssetLoader;

public class Model {
    static private Bird bird;
    static private GameHandler gameHandler;
    static private boolean alive;
    static private int amountPoint;

    public Model(int midPointY) {
        bird = new Bird(new Vector2(33, midPointY - 5));
        gameHandler = new GameHandler(midPointY + 66);
        alive = true;
        amountPoint = 0;
    }

    static public void update(final float delta) {
        bird.move(delta);
        gameHandler.update(delta);
        if (gameHandler.colider(bird)) {
            alive = false;
            AssetLoader.dead.play();
        }
        if (gameHandler.coliderPoint(bird)) {
            AssetLoader.coin.play();
            amountPoint++;
            Gdx.app.log("amount", "" + amountPoint);
        }
    }

    static public void onClickBird() {
        bird.setSpeed(new Vector2(0, bird.getSpeed().y - 140));
    }

    static public GameHandler getPipesHandler() {
        return (gameHandler);
    }

    static public boolean isAlive() {
        return (alive);
    }

    static public int getAmountPoint() {
        return (amountPoint);
    }

    static public Bird getBird() {
        return (bird);
    }
}
