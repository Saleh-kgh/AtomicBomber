package org.example.Model;

import javafx.scene.shape.Rectangle;

public class Bunker extends Rectangle {

    private final int height = 80;
    private final int width = 300;
    private final Game game;
    //private BunkerExplosionAnim bunkerExplosionAnim;

    public Bunker(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

//    public BunkerExplosionAnim getBunkerExplosionAnim() {
//        return bunkerExplosionAnim;
//    }

//    public void setBunkerExplosionAnim(BunkerExplosionAnim bunkerExplosionAnim) {
//        this.bunkerExplosionAnim = bunkerExplosionAnim;
//    }

    public void explodeBunker() {}
}
