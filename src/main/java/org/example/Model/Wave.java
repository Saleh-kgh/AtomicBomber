package org.example.Model;

import javafx.animation.Transition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Wave {

    private final Game game;
    private final Pane pane;
    private final int height = 900;
    private final int width = 1570;
    private final int groundHeight = 100;
    private int remainingGroundTanks;
    private int remainingAttackTanks;
    private int remainingMigs;
    private int remainingBunkers;
    private int remainingBuildings;
    private int shotBombs;
    private int hitBombs;
    public ArrayList<Transition> animations = new ArrayList<>();
    public ArrayList<Rectangle> gameObjects = new ArrayList<>();


    public Wave(Game game, Pane pane) {
        this.game = game;
        this.pane = pane;
    }

    public Game getGame() {
        return game;
    }

    public Pane getPane() {
        return pane;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getGroundHeight() {
        return groundHeight;
    }

    public int getRemainingGroundTanks() {
        return remainingGroundTanks;
    }

    public int getRemainingAttackTanks() {
        return remainingAttackTanks;
    }

    public int getRemainingMigs() {
        return remainingMigs;
    }

    public int getRemainingBunkers() {
        return remainingBunkers;
    }

    public int getRemainingBuildings() {
        return remainingBuildings;
    }

    public int getShotBombs() {
        return shotBombs;
    }

    public int getHitBombs() {
        return hitBombs;
    }

    public void setRemainingGroundTanks(int remainingGroundTanks) {
        this.remainingGroundTanks = remainingGroundTanks;
    }

    public void setRemainingAttackTanks(int remainingAttackTanks) {
        this.remainingAttackTanks = remainingAttackTanks;
    }

    public void setRemainingMigs(int remainingMigs) {
        this.remainingMigs = remainingMigs;
    }

    public void setRemainingBunkers(int remainingBunkers) {
        this.remainingBunkers = remainingBunkers;
    }

    public void setRemainingBuildings(int remainingBuildings) {
        this.remainingBuildings = remainingBuildings;
    }

    public void setShotBombs(int shotBombs) {
        this.shotBombs = shotBombs;
    }

    public void setHitBombs(int hitBombs) {
        this.hitBombs = hitBombs;
    }

    public void startWave() {

    }

    public void endWave() {

    }
}
