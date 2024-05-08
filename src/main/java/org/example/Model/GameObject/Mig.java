package org.example.Model.GameObject;

import javafx.animation.Transition;
import javafx.scene.shape.Rectangle;
import org.example.Model.Game;

public class Mig extends Rectangle {
    private final int height = 30;
    private final int width = 100;
    private int xSpeed = 5;
    private double radius;
    private int fireRate;
    private final Game game;
    private boolean isFrozen;
    private boolean isHit;
    private Transition migMoveTransition;
    //private migExplosionAnim migExplosion;

    public Mig(Game game) {
        this.game = game;
        isFrozen = false;
        isHit = false;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public double getRadius() {
        return radius;
    }

    public int getFireRate() {
        return fireRate;
    }

    public Game getGame() {
        return game;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public boolean isHit() {
        return isHit;
    }

    public Transition getMigMoveTransition() {
        return migMoveTransition;
    }

//    public migExplosionAnim getMigExplosion() {
//        return migExplosion;
//    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public void setMigMoveTransition(Transition migMoveTransition) {
        this.migMoveTransition = migMoveTransition;
    }

//    public void setMigExplosion(migExplosionAnim migExplosion) {
//        this.migExplosion = migExplosion;
//    }

    public void shootBullet() {}

    public void explodeMig() {}

    public void getIncomingWarning() {}
}
