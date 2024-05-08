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
                setX(-250);
                break;
            case -1:
                setX(1780);
                this.setScaleX(-1);
                break;
        }
    }

    @Override
    public void activateNext() {
        int index = 0;
        for (Truck truck : getGame().getCurrentWave().getTrucks())
            if (truck.equals(this))
                index = getGame().getCurrentWave().getTrucks().indexOf(this) + 1;
        if (getGame().getCurrentWave().getTrucks().size() > index)
            getGame().getCurrentWave().getTrucks().get(index).getVehicleTransition().play();
    }
}
