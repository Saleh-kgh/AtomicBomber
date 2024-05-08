package org.example.Model.GameObject;

import javafx.animation.Transition;
import javafx.scene.shape.Rectangle;
import org.example.Model.Game;
import org.example.View.Transitions.BombTransition;

public abstract class Bomb extends Rectangle {

    private final int height = 40;
    private final int width = 10;
    private final int radius;
    private Jet jet;
    private final Game game;
    private boolean isHit;
    private Transition bombTransition;
    //private BombExplosionAnim bombExplosionAnim;

    public Bomb(Jet jet, Game game, int radius) {
        super(40, 10);
        this.game = game;
        this.jet = jet;
        this.radius = radius;
        setX(jet.getX() + jet.getWidth()/2);
        setY(jet.getY());
        this.bombTransition = new BombTransition(this, jet, game, getGame().getGamePane());
    }

    public Game getGame() {
        return game;
    }

    public Jet getJet() {
        return jet;
    }

    public Transition getBombTransition() {
        return bombTransition;
    }

    public boolean isHit() {
        return isHit;
    }

    public int getRadius() {
        return radius;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public void setBombTransition(Transition bombTransition) {
        this.bombTransition = bombTransition;
    }

    abstract public void explodeBomb();
}
