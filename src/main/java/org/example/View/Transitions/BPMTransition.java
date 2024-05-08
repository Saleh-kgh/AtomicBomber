package org.example.View.Transitions;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.example.Model.BPM;
import org.example.Model.Game;
import org.example.View.Animations.BPMExplosion;
import org.example.View.Animations.JetExplosion;

public class BPMTransition extends Transition {

    private BPM Bpm;
    private final double velocityX = 50;
    private final int direction;
    private Game game;
    private Pane gamePane;
    private final int duration = 10;

    public BPMTransition(BPM Bpm, Game game, Pane gamePane) {
        this.Bpm = Bpm;
        this.game = game;
        this.gamePane = gamePane;
        this.direction = Bpm.getDirection();
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    public double getVelocityX() {
        return velocityX;
    }

    @Override
    protected void interpolate(double v) {
        double elapsedTime = v * getCycleDuration().toSeconds();

        double deltaX = elapsedTime * velocityX * Bpm.getDirection();

        if (Bpm.getX() + deltaX <= gamePane.getScene().getWidth() + 500 && Bpm.getX() + deltaX + 500 >= 0)
            Bpm.setX(Bpm.getX() + deltaX);

        else if (Bpm.getX() + deltaX + 500 < 0) {
            Bpm.getGame().getGamePane().getChildren().remove(Bpm);
        }

        else if (Bpm.getX() + deltaX > gamePane.getScene().getWidth() + 500){
            Bpm.getGame().getGamePane().getChildren().remove(Bpm);
        }

        if (Bpm.intersects(game.getJet().getBoundsInParent())) {
            collision();
            game.getJet().getJetTransition().collision();
        }

    }

    public void collision() {
        if (Bpm.isHit())
            return;
        Bpm.setHit(true);
        Bpm.getBpmTransition().stop();

        BPMExplosion BpmExplosion = new BPMExplosion(Bpm, gamePane);
        BpmExplosion.play();
    }
}
