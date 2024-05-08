package org.example.Model;

import javafx.animation.Transition;
import javafx.scene.shape.Rectangle;

public class JetBomb extends Rectangle {

    private final int height = 40;
    private final int width = 10;
    private final Game game;
    private double xSpeed;
    private double ySpeed;
    private Transition bombMove;
    //private BombExplosionAnim bombExplosionAnim;

    public JetBomb(Game game) {
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

    public Transition getBombMove() {
        return bombMove;
    }

//    public BombExplosionAnim getBombExplosionAnim() {
//        return bombExplosionAnim;
//    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setBombMove(Transition bombMove) {
        this.bombMove = bombMove;
    }

//    public void setBombExplosionAnim(BombExplosionAnim bombExplosionAnim) {
//        this.bombExplosionAnim = bombExplosionAnim;
//    }

    public void explodeBomb() {}
}
