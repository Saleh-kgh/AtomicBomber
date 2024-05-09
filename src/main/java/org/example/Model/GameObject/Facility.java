package org.example.Model.GameObject;

import javafx.scene.shape.Rectangle;
import org.example.Model.Game;
import org.example.Model.Wave;
import org.example.View.Animations.FacilityExplosion;

public class Facility extends Rectangle {

    private final int height;
    private final int width;
    private final Game game;
    private final Wave wave;
    private boolean isHit;
    private FacilityExplosion facilityExplosion;

    public Facility(Game game,int width, int height, int x) {
        super(width, height);
        this.width = width;
        this.height = height;
        this.game = game;
        this.wave = game.getCurrentWave();
        this.isHit = false;
        setX(x);
        setY(740 - height);
        game.getGamePane().getChildren().add(this);
        facilityExplosion = new FacilityExplosion(this, game.getGamePane());
    }

    public Game getGame() {
        return game;
    }

    public boolean isHit() {
        return isHit;
    }

    public Wave getWave() {
        return wave;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public FacilityExplosion getFacilityExplosion() {
        return facilityExplosion;
    }

    public void setFacilityExplosion(FacilityExplosion facilityExplosion) {
        this.facilityExplosion = facilityExplosion;
    }
}
