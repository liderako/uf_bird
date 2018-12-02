package com.student.asvirido.game.model.object;

import com.badlogic.gdx.math.Vector2;

public class GameObjectBuilder {
    private String type;
    private Vector2 position;
    private Vector2 speed;
    private Vector2 acceleration;
    private int width;
    private int height;


    public GameObjectBuilder type(final String type) {
        this.type = type;
        return (this);
    }

    public GameObjectBuilder speed(final Vector2 speed) {
        this.speed = speed;
        return (this);
    }

    public GameObjectBuilder position(final Vector2 position) {
        this.position = position;
        return (this);
    }

    public GameObjectBuilder acceleration(final Vector2 acceleration) {
        this.acceleration = acceleration;
        return (this);
    }

    public GameObjectBuilder width(final int width) {
        this.width = width;
        return (this);
    }

    public GameObjectBuilder height(final int height) {
        this.height = height;
        return (this);
    }

    public GameObject build() {
        return (new GameObject(this));
    }

    public Vector2 getSpeed() {
        return (speed);
    }

    public Vector2 getPosition() {
        return (position);
    }

    public Vector2 getAcceleration() {
        return (acceleration);
    }

    public String getType() {
        return (type);
    }

    public int getWidth() {
        return (width);
    }

    public int getHeight() {
        return (height);
    }
}
