package org.example.Model.GameObject;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import org.example.Model.Game;

public class BPM extends Vehicle {

    private double radius;
    private int fireRate;

    public BPM(Game game, int direction) {
        super(150, 50, game, direction);
        this.setFill(new ImagePattern(new Image
                (Jet.class.getResource("/Pics/Objects/russianBPM.png").toExternalForm())));

        setY(700);
        switch (direction) {
            case 1:
                setX(-450);
                break;
            case -1:
                setX(1850);
                this.setScaleX(-1);
                break;
        }
    }


    public double getRadius() {
        return radius;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public void shootBullet() {
    }

    private void activateNext() {
        int index = 0;
        for (BPM bpm : getGame().getCurrentWave().getBpms())
            if (bpm.equals(this))
                index = getGame().getCurrentWave().getBpms().indexOf(this) + 1;
        if (getGame().getCurrentWave().getBpms().size() > index)
            getGame().getCurrentWave().getBpms().get(index).getVehicleTransition().play();
    }

    @Override
    public void getEliminated() {
        getWave().setRemainingBpms(getWave().getRemainingBpms() - 1);
        getWave().setHitBombs(getWave().getHitBombs() + 1);
        getGame().setHitBombs(getGame().getHitBombs() + 1);
        getGame().setKills(getGame().getKills() + 3);

        activateNext();
    }
}
