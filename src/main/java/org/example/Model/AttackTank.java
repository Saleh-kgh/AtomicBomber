package org.example.Model;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class AttackTank extends Rectangle {

    private final int height = 50;
    private final int width = 200;
    private int xSpeed = 5;
    private double radius;
    private int fireRate;
    private final Game game;
    private boolean isFrozen;
    private boolean isHit;
    //private Transition attackTankMoveTransition;
    //private AttackTankExplosionAnim attackTankExplosion;

    public AttackTank(Game game) {
        super(461, 133);
        this.game = game;
        isFrozen = false;
        isHit = false;
        setX(400);
        setY(1500);
        this.setFill(new ImagePattern(new Image
                (Jet.class.getResource("/Pics/Objects/T-72GroundTank.png").toExternalForm())));
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

//    public Transition getAttackTankMoveTransition() {
//        return attackTankMoveTransition;
//    }

//    public AttackTankExplosionAnim getAttackTankExplosion() {
//        return attackTankExplosion;
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

//    public void setAttackTankMoveTransition(Transition attackTankMoveTransition) {
//        this.attackTankMoveTransition = attackTankMoveTransition;
//    }

//    public void setAttackTankExplosion(AttackTankExplosionAnim attackTankExplosion) {
//        this.attackTankExplosion = attackTankExplosion;
//    }

    public void explodeAttackTank() {

    }

    public void shootBullet() {

    }
}
