package org.example.View.Menu;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        setUpHud();
        startWaves();

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
                    case R:
                        gameController.releaseBombAtomic(game);
                        break;
                    case C:
                        gameController.releaseBombCluster(game);
                        break;
                    case L:
                        gameController.pauseTransitions(game.getCurrentWave());
                        break;
                    case O:
                        gameController.resumeTransitions(game.getCurrentWave());
                        break;
                    case P:
                        gameController.passWave(game);
                        break;
                    case I:
                        gameController.changeJetVulnerability(game);
                        break;
                    case A:
                        gameController.addToJetBombAtomics(game);
                        break;
                    case Q:
                        gameController.addToJetBombClusters(game);
                        break;
                    case TAB:
                        gameController.activeFreezeWeapon(game);
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

    public void startWaves() {
        GameController gameController = new GameController();
        gameController.designWave1(wave1);
    }

    public void setMediaPlayerMusic(String musicName) {
        File file = new File("D:/AP/AtomicBomber/AlphaVersion/src/main/resources/media/" + musicName +".mp3");
        Media media = new Media(file.toURI().toString());

        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.5 * Player.getLoggedInPlayer().getGameSoundVolume());
    }

    public void musicPlayCommand(boolean play) {
        if (play)
            mediaPlayer.play();
        else
            mediaPlayer.stop();
    }

    private void setUpHud() {

        Rectangle infoBar = new Rectangle(1600, 100);
        infoBar.setFill(Color.BLACK);
        infoBar.setLayoutX(0);
        infoBar.setY(0);
        gamePane.getChildren().add(infoBar);

        Rectangle infoBarEnd = new Rectangle(1600, 8);
        infoBarEnd.setFill(Color.ORANGE);
        infoBarEnd.setLayoutX(0);
        infoBarEnd.setY(100);
        gamePane.getChildren().add(infoBarEnd);


        Label atomicBombCount = new Label("Atomic Bombs: " + jet.getRemainingAtomicBombs());
        atomicBombCount.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(atomicBombCount);
        atomicBombCount.setLayoutX(50);
        atomicBombCount.setLayoutY(25);


        Label clusterBombCount = new Label("cluster Bombs: " + jet.getRemainingClusterBombs());
        clusterBombCount.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(clusterBombCount);
        clusterBombCount.setLayoutX(300);
        clusterBombCount.setLayoutY(25);


        Label jetRemainingLives = new Label("Jet Lives: " + jet.getRemainingLives());
        jetRemainingLives.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(jetRemainingLives);
        jetRemainingLives.setLayoutX(950);
        jetRemainingLives.setLayoutY(25);


        ProgressBar freezeWeaponCharge = new ProgressBar();
        freezeWeaponCharge.setProgress(0);
        freezeWeaponCharge.setStyle("-fx-background-color: linear-gradient(#FFA500, #FF4500);" +
                "-fx-font-family: \"Arial\";" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;");
        gamePane.getChildren().add(freezeWeaponCharge);
        freezeWeaponCharge.setPrefWidth(200);
        freezeWeaponCharge.setLayoutX(635);
        freezeWeaponCharge.setLayoutY(65);


        Label freezeWeaponStatus = new Label("Freeze Weapon");
        freezeWeaponStatus.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(freezeWeaponStatus);
        freezeWeaponStatus.setLayoutX(655);
        freezeWeaponStatus.setLayoutY(65);


        Label killsCount = new Label("Kills: " + game.getKills());
        killsCount.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(killsCount);
        killsCount.setLayoutX(1150);
        killsCount.setLayoutY(25);


        Label currentWaveNumber = new Label("Wave: " + game.getCurrentWave().getNumber());
        currentWaveNumber.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 20px; -fx-font-weight: bold;");
        gamePane.getChildren().add(currentWaveNumber);
        currentWaveNumber.setLayoutX(700);
        currentWaveNumber.setLayoutY(25);

        Button pauseButton = new Button("Pause");
        pauseButton.setPrefWidth(50);
        pauseButton.setPrefHeight(50);
        pauseButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0);\n" +
                "    -fx-background-radius: 10;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: linear-gradient(#FFA500, #FF4500);\n" +
                "    -fx-font-family: \"Arial\";\n" +
                "    -fx-font-size: 30px;\n" +
                "    -fx-font-weight: bold;");
        gamePane.getChildren().add(pauseButton);
        pauseButton.setLayoutX(1400);
        pauseButton.setLayoutY(25);

        HUDupdate hudUpdate = new HUDupdate(game, atomicBombCount, clusterBombCount,
                jetRemainingLives, freezeWeaponCharge,
                killsCount, currentWaveNumber);
        hudUpdate.play();
    }
}
