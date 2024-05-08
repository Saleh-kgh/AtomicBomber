package org.example.Model.GameObject;

import javafx.scene.shape.Rectangle;
import org.example.Model.Game;
import org.example.View.Animations.FacilityExplosion;

public class Facility extends Rectangle {

    private final int height = 80;
    private final int width = 300;
    private final Game game;
    private boolean isHit;
    private FacilityExplosion facilityExplosion;

    public Facility(Game game) {
        super(300, 80);
        this.game = game;
        this.isHit = false;
        facilityExplosion = new FacilityExplosion(this, game.getGamePane());
    }

    public Game getGame() {
        return game;
    }

    public boolean isHit() {
        return isHit;
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
