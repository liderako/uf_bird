package com.student.asvirido.game.model.object;

import com.badlogic.gdx.math.Vector2;

public class GameObject {
    protected String type;
    protected Vector2 position;
    protected Vector2 speed;
    protected Vector2 acceleration;
    protected int width;
    protected int height;

    public GameObject(final GameObjectBuilder gameObjectBuilder) {
        this.type = gameObjectBuilder.getType();
        this.speed = gameObjectBuilder.getSpeed();
        this.position = gameObjectBuilder.getPosition();
        this.acceleration = gameObjectBuilder.getAcceleration();
        this.width = gameObjectBuilder.getWidth();
        this.height = gameObjectBuilder.getHeight();
    }

    public int getWidth() {
        return (width);
    }

    public int getHeight() {
        return (height);
    }

    public Vector2 getSpeed() {
        return (speed);
    }

    public float getX() {
        return (position.x);
    }

    public float getY() {
        return (position.y);
    }

    public String getType() {
        return (type);
    }
}
