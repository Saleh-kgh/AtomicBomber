package org.example.Controller;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.example.Model.BPM;
import org.example.Model.Game;
import org.example.Model.Jet;
import org.example.Model.Wave;
import org.example.View.Transitions.BPMTransition;

public class GameController {

    public void designWave1 (Wave wave1) {
        wave1.getPane().setBackground(new Background(createBackgroundImage()));
        wave1.getPane().getChildren().add(wave1.getGame().getJet());
        BPM Bpm1 = createBPM(wave1.getGame(), -1);
        wave1.getPane().getChildren().add(Bpm1);
        Bpm1.getBPMTransition().play();
    }

    public void designWave2 (Wave wave2) {

    }

    public void designWave3 (Wave wave3) {

    }

    public void setJetDirectionUp(Jet jet) {
        jet.getJetTransition().setDegreeAngle(jet.getJetTransition().getDegreeAngle() - 5);
    }

    public void setJetDirectionDown(Jet jet) {
        jet.getJetTransition().setDegreeAngle(jet.getJetTransition().getDegreeAngle() + 5);
    }

    private BackgroundImage createBackgroundImage () {
        Image image = new Image(GameController.class.getResource("/Pics/Backgrounds/dayForest.jpg").toExternalForm(), 1570 ,900, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return backgroundImage;
    }

    private BPM createBPM(Game game, int direction) {
        BPM Bpm = new BPM(game, direction);
        Bpm.setBPMTransition(new BPMTransition(Bpm, game, game.getGamePane()));
        return Bpm;
    }
}
