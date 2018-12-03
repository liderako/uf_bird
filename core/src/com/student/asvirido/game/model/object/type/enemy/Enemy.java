package com.student.asvirido.game.model.object.type.enemy;

import com.badlogic.gdx.math.Vector2;
import com.student.asvirido.game.model.object.GameObject;
import com.student.asvirido.game.model.object.GameObjectBuilder;

public class Enemy extends GameObject {
    protected boolean isScrolledLeft;
    public Enemy(final GameObjectBuilder gameObjectBuilder) {
        super(gameObjectBuilder);
    }

    public void update(float delta) {
        position.add(speed.cpy().scl(delta));
        if (position.x + width < 0) {
            isScrolledLeft = true;
        }
    }

    public boolean isScrolledLeft() {
        return isScrolledLeft;
    }

    public void reset(float newX) {
        position.x = newX;
        isScrolledLeft = false;
    }

    public float getTailX() {
        return position.x + width;
    }
}
