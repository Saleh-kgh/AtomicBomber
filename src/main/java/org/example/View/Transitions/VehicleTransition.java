package org.example.View.Transitions;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.example.Model.Game;
import org.example.Model.GameObject.Vehicle;

public class VehicleTransition extends Transition {

    private Vehicle vehicle;
    private final double velocityX = 50;
    private int direction;
    private Game game;
    private Pane gamePane;
    private final int duration = 10;

    public VehicleTransition(Vehicle vehicle, Game game) {
        this.vehicle = vehicle;
        this.game = game;
        this.gamePane = game.getGamePane();
        this.direction = vehicle.getDirection();
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    public double getVelocityX() {
        return velocityX;
    }

    @Override
    protected void interpolate(double v) {
        double elapsedTime = v * getCycleDuration().toSeconds();

        double deltaX = elapsedTime * velocityX * direction;

        if (vehicle.getX() + deltaX <= gamePane.getScene().getWidth() + 500 && vehicle.getX() + deltaX + 500 >= 0)
            vehicle.setX(vehicle.getX() + deltaX);

        else if (vehicle.getX() + deltaX + 500 < 0) {
            vehicle.setScaleX(vehicle.getScaleX() * -1);
            direction = direction * -1;
            vehicle.setX(-250);
        }

        else if (vehicle.getX() + deltaX > gamePane.getScene().getWidth() + 500){
            vehicle.setScaleX(vehicle.getScaleX() * -1);
            direction = direction * -1;
            vehicle.setX(1750);
        }

        if (vehicle.intersects(game.getJet().getBoundsInParent())) {
            explode();
            game.getJet().getJetTransition().explode();
        }

    }

    public void explode() {
        if (vehicle.isHit())
            return;
        vehicle.setHit(true);
        vehicle.getVehicleTransition().stop();

        vehicle.getVehicleExplosion().play();
    }
}
