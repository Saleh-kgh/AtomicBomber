package org.example.Model.GameObject;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.example.Model.Game;
import org.example.View.Transitions.BulletTransition;

import java.io.File;

public class Bullet extends Rectangle {

    private final int height = 5;
    private final int width = 5;
    private final Game game;
    private BulletTransition bulletTransition;
    private final BPM bpm;
    private boolean hasHit;

    public Bullet(Game game, BPM bpm) {
        super(10, 10);
        this.game = game;
        this.bpm = bpm;
        this.hasHit = false;

        setY(bpm.getY());
        setX(bpm.getX() + 60);
        game.getGamePane().getChildren().add(this);
        this.setFill(new ImagePattern(new Image
                (Jet.class.getResource("/Pics/Objects/bullet.png").toExternalForm())));
        bulletTransition = new BulletTransition(game, this);

        getGame().getCurrentWave().addToAnimations(this.getBulletTransition());
        getGame().getCurrentWave().addToShotWeaponry(this);
    }

    public Game getGame() {
        return game;
    }

    public BulletTransition getBulletTransition() {
        return bulletTransition;
    }

    public void setBulletTransition(BulletTransition bulletTransition) {
        this.bulletTransition = bulletTransition;
    }

    public BPM getBpm() {
        return bpm;
    }

    public boolean isHasHit() {
        return hasHit;
    }

    public void setHasHit(boolean hasHit) {
        this.hasHit = hasHit;
    }

    public void explode() {
        playExplosionSound();

        Jet jet = bpm.getGame().getJet();
        jet.setRemainingLives(jet.getRemainingLives() - 1);
        if (jet.getRemainingLives() == 0) {
            jet.getJetTransition().explode();
            bpm.getShootingTimeline().stop();
        }
    }

    protected void playExplosionSound() {
        File file = new File("D:/AP/AtomicBomber/AlphaVersion/src/main/resources/media/sound/" + "BulletHitJet" +".wav");
        Media media = new Media(file.toURI().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.play();
    }
}
