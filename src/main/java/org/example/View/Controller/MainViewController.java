package org.example.View.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.example.Model.Player;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import org.example.View.Menu.GameView;
import org.example.View.Menu.LoginView;
import org.example.View.Menu.ProfileView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private ImageView avatar;
    @FXML
    private Label usernameLabel;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @FXML
    private void exitAction() {
        Platform.exit();
    }

    @FXML
    private void settingsAction() {}

    @FXML
    private void profileAction() {
        mediaPlayer.stop();
        ProfileView profileView = new ProfileView();
        try {
            profileView.start(LoginView.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void leaderBoardAction() {}

    @FXML
    private void startGameAction() {
        mediaPlayer.stop();
        GameView gameView = new GameView();
        try {
            gameView.start(LoginView.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void setDifficultyAction() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("file:///" + Player.getLoggedInPlayer().getAvatarAddress(), 260, 260, false, false);
        avatar.setImage(image);
        usernameLabel.setText(Player.getLoggedInPlayer().getUsername());

        file = new File("D:/AP/AtomicBomber/AlphaVersion/src/main/resources/media/topGun2.mp3");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Repeat indefinitely
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }
}
