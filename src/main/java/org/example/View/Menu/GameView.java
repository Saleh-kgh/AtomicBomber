package org.example.View.Menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.Controller.GameController;
import org.example.Model.*;
import org.example.View.Transitions.JetTransition;

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
        setMediaPlayer("fortunateSon");
        musicPlayCommand(true);

        gamePane = new Pane();
        setSize(gamePane);
        game = new Game(Player.getLoggedInPlayer(), this, gamePane);
        jet = game.getJet();

        jet.getJetTransition().play();
        setUpInitialWave();
        wave1.startWave();

        Scene scene = new Scene(gamePane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

        scene.setOnKeyPressed(event -> {
            GameController gameController = new GameController();
            switch (event.getCode()) {
                case UP:
                    gameController.setJetDirectionUp(jet);
                    break;
                case DOWN:
                    gameController.setJetDirectionDown(jet);
                    break;
                default:
                    break;
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
        wave1 = new Wave(game, gamePane);
        wave2 = new Wave(game, gamePane);
        wave3 = new Wave(game, gamePane);

        GameController gameController = new GameController();
        gameController.designWave1(wave1);

        game.setWave1(wave1);
        game.setWave2(wave2);
        game.setWave3(wave3);
    }

    private void setMediaPlayer(String musicName) {
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
}
