package org.example.Model;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class BPM extends Rectangle {

    private final int height = 50;
    private final int width = 200;
    private final int direction;
    private double radius;
    private int fireRate;
    private final Game game;
    private boolean isFrozen;
    private boolean isHit;
    private Transition BPMTransition;
    //private AttackTankExplosionAnim attackTankExplosion;

    public BPM(Game game, int direction) {
        super(150, 50);
        this.game = game;
        this.direction = direction;
        isFrozen = false;
        isHit = false;

        this.setFill(new ImagePattern(new Image
                (Jet.class.getResource("/Pics/Objects/russianBPM.png").toExternalForm())));

        setY(700);
        switch (direction) {
            case 1:
                setX(150);
                break;
            case -1:
                setX(1720);
                this.setScaleX(-1);
                break;
        }
    }

    public int getDirection() {
        return direction;
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

    public Transition getBPMTransition() {
        return BPMTransition;
    }

//    public AttackTankExplosionAnim getAttackTankExplosion() {
//        return attackTankExplosion;
//    }

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

    public void setBPMTransition(Transition BPMTransition) {
        this.BPMTransition = BPMTransition;
    }

//    public void setAttackTankExplosion(AttackTankExplosionAnim attackTankExplosion) {
//        this.attackTankExplosion = attackTankExplosion;
//    }

    public void explodeAttackTank() {

    }

    public void shootBullet() {

    }
}
