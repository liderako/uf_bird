package com.student.asvirido.game.model.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.student.asvirido.game.model.object.type.enemy.Ground;
import com.student.asvirido.game.model.object.type.enemy.Pipes;
import com.sun.org.apache.bcel.internal.generic.GotoInstruction;

import java.util.ArrayList;

import javax.swing.text.Position;

public class PipesHandler {
    private ArrayList<Ground> grounds = new ArrayList<Ground>();
    private ArrayList<Pipes> pipes = new ArrayList<Pipes>();

    public static final int SCROLL_SPEED = -59;
    public static final int PIPE_GAP = 49;

    public PipesHandler() {
        Gdx.app.log("Pipes", "Default");
    }

    public PipesHandler(float yPos) {
        Vector2 speed = new Vector2(SCROLL_SPEED, 0);
        Vector2 acceleration = new Vector2(0, 0);
        Vector2 position;

        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                position = new Vector2(grounds.get(0).getTailX(), yPos);
            }
            else {
                position = new Vector2(0, yPos);
            }
            grounds.add(
                    new Ground(
                            new GameObjectBuilder()
                                    .acceleration(acceleration)
                                    .speed(speed)
                                    .position(position)
                                    .width(143)
                                    .height(11)
                    )
            );
        }
        for (int i = 0; i < 3; i++) {
            position = new Vector2(210, 0);
            if (i >= 1) {
                position.x = pipes.get(i - 1).getTailX() + PIPE_GAP;
            }
            pipes.add(
                    new Pipes(
                            new GameObjectBuilder()
                            .acceleration(acceleration)
                            .speed(speed).type("pipes").width(22)
                            .height(60)
                            .position(position)
                            ,yPos
                    )
            );
        }
    }

    public void update(float delta) {
        for (int i = 0; i < grounds.size(); i++) {
            grounds.get(i).update(delta);
        }

        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).update(delta);
        }

        if (pipes.get(0).isScrolledLeft()) {
            pipes.get(0).reset(pipes.get(2).getTailX() + PIPE_GAP);
        }
        if (pipes.get(1).isScrolledLeft()) {
            pipes.get(1).reset(pipes.get(0).getTailX() + PIPE_GAP);
        }
        if (pipes.get(2).isScrolledLeft()) {
            pipes.get(2).reset(pipes.get(1).getTailX() + PIPE_GAP);
        }
        if (grounds.get(0).isScrolledLeft()) {
            grounds.get(0).reset(grounds.get(1).getTailX());

        } else if (grounds.get(1).isScrolledLeft()) {
            grounds.get(1).reset(grounds.get(0).getTailX());
        }
    }

    public ArrayList<Ground> getGrounds() {
        return (grounds);
    }

    public ArrayList<Pipes> getPipes() {
        return (pipes);
    }
}
