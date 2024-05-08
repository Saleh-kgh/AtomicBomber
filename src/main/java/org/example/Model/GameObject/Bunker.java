package org.example.Model.GameObject;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import org.example.Model.Game;

public class Bunker extends Facility {

    private final int height = 80;
    private final int width = 300;

    public Bunker(Game game, int x) {
        super(game, 130, 50, x);

        this.setFill(new ImagePattern(new Image
                (Jet.class.getResource("/Pics/Objects/Bunker.png").toExternalForm())));
    }
}
