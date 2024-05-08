package org.example.Model;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.example.View.Transitions.BPMTransition;

public class BPM extends Rectangle {

    private final int height = 50;
    private final int width = 200;
    private final int direction;
    private double radius;
    private int fireRate;
    private final Game game;
    private boolean isFrozen;
    private boolean isHit;
    private BPMTransition bpmTransition;

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

    public BPMTransition getBpmTransition() {
        return bpmTransition;
    }

    public void setBpmTransition(BPMTransition bpmTransition) {
        this.bpmTransition = bpmTransition;
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

    public void shootBullet() {

    }
}
