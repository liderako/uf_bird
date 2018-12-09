package com.student.asvirido.game.model.object.type.enemy;

import com.badlogic.gdx.Gdx;
import com.student.asvirido.game.model.object.GameObjectBuilder;
import com.student.asvirido.game.model.object.type.Bird;

public class Sky extends Enemy {

    public Sky(final GameObjectBuilder gameObjectBuilder) {
        super(gameObjectBuilder);
    }

    public boolean colider(final Bird bird) {
        Gdx.app.log("a", "b");
        if (position.y > bird.getY() + bird.getHeight()) {
            return (true);
        }
        return (false);
    }
}
