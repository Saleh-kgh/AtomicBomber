package org.example.Controller;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.example.Model.*;
import org.example.Model.GameObject.*;

public class GameController {

    public void designWave1 (Wave wave) {
        wave.getPane().setBackground(new Background(createBackgroundImage()));
        wave.getPane().getChildren().add(wave.getGame().getJet());

        Building building1 = new Building(wave.getGame(), 200);
        wave.addToBuildings(building1);

        Bunker bunker1 = new Bunker(wave.getGame(), 900);
        wave.addToBunkers(bunker1);

        Truck truck1 = new Truck(wave.getGame(), -1);
        Truck truck2 = new Truck(wave.getGame(), 1);
        wave.addToTrucks(truck1);
        wave.addToTrucks(truck2);
        truck1.getVehicleTransition().play();

        Tank tank1 = new Tank(wave.getGame(), 1);
        Tank tank2 = new Tank(wave.getGame(), -1);
        Tank tank3 = new Tank(wave.getGame(), 1);
        wave.addToTanks(tank1);
        wave.addToTanks(tank2);
        wave.addToTanks(tank3);
        tank1.getVehicleTransition().play();
    }

    public void designWave2 (Wave wave) {
//        BPM Bpm1 = new BPM(wave.getGame(), -1);
//        BPM Bpm2 = new BPM(wave.getGame(), 1);
//        BPM Bpm3 = new BPM(wave.getGame(), -1);
//        wave.addToBpms(Bpm1);
//        wave.addToBpms(Bpm2);
//        wave.addToBpms(Bpm3);
//        Bpm1.getVehicleTransition().play();
    }

    public void designWave3 (Wave wave3) {

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

    private BackgroundImage createBackgroundImage () {
        Image image = new Image(GameController.class.getResource("/Pics/Backgrounds/dayForest.jpg").toExternalForm(), 1570 ,900, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return backgroundImage;
    }
}
