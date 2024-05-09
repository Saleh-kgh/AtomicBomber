package org.example.Controller;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;
import org.example.Model.*;
import org.example.Model.GameObject.*;

import java.util.ArrayList;

public class GameController {

    public void designWave1 (Wave wave) {
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

    public void setJetDirectionUp(Jet jet) {
        jet.getJetTransition().setDegreeAngle(jet.getJetTransition().getDegreeAngle() - 5);
    }

    public void setJetDirectionDown(Jet jet) {
        jet.getJetTransition().setDegreeAngle(jet.getJetTransition().getDegreeAngle() + 5);
    }

    public void releaseBombRegular(Game game) {
        BombRegular bombRegular = new BombRegular(game.getJet(), game);
        bombRegular.getBombTransition().play();
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

    private BackgroundImage createBackgroundImage () {
        Image image = new Image(GameController.class.getResource("/Pics/Backgrounds/dayForest.jpg").toExternalForm(), 1570 ,900, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return backgroundImage;
    }

    private void announceWave(String message, Wave wave) {
        Label waveLabel = new Label(message);
        waveLabel.setStyle("-fx-text-fill: linear-gradient(#FFA500, #FF4500); -fx-font-family: \"Arial\"; -fx-font-size: 60px; -fx-font-weight: bold;");
        wave.getPane().getChildren().add(waveLabel);
        waveLabel.setLayoutX((1520 - waveLabel.getWidth()) / 2);
        waveLabel.setLayoutY(300);

        pauseTransitions(wave);
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            wave.getPane().getChildren().remove(waveLabel);
            resumeTransitions(wave);
        });
        pause.play();
    }
}
