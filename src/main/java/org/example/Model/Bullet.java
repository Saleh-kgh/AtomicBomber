package org.example.Model;

import javafx.animation.Transition;
import javafx.scene.shape.Rectangle;

public class Bullet extends Rectangle {

    private final int height = 10;
    private final int width = 4;
    private final Game game;
    private double xSpeed;
    private double ySpeed;
    private Transition bulletMove;
    //private BulletExplosionAnim bulletExplosionAnim;

    public Bullet(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public Transition getBulletMove() {
        return bulletMove;
    }

//    public BulletExplosionAnim getBulletExplosionAnim() {
//        return bulletExplosionAnim;
//    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setBulletMove(Transition bulletMove) {
        this.bulletMove = bulletMove;
    }

//    public void setBulletExplosionAnim(BulletExplosionAnim bulletExplosionAnim) {
//        this.bulletExplosionAnim = bulletExplosionAnim;
//    }

    public void explodeBullet() {}
}
