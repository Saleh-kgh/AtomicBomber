package org.example.Controller;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.example.Model.*;
import org.example.Model.GameObject.*;
import org.example.View.Menu.LoginView;
import org.example.View.Menu.MainView;

import java.util.ArrayList;

public class GameController {

    public void designWave1 (Wave wave) {
        relocateJet(wave);

        wave.getPane().setBackground(new Background(createBackgroundImage()));
        wave.getPane().getChildren().add(wave.getGame().getJet());

        Building building1 = new Building(wave.getGame(), 200);
        wave.addToBuildings(building1);
        wave.setRemainingBuildings(1);

        Bunker bunker1 = new Bunker(wave.getGame(), 900);
        wave.addToBunkers(bunker1);
        wave.setRemainingBunkers(1);

        Truck truck1 = new Truck(wave.getGame(), -1);
        Truck truck2 = new Truck(wave.getGame(), 1);
        wave.addToTrucks(truck1);
        wave.addToTrucks(truck2);
        wave.addToAnimations(truck1.getVehicleTransition());
        wave.addToAnimations(truck2.getVehicleTransition());
        wave.setRemainingTrucks(2);
        truck1.getVehicleTransition().play();

        Tank tank1 = new Tank(wave.getGame(), 1);
        Tank tank2 = new Tank(wave.getGame(), -1);
        Tank tank3 = new Tank(wave.getGame(), 1);
        wave.addToTanks(tank1);
        wave.addToTanks(tank2);
        wave.addToTanks(tank3);
        wave.addToAnimations(tank1.getVehicleTransition());
        wave.addToAnimations(tank2.getVehicleTransition());
        wave.addToAnimations(tank3.getVehicleTransition());
        wave.setRemainingTanks(3);
        tank1.getVehicleTransition().play();

        announceWave("Wave 1", wave);
    }

    public void designWave2 (Wave wave) {
        relocateJet(wave);

        Building building1 = new Building(wave.getGame(), 1200);
        wave.addToBuildings(building1);
        wave.setRemainingBuildings(1);

        Bunker bunker1 = new Bunker(wave.getGame(), 300);
        wave.addToBunkers(bunker1);
        wave.setRemainingBunkers(1);

        BPM Bpm1 = new BPM(wave.getGame(), -1);
        BPM Bpm2 = new BPM(wave.getGame(), 1);
        wave.addToBpms(Bpm1);
        wave.addToBpms(Bpm2);
        wave.addToAnimations(Bpm1.getVehicleTransition());
        wave.addToAnimations(Bpm2.getVehicleTransition());
        wave.setRemainingBpms(2);
        Bpm1.getVehicleTransition().play();

        Truck truck1 = new Truck(wave.getGame(), -1);
        Truck truck2 = new Truck(wave.getGame(), 1);
        wave.addToTrucks(truck1);
        wave.addToTrucks(truck2);
        wave.addToAnimations(truck1.getVehicleTransition());
        wave.addToAnimations(truck2.getVehicleTransition());
        wave.setRemainingTrucks(2);
        truck1.getVehicleTransition().play();

        Tank tank1 = new Tank(wave.getGame(), 1);
        Tank tank2 = new Tank(wave.getGame(), -1);
        Tank tank3 = new Tank(wave.getGame(), 1);
        Tank tank4 = new Tank(wave.getGame(), 1);
        wave.addToTanks(tank1);
        wave.addToTanks(tank2);
        wave.addToTanks(tank3);
        wave.addToTanks(tank4);
        wave.addToAnimations(tank1.getVehicleTransition());
        wave.addToAnimations(tank2.getVehicleTransition());
        wave.addToAnimations(tank3.getVehicleTransition());
        wave.addToAnimations(tank4.getVehicleTransition());
        wave.setRemainingTanks(4);
        tank1.getVehicleTransition().play();

        announceWave("Wave 2", wave);
    }

    public void designWave3 (Wave wave) {
        relocateJet(wave);

        Building building1 = new Building(wave.getGame(), 100);
        wave.addToBuildings(building1);
        wave.setRemainingBuildings(1);

        Bunker bunker1 = new Bunker(wave.getGame(), 1100);
        wave.addToBunkers(bunker1);
        wave.setRemainingBunkers(1);

        BPM Bpm1 = new BPM(wave.getGame(), -1);
        wave.addToBpms(Bpm1);
        wave.addToAnimations(Bpm1.getVehicleTransition());
        wave.setRemainingBpms(1);
        Bpm1.getVehicleTransition().play();

        Truck truck1 = new Truck(wave.getGame(), -1);
        Truck truck2 = new Truck(wave.getGame(), 1);
        wave.addToTrucks(truck1);
        wave.addToTrucks(truck2);
        wave.addToAnimations(truck1.getVehicleTransition());
        wave.addToAnimations(truck2.getVehicleTransition());
        wave.setRemainingTrucks(2);
        truck1.getVehicleTransition().play();

        Tank tank1 = new Tank(wave.getGame(), 1);
        Tank tank2 = new Tank(wave.getGame(), -1);
        Tank tank3 = new Tank(wave.getGame(), 1);
        wave.addToTanks(tank1);
        wave.addToTanks(tank2);
        wave.addToTanks(tank3);
        wave.addToAnimations(tank1.getVehicleTransition());
        wave.addToAnimations(tank2.getVehicleTransition());
        wave.addToAnimations(tank3.getVehicleTransition());
        wave.setRemainingTanks(3);
        tank1.getVehicleTransition().play();

        announceWave("Wave 3", wave);
    }

