package org.example.Model;

import javafx.animation.Transition;
import javafx.scene.shape.Rectangle;

public class GroundTank extends Rectangle {

    private final int height = 50;
    private final int width = 200;
    private int xSpeed = 5;
    private final Game game;
    private boolean isFrozen;
    private boolean isHit;
    private Transition groundTankMoveTransition;
    //private GroundTankExplosionAnim groundTankExplosion;

    public GroundTank(Game game) {
        this.game = game;
        this.isFrozen = false;
        this.isHit = false;
    }

    public Game getGame() {
        return game;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public void explodeTank() {

    }
}
