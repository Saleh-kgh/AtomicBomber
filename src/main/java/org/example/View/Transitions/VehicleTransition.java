package org.example.View.Transitions;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.example.Model.Game;
import org.example.Model.Vehicle;
import org.example.View.Animations.VehicleExplosion;

public class VehicleTransition extends Transition {

    private Vehicle vehicle;
    private final double velocityX = 50;
    private final int direction;
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
            vehicle.getGame().getGamePane().getChildren().remove(vehicle);
        }

        else if (vehicle.getX() + deltaX > gamePane.getScene().getWidth() + 500){
            vehicle.getGame().getGamePane().getChildren().remove(vehicle);
        }

        if (vehicle.intersects(game.getJet().getBoundsInParent())) {
            collision();
            game.getJet().getJetTransition().collision();
        }

    }

    public void collision() {
        if (vehicle.isHit())
            return;
        vehicle.setHit(true);
        vehicle.getVehicleTransition().stop();

        VehicleExplosion vehicleExplosion = new VehicleExplosion(vehicle, gamePane);
        vehicleExplosion.play();
    }
}
