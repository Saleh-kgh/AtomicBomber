package org.example.View.Transitions;

import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import org.example.Model.Game;

public class HUDupdate extends Transition {
    private Game game;
    private final int duration = 10;
    private Label atomicBombCount;
    private Label clusterBombCount;
    private Label jetRemainingLives;
    private ProgressBar freezeWeaponCharge;
    private Label killsCount;
    private Label currentWaveNumber;

    public HUDupdate(Game game,
                     Label atomicBombCount,
                     Label clusterBombCount,
                     Label jetRemainingLives,
                     ProgressBar freezeWeaponCharge,
                     Label killsCount,
                     Label currentWaveNumber) {

        this.game = game;
        this.atomicBombCount = atomicBombCount;
        this.clusterBombCount = clusterBombCount;
        this.jetRemainingLives = jetRemainingLives;
        this.freezeWeaponCharge = freezeWeaponCharge;
        this.killsCount = killsCount;
        this.currentWaveNumber = currentWaveNumber;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    @Override
    protected void interpolate(double v) {
        atomicBombCount.setText("Atomic Bombs: " + game.getJet().getRemainingAtomicBombs());
        clusterBombCount.setText("cluster Bombs: " + game.getJet().getRemainingClusterBombs());
        jetRemainingLives.setText("Jet Lives: " + game.getJet().getRemainingLives());
        killsCount.setText("Kills: " + game.getKills());
        currentWaveNumber.setText("Wave: " + game.getCurrentWave().getNumber());

        freezeWeaponCharge.setProgress((double) game.getJet().getFreezeChargeLevel() / 6);
    }
}
