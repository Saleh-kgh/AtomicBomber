package org.example.Model;

import javafx.scene.shape.Rectangle;

public class Building extends Rectangle {

    private final int height = 80;
    private final int width = 300;
    private final Game game;
    //private BuildingExplosionAnim buildingExplosionAnim;

    public Building(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

//    public BuildingExplosionAnim getBuildingExplosionAnim() {
//        return buildingExplosionAnim;
//    }
//
//    public void setBuildingExplosionAnim(BuildingExplosionAnim buildingExplosionAnim) {
//        this.buildingExplosionAnim = buildingExplosionAnim;
//    }

    public void explodeBuilding() {}
}