    public void cleanWaveMess(Wave wave) {
        wave.getPane().getChildren().removeAll(wave.getShotWeaponry());
        wave.getPane().getChildren().removeAll(wave.getTanks());
        wave.getPane().getChildren().removeAll(wave.getTrucks());
        wave.getPane().getChildren().removeAll(wave.getBpms());
        wave.getPane().getChildren().removeAll(wave.getBuildings());
        wave.getPane().getChildren().removeAll(wave.getBunkers());
    }

    public void setJetDirectionUp(Jet jet) {
        jet.getJetTransition().setDegreeAngle(jet.getJetTransition().getDegreeAngle() - 5);
    }

    public void setJetDirectionDown(Jet jet) {
        jet.getJetTransition().setDegreeAngle(jet.getJetTransition().getDegreeAngle() + 5);
    }

    public void releaseBombRegular(Game game) {
        BombRegular bombRegular = new BombRegular(game.getJet(), game);
        game.getCurrentWave().addToAnimations(bombRegular.getBombTransition());
        bombRegular.getBombTransition().play();
        game.setShotBombs(game.getShotBombs() + 1);
        game.getCurrentWave().setShotBombs(game.getCurrentWave().getShotBombs() + 1);
    }

    public void releaseBombAtomic(Game game) {
        if (game.getJet().getRemainingAtomicBombs() > 0) {
            game.getJet().setRemainingAtomicBombs(game.getJet().getRemainingAtomicBombs() - 1);
            BombAtomic bombAtomic = new BombAtomic(game.getJet(), game);
            game.getCurrentWave().addToAnimations(bombAtomic.getBombTransition());
            bombAtomic.getBombTransition().play();
            game.setShotBombs(game.getShotBombs() + 1);
            game.getCurrentWave().setShotBombs(game.getCurrentWave().getShotBombs() + 1);
        }
    }

    public void pauseTransitions(Wave wave) {
        wave.getGame().setPaused(true);
        for (Transition transition : wave.getAnimations()) {
            if (transition.getStatus() == Animation.Status.RUNNING)
                transition.pause();
        }
        wave.getGame().getJet().getJetTransition().pause();
    }

    public void resumeTransitions(Wave wave) {
        wave.getGame().setPaused(false);
        for (Transition transition : wave.getAnimations()) {
            if (transition.getStatus() == Animation.Status.PAUSED)
                transition.play();
        }
        wave.getGame().getJet().getJetTransition().play();
    }

    public void passWave(Game game) {
        if (game.getCurrentWave().getNumber() == 3)
            return;

        cleanWaveMess(game.getCurrentWave());
        int index = game.getWaves().indexOf(game.getCurrentWave()) + 1;
        game.setCurrentWave(game.getWaves().get(index));
        switch (index) {
            case 1:
                designWave2(game.getWaves().get(index));
                break;
            case 2:
                designWave3(game.getWaves().get(index));
                break;
        }
    }

    public void changeJetVulnerability(Game game) {
        game.getJet().setInvulnerable(!game.getJet().isInvulnerable());
    }

    public void addToJetAtomicBombs(Game game) {
        game.getJet().setRemainingAtomicBombs(game.getJet().getRemainingAtomicBombs() + 1);
    }

