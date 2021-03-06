package com.student.asvirido.game.model.object.type.enemy;

import com.student.asvirido.game.model.object.GameObjectBuilder;
import com.student.asvirido.game.model.object.type.Bird;

public class Ground extends Enemy {

    public Ground(final GameObjectBuilder gameObjectBuilder) {
        super(gameObjectBuilder);
    }

    public boolean colider(final Bird bird) {
        if (position.y < bird.getY() + bird.getHeight() - 1) {
            return (true);
        }
        return (false);
    }
}
