package com.student.asvirido.game.model;

import com.badlogic.gdx.math.Vector2;
import com.student.asvirido.game.model.object.type.Bird;


public class Model {
    private Bird bird;

    public Model(int midPointY) {
        bird = new Bird(new Vector2(33, midPointY - 5));
    }

    public void update(final float delta) {
        bird.move(delta);
    }

    public final Bird getBird() {
        return (bird);
    }
}
