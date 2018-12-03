package com.student.asvirido.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.student.asvirido.game.model.object.PipesHandler;
import com.student.asvirido.game.model.object.type.Bird;


public class Model {
    static private Model model;
    static private Bird bird;
    static private PipesHandler pipesHandler;

    public Model(int midPointY) {
        bird = new Bird(new Vector2(33, midPointY - 5));
        pipesHandler = new PipesHandler(midPointY + 66);
    }

    static public void update(final float delta) {
        bird.move(delta);
        pipesHandler.update(delta);
    }

    static public void onClickBird() {
        bird.setSpeed(new Vector2(0, bird.getSpeed().y - 140));
    }

    static public PipesHandler getPipesHandler() {
        return (pipesHandler);
    }

    static public Bird getBird() {
        return (bird);
    }
}
