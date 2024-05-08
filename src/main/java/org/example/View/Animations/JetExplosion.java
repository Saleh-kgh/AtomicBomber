package org.example.View.Animations;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import org.example.Model.Jet;

public class JetExplosion extends Transition {

    private Pane pane;
    private Jet jet;

    public JetExplosion(Jet jet, Pane pane) {
        this.jet = jet;
        this.pane = pane;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(1650));
    }

    @Override
    protected void interpolate(double v) {
        int number = 6;
        if (0 <= v && v <= 0.15) number = 6;
        else if (0.15 < v && v <= 0.3) number = 5;
        else if (0.3 < v && v <= 0.45) number = 4;
        else if (0.45 < v && v <= 0.6) number = 3;
        else if (0.6 < v && v <= 0.75) number = 2;
        else if (0.75 < v && v <= 0.9) number = 1;
        else if (0.9 < v && v <= 1.05) number = 2;
        else if (1.05 < v && v <= 1.2) number = 3;
        else if (1.2 < v && v <= 1.35) number = 4;
        else if (1.35 < v && v <= 1.5) number = 5;
        else if (1.5 < v && v <= 1.65) number = 6;

        jet.setWidth(100);
        jet.setHeight(100);
        jet.setFill(new ImagePattern(new Image(
                JetExplosion.class.getResource("/Frames/JetExplosion/destroy-" + number + ".png").toExternalForm())));

        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(jet);
            }
        });
    }
}
