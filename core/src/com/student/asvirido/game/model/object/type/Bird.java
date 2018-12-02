package com.student.asvirido.game.model.object.type;

import com.badlogic.gdx.math.Vector2;
import com.student.asvirido.game.model.object.GameObject;
import com.student.asvirido.game.model.object.GameObjectBuilder;

public class Bird extends GameObject {
    private float rotation;

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
    }

    public void move(float delta) {
        speed.add(acceleration.cpy().scl(delta));
        if (speed.y > 200) {
            speed.y = 200;
        }
        position.add(speed.cpy().scl(delta));
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    public float getRotation() {
        return rotation;
    }
}
