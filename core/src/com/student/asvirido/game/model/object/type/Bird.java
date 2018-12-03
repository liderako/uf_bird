package com.student.asvirido.game.model.object.type;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.student.asvirido.game.model.object.GameObject;
import com.student.asvirido.game.model.object.GameObjectBuilder;

public class Bird extends GameObject {
    private float rotation;
    private Circle boundingCircle;

    public Bird(Vector2 position) {
        super(
                new GameObjectBuilder()
                        .type("Bird")
                        .width(17)
                        .height(12)
                        .acceleration(new Vector2(0, 460))
                        .position(position)
                        .speed(new Vector2(0, 0))
        );
        boundingCircle = new Circle();
    }

    public void move(float delta) {
        speed.add(acceleration.cpy().scl(delta));
        if (speed.y > 200) {
            speed.y = 200;
        }
        position.add(speed.cpy().scl(delta));
        boundingCircle.set(position.x + 9, position.y + 6, 6.5f);
        if (speed.y < 0) {
            rotation -= 400 * delta;
            if (rotation < -20) {
                rotation = -20;
            }
        }
        if (isFalling()) {
            rotation += 200 * delta;
            if (rotation > 20) {
                rotation = 20;
            }
        }
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    public float getRotation() {
        return rotation;
    }

    public boolean isFalling() {
        return speed.y > 110;
    }

    public boolean shouldntFlap() {
        return speed.y > 70;
    }

    public Circle getBoundingCircle() {
        return  boundingCircle;
    }
}
