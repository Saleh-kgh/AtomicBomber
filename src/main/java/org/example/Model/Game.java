package org.example.Model;

import javafx.scene.layout.Pane;
import org.example.View.Menu.GameView;
import org.example.View.Transitions.JetTransition;
import java.nio.file.Watchable;

public class Game {

    private final Player player;
    private final GameView gameView;
    private final Pane gamePane;
    private final Jet jet;
    private Wave currentWave;
    private Wave wave1;
    private Wave wave2;
    private Wave wave3;
    private int score;
    private int kills;

    public Game(Player player, GameView gameView, Pane gamePane) {
        this.player = player;
        this.gameView = gameView;
        this.gamePane = gamePane;
        score = 0;
        kills = 0;
        jet = new Jet(this);
        jet.setJetTransition(new JetTransition(jet, this, gamePane));
    }

    public Player getPlayer() {
        return player;
    }

    public GameView getGameView() {
        return gameView;
    }

    public Wave getWave1() {
        return wave1;
    }

    public Wave getWave2() {
        return wave2;
    }

    public Wave getWave3() {
        return wave3;
    }

    public Wave getCurrentWave() {
        return currentWave;
    }

    public Pane getGamePane() {
        return gamePane;
    }

    public Jet getJet() {
        return jet;
    }

    public void setCurrentWave(Wave currentWave) {
        this.currentWave = currentWave;
    }

    public void setWave1(Wave wave1) {
        this.wave1 = wave1;
    }

    public void setWave2(Wave wave2) {
        this.wave2 = wave2;
    }

    public void setWave3(Wave wave3) {
        this.wave3 = wave3;
    }

    public int getScore() {
        return score;
    }

    public int getKills() {
        return kills;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void endGame() {}
}
