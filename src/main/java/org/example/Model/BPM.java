package org.example.Model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.example.View.Animations.VehicleExplosion;
import org.example.View.Transitions.VehicleTransition;

public class BPM extends Vehicle {

    private double radius;
    private int fireRate;

    public BPM(Game game, int direction) {
        super(150, 50, game, direction);
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


    public double getRadius() {
        return radius;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public void shootBullet() {

    }
}
