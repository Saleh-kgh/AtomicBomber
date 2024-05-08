package org.example.View.Transitions;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.example.Model.*;
import org.example.View.Animations.BombRegularExplosion;

import java.util.ArrayList;

public class BombTransition extends Transition {

    private Jet jet;
    private final Bomb bomb;
    private final double velocityX;
    private double velocityY;
    private final  double gravity = 10;
    private double degreeAngle;
    private Game game;
    private Pane gamePane;
    private final int duration = 10;

    public BombTransition(Bomb bomb, Jet jet, Game game, Pane gamePane) {
        this.bomb = bomb;
        this.jet = jet;
        this.game = game;
        this.gamePane = gamePane;
        this.velocityX = jet.getJetTransition().getVelocityX() * 1.4;
        this.velocityY = 0;
        this.degreeAngle = jet.getJetTransition().getDegreeAngle();
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public double getDegreeAngle() {
        return degreeAngle;
    }

    public void setDegreeAngle(double degreeAngle) {
        this.degreeAngle = degreeAngle;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    @Override
    protected void interpolate(double v) {
        bomb.setRotate(degreeAngle);

        double elapsedTime = v * getCycleDuration().toSeconds();
        setVelocityY(velocityY + gravity * elapsedTime * 10);

        double deltaX = elapsedTime * velocityX;
        double deltaY = elapsedTime * velocityY;

        setDegreeAngle(getDegreeAngle() + (deltaX < 0 ? -3 : 1.5) * 0.1);

        if (bomb.getX() + deltaX <= gamePane.getScene().getWidth() && bomb.getX() + deltaX + 100 >= 0)
            bomb.setX(bomb.getX() + deltaX);
        else if (jet.getX() + deltaX < 0)
            gamePane.getChildren().remove(bomb);
        else if (bomb.getX() + deltaX > gamePane.getScene().getWidth() - bomb.getWidth())
            gamePane.getChildren().remove(bomb);


        if (bomb.getY() + deltaY + 80 > 0 && bomb.getY() + deltaY < 700)
            bomb.setY(bomb.getY() + deltaY);
        else if (bomb.getY() + deltaY > 700) {
            collision();
        }
    }

    public void collision() {

        if (bomb.isHit())
            return;
        bomb.setHit(true);
        bomb.getBombTransition().stop();
        bomb.explodeBomb();
        destroyNearObjects();
    }

    private void destroyNearObjects() {
        destroyBpms();
//        destroyTanks();
//        destroyBunkers();
//        destroyBuildings();
    }

    private void destroyBpms() {
        ArrayList<BPM> destroyedBPMs = new ArrayList<>();
        for (BPM Bpm : game.getCurrentWave().getBpms())
            if (Math.abs(Bpm.getX() - bomb.getX()) < bomb.getRadius())
                destroyedBPMs.add(Bpm);
        game.getCurrentWave().getBpms().removeAll(destroyedBPMs);
        for (BPM Bpm : destroyedBPMs)
            Bpm.getVehicleTransition().collision();
    }

//    private void destroyTanks() {
//        ArrayList<Tank> destroyedTanks = new ArrayList<>();
//        for (Tank tank : game.getCurrentWave().getTanks())
//            if (Math.abs(tank.getX() - bomb.getX()) < bomb.getRadius())
//                destroyedTanks.add(tank);
//        game.getCurrentWave().getTanks().removeAll(destroyedTanks);
//        for (Tank tank : destroyedTanks)
//            tank.gettankTransition().collision();
//    }

//    private void destroyBunkers() {
//        ArrayList<BPM> destroyedBPMs = new ArrayList<>();
//        for (BPM Bpm : game.getCurrentWave().getBpms())
//            if (Math.abs(Bpm.getX() - bomb.getX()) < bomb.getRadius())
//                destroyedBPMs.add(Bpm);
//        game.getCurrentWave().getBpms().removeAll(destroyedBPMs);
//        for (BPM Bpm : game.getCurrentWave().getBpms())
//            Bpm.getBpmTransition().collision();
//    }
//
//    private void destroyBuildings() {
//        ArrayList<BPM> destroyedBPMs = new ArrayList<>();
//        for (BPM Bpm : game.getCurrentWave().getBpms())
//            if (Math.abs(Bpm.getX() - bomb.getX()) < bomb.getRadius())
//                destroyedBPMs.add(Bpm);
//        game.getCurrentWave().getBpms().removeAll(destroyedBPMs);
//        for (BPM Bpm : game.getCurrentWave().getBpms())
//            Bpm.getBpmTransition().collision();
//    }
}
