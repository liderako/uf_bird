package com.student.asvirido.game.model.object.type.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.student.asvirido.game.model.object.GameObjectBuilder;

import java.util.Random;

public class Pipes extends Enemy {
    private Random random;
    private Rectangle skullUp, skullDown, barUp, barDown;
    private float groundY;

    public static final int VERTICAL_GAP = 45;
    public static final int SKULL_WIDTH = 24;
    public static final int SKULL_HEIGHT = 11;

    public Pipes(final GameObjectBuilder gameObjectBuilder, float groundY) {
        super(gameObjectBuilder);
        random = new Random();
        skullUp = new Rectangle();
        skullDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();
        this.groundY = groundY;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        barUp.set(
                position.x,
                position.y,
                width,
                height
        );
        barDown.set(
                position.x,
                position.y + height + VERTICAL_GAP,
                width,
                groundY - (position.y + height + VERTICAL_GAP)
        );
        skullUp.set(
                position.x - (SKULL_WIDTH - width) / 2,
                position.y + height - SKULL_HEIGHT,
                SKULL_WIDTH,
                SKULL_HEIGHT
        );
        skullDown.set(
                position.x - (SKULL_WIDTH - width) / 2,
                barDown.y,
                SKULL_WIDTH,
                SKULL_HEIGHT
        );
    }

    @Override
    public void reset(float newX) {
        super.reset(newX);
        height = random.nextInt(90) + 15;
    }

    public Rectangle getSkullUp() {
        return skullUp;
    }

    public Rectangle getSkullDown() {
        return skullDown;
    }

    public Rectangle getBarUp() {
        return barUp;
    }

    public Rectangle getBarDown() {
        return barDown;
    }
}
