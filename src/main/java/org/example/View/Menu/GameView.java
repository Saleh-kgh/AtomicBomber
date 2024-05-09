package org.example.View.Menu;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.Controller.GameController;
import org.example.Model.*;
import org.example.Model.GameObject.Jet;
import org.example.View.Transitions.HUDupdate;

import java.io.File;

public class GameView extends Application {

    private MediaPlayer mediaPlayer;
    private Game game;
    private Pane gamePane;
    private Jet jet;
    private Wave wave1;
    private Wave wave2;
    private Wave wave3;

    @Override
    public void start(Stage stage) throws Exception {
        setMediaPlayerMusic("fortunateSon");
        musicPlayCommand(true);

        gamePane = new Pane();
        setSize(gamePane);
        game = new Game(Player.getLoggedInPlayer(), this, gamePane, 3);
        jet = game.getJet();

        jet.getJetTransition().play();
        setUpInitialWave();
        game.setCurrentWave(wave1);
        startWaves();
        setUpHud();

        Scene scene = new Scene(gamePane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

        scene.setOnKeyPressed(event -> {

            GameController gameController = new GameController();
            if (!game.isPaused()) {
                switch (event.getCode()) {
                    case UP:
                        gameController.setJetDirectionUp(jet);
                        break;
                    case DOWN:
                        gameController.setJetDirectionDown(jet);
                        break;
                    case SPACE:
                        gameController.releaseBombRegular(game);
                        break;
                    case P:
                        gameController.pauseTransitions(game.getCurrentWave());
                        break;
                    case O:
                        gameController.resumeTransitions(game.getCurrentWave());
                        break;
                    default:
                        break;
                }
            }
            else {
                if (event.getCode() == KeyCode.O)
                    gameController.resumeTransitions(game.getCurrentWave());
            }
        });
    }

    private void setSize(Pane pane) {
        pane.setMinHeight(900);
        pane.setMaxHeight(900);
        pane.setMinWidth(1570);
        pane.setMaxWidth(1570);
    }

    private void setUpInitialWave() {
        wave1 = new Wave(game, gamePane, 1);
        wave2 = new Wave(game, gamePane, 2);
        wave3 = new Wave(game, gamePane, 3);

        game.addToWaves(wave1);
        game.addToWaves(wave2);
        game.addToWaves(wave3);
    }

    private void startWaves() {
        GameController gameController = new GameController();
        gameController.designWave1(wave1);
    }

    public void setMediaPlayerMusic(String musicName) {
        File file = new File("D:/AP/AtomicBomber/AlphaVersion/src/main/resources/media/" + musicName +".mp3");
        Media media = new Media(file.toURI().toString());

        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.5);
    }

    public void musicPlayCommand(boolean play) {
        if (play)
            mediaPlayer.play();
        else
            mediaPlayer.stop();
    }

    private void setUpHud() {
        Label atomicBombCount = new Label("Atomic Bombs: X " + jet.getRemainingAtomicBombs());
        atomicBombCount.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(atomicBombCount);
        atomicBombCount.setLayoutX(50);
        atomicBombCount.setLayoutY(50);


        Label clusterBombCount = new Label("cluster Bombs: X " + jet.getRemainingClusterBombs());
        clusterBombCount.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(clusterBombCount);
        clusterBombCount.setLayoutX(300);
        clusterBombCount.setLayoutY(50);


        Label jetRemainingLives = new Label("Jet Lives: X " + jet.getRemainingLives());
        jetRemainingLives.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(jetRemainingLives);
        jetRemainingLives.setLayoutX(50);
        jetRemainingLives.setLayoutY(100);


        Label FreezeWeaponStatus = new Label("Freeze Weapon: " + jet.getFreezeWeaponStatus());
        FreezeWeaponStatus.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(FreezeWeaponStatus);
        FreezeWeaponStatus.setLayoutX(320);
        FreezeWeaponStatus.setLayoutY(100);


        Label killsCount = new Label("Kills: X " + game.getKills());
        killsCount.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(killsCount);
        killsCount.setLayoutX(200);
        killsCount.setLayoutY(100);


        Label currentWaveNumber = new Label("Wave " + game.getCurrentWave().getNumber());
        currentWaveNumber.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(currentWaveNumber);
        currentWaveNumber.setLayoutX(720);
        currentWaveNumber.setLayoutY(25);

        HUDupdate hudUpdate = new HUDupdate(game, atomicBombCount, clusterBombCount, jetRemainingLives, FreezeWeaponStatus, killsCount, currentWaveNumber);
        hudUpdate.play();
    }
}
