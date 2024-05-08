package org.example.Model;

import javafx.scene.layout.Pane;
import org.example.Model.GameObject.Jet;
import org.example.View.Menu.GameView;
import org.example.View.Transitions.JetTransition;

import java.util.ArrayList;

public class Game {

    private final Player player;
    private final GameView gameView;
    private final Pane gamePane;
    private final Jet jet;
    private final int numberOfWaves;
    private Wave currentWave;
    private ArrayList<Wave> waves = new ArrayList<>();
    private int score;
    private int kills;

    public Game(Player player, GameView gameView, Pane gamePane, int numberOfWaves) {
        this.player = player;
        this.gameView = gameView;
        this.gamePane = gamePane;
        this.numberOfWaves = numberOfWaves;
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

    public ArrayList<Wave> getWaves() {
        return waves;
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

    public int getNumberOfWaves() {
        return numberOfWaves;
    }

    public void addToWaves(Wave wave) {
        this.waves.add(wave);
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
