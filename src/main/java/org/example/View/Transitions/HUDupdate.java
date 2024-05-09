package org.example.View.Transitions;

import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.example.Model.Game;

public class HUDupdate extends Transition {
    private Game game;
    private final int duration = 10;
    private Label atomicBombCount;
    private Label clusterBombCount;
    private Label jetRemainingLives;
    private Label FreezeWeaponStatus;
    private Label killsCount;
    private Label currentWaveNumber;

    public HUDupdate(Game game,
                     Label atomicBombCount,
                     Label clusterBombCount,
                     Label jetRemainingLives,
                     Label FreezeWeaponStatus,
                     Label killsCount,
                     Label currentWaveNumber) {

        this.game = game;
        this.atomicBombCount = atomicBombCount;
        this.clusterBombCount = clusterBombCount;
        this.jetRemainingLives = jetRemainingLives;
        this.FreezeWeaponStatus = FreezeWeaponStatus;
        this.killsCount = killsCount;
        this.currentWaveNumber = currentWaveNumber;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    @Override
    protected void interpolate(double v) {
        atomicBombCount.setText("Atomic Bombs: X " + game.getJet().getRemainingAtomicBombs());
        clusterBombCount.setText("cluster Bombs: X " + game.getJet().getRemainingClusterBombs());
        jetRemainingLives.setText("Jet Lives: X " + game.getJet().getRemainingLives());
        FreezeWeaponStatus.setText("Freeze Weapon: " + game.getJet().getFreezeWeaponStatus());
        killsCount.setText("Kills: X " + game.getKills());
        currentWaveNumber.setText("Wave " + game.getCurrentWave().getNumber());
    }
}
