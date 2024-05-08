package org.example.Model.GameObject;

import javafx.scene.shape.Rectangle;
import org.example.Model.Game;
import org.example.View.Animations.VehicleExplosion;
import org.example.View.Transitions.VehicleTransition;

public abstract class Vehicle extends Rectangle {

    private int direction;
    private final int width;
    private final int length;
    private final Game game;
    private final VehicleTransition vehicleTransition;
    private final VehicleExplosion vehicleExplosion;
    private boolean isFrozen;
    private boolean isHit;
    private double difficultyLevel;

    public Vehicle(int width, int length, Game game, int direction) {
        super(width, length);
        this.width = width;
        this.length = length;
        this.game = game;
        this.direction = direction;
        game.getGamePane().getChildren().add(this);
        this.vehicleTransition = new VehicleTransition(this, game);
        this.vehicleExplosion = new VehicleExplosion(this, game.getGamePane());
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Game getGame() {
        return game;
    }

    public VehicleTransition getVehicleTransition() {
        return vehicleTransition;
    }

    public VehicleExplosion getVehicleExplosion() {
        return vehicleExplosion;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public double getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(double difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    abstract public void activateNext();
}