    private BackgroundImage createBackgroundImage () {
        Image image = new Image(GameController.class.getResource("/Pics/Backgrounds/dayForest.jpg").toExternalForm(), 1570 ,900, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return backgroundImage;
    }

    private void relocateJet(Wave wave) {
        Jet jet = wave.getGame().getJet();
        jet.setX(500);
        jet.setY(400);
        jet.getJetTransition().setDegreeAngle(0);
    }

    private void announceWave(String message, Wave wave) {
        pauseTransitions(wave);

        Rectangle rectangle = new Rectangle(1600, 1000);
        rectangle.setFill(Color.BLACK);
        wave.getPane().getChildren().add(rectangle);
        rectangle.toFront();

        Label waveLabel = new Label(message);
        waveLabel.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 60px; -fx-font-weight: bold;");
        wave.getPane().getChildren().add(waveLabel);
        waveLabel.toFront();
        waveLabel.setLayoutX((1450 - waveLabel.getWidth()) / 2);
        waveLabel.setLayoutY(300);

        PauseTransition pause = new PauseTransition(Duration.seconds(6));
        pause.setOnFinished(event -> {
            wave.getPane().getChildren().remove(waveLabel);
            wave.getPane().getChildren().remove(rectangle);
            resumeTransitions(wave);
        });
        pause.play();
    }

    public void completedWave(Wave wave) {
        pauseTransitions(wave);

        Rectangle rectangle = new Rectangle(1600, 1000);
        rectangle.setFill(Color.BLACK);
        wave.getPane().getChildren().add(rectangle);
        rectangle.toFront();

        Label waveLabel = new Label("Wave " + wave.getNumber() + " Completed Successfully!");
        waveLabel.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 60px; -fx-font-weight: bold;");
        wave.getPane().getChildren().add(waveLabel);
        waveLabel.toFront();
        waveLabel.setLayoutX((700 - waveLabel.getWidth()) / 2);
        waveLabel.setLayoutY(300);

        double accuracy = (double)100 * wave.getHitBombs() / wave.getShotBombs();
        accuracy = accuracy > 100 ? 100 : accuracy;
        String formattedAccuracy = String.format("%.2f", accuracy);

        Label accuracyLabel = new Label("Your Accuracy During This Wave: " + formattedAccuracy);
        accuracyLabel.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 40px; -fx-font-weight: bold;");
        wave.getPane().getChildren().add(accuracyLabel);
        accuracyLabel.toFront();
        accuracyLabel.setLayoutX((800 - accuracyLabel.getWidth()) / 2);
        accuracyLabel.setLayoutY(380);

        PauseTransition pause = new PauseTransition(Duration.seconds(3.5));
        pause.setOnFinished(event -> {
            wave.getPane().getChildren().remove(waveLabel);
            wave.getPane().getChildren().remove(accuracyLabel);
            wave.getPane().getChildren().remove(rectangle);
        });
        pause.play();
    }

    public void achievedVictory(Wave wave) {
        wave.getGame().getGameView().musicPlayCommand(false);

        Rectangle rectangle = new Rectangle(1600, 1000);
        rectangle.setFill(Color.BLACK);
        wave.getPane().getChildren().add(rectangle);
        rectangle.toFront();

        Label victoryLabel = new Label("Mobarake Mohandes! Bordi.");
        victoryLabel.setStyle("-fx-text-fill: linear-gradient(#29ec0b, #52f8be); -fx-font-family: \"Arial\"; -fx-font-size: 60px; -fx-font-weight: bold;");
        wave.getPane().getChildren().add(victoryLabel);
        victoryLabel.toFront();
        victoryLabel.setLayoutX((900 - victoryLabel.getWidth()) / 2);
        victoryLabel.setLayoutY(380);

        PauseTransition pause = new PauseTransition(Duration.seconds(10));
        pause.setOnFinished(event -> {
            wave.getPane().getChildren().remove(victoryLabel);
            wave.getPane().getChildren().remove(rectangle);
            endGame(wave.getGame());
        });
        pause.play();
    }

    public void defeated(Wave wave) {
        wave.getGame().getGameView().musicPlayCommand(false);

        Rectangle rectangle = new Rectangle(1600, 1000);
        rectangle.setFill(Color.BLACK);
        wave.getPane().getChildren().add(rectangle);
        rectangle.toFront();

        Label defeatLabel = new Label("Bakhti Mohandes!");
        defeatLabel.setStyle("-fx-text-fill: linear-gradient(#ec4f0b, #d00d0d); -fx-font-family: \"Arial\"; -fx-font-size: 60px; -fx-font-weight: bold;");
        wave.getPane().getChildren().add(defeatLabel);
        defeatLabel.toFront();
        defeatLabel.setLayoutX((950 - defeatLabel.getWidth()) / 2);
        defeatLabel.setLayoutY(380);

        PauseTransition pause = new PauseTransition(Duration.seconds(4));
        pause.setOnFinished(event -> {
            wave.getPane().getChildren().remove(defeatLabel);
            wave.getPane().getChildren().remove(rectangle);
            endGame(wave.getGame());
        });
        pause.play();
    }

    public void endGame(Game game) {
        Player player = Player.getLoggedInPlayer();
        player.setDifficultyBasedKills(player.getDifficultyBasedKills() + game.getKills() * player.getCurrentDifficulty());
        player.setTotalKills(player.getTotalKills() + game.getKills());
        player.setHitBombs(player.getHitBombs() + game.getHitBombs());
        player.setShotBombs(player.getShotBombs() + game.getShotBombs());

        if (player.getFinalWave() < game.getCurrentWave().getNumber())
            player.setFinalWave(game.getCurrentWave().getNumber());

        game.getGameView().musicPlayCommand(false);
        try {
            new MainView().start(LoginView.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
