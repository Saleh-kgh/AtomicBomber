package org.example.Model.GameObject;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import org.example.Model.Game;

public class Truck extends Vehicle {

    public Truck(Game game, int direction) {
        super(120, 37, game, direction);
        this.setFill(new ImagePattern(new Image
                (Jet.class.getResource("/Pics/Objects/Truck.png").toExternalForm())));

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
}
