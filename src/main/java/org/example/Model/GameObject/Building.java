package org.example.Model.GameObject;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import org.example.Model.Game;

public class Building extends Facility {

    private final int height = 80;
    private final int width = 300;

    public Building(Game game) {
        super(game);

        this.setFill(new ImagePattern(new Image
                (Jet.class.getResource("/Pics/Objects/Building.png").toExternalForm())));
    }
}
