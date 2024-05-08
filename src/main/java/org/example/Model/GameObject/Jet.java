package org.example.Model.GameObject;


import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.example.Model.Game;
import org.example.View.Transitions.JetTransition;

public class Jet extends Rectangle {

    private final int height = 30;
    private final int width = 100;
    private final Game game;
    private int remainingRegularBombs;
    private int remainingAtomicBombs;
    private int remainingClusterBombs;
    private int freezeChargeLevel;
    private boolean isInvulnerable;
    private boolean isHit;
    private int bombsShot;
    private int bombsHit;
    private JetTransition jetTransition;
    //private JetExplosionAnim jetExplosionAnim;

    public Jet(Game game) {
        super(110, 22);
        setX(100);
        setY(500);
        this.game = game;
        remainingAtomicBombs  = 0;
        remainingRegularBombs = 3;
        remainingClusterBombs = 0;
        freezeChargeLevel = 0;
        isInvulnerable = false;
        bombsShot = 0;
        bombsHit = 0;
        this.setFill(new ImagePattern(new Image
                (Jet.class.getResource("/Pics/Objects/F-35Jet.png").toExternalForm())));
    }

    public Game getGame() {
        return game;
    }

    public int getRemainingRegularBombs() {
        return remainingRegularBombs;
    }

    public int getRemainingAtomicBombs() {
        return remainingAtomicBombs;
    }

    public int getRemainingClusterBombs() {
        return remainingClusterBombs;
    }

    public int getFreezeChargeLevel() {
        return freezeChargeLevel;
    }

    public boolean isInvulnerable() {
        return isInvulnerable;
    }

    public int getBombsShot() {
        return bombsShot;
    }

    public int getBombsHit() {
        return bombsHit;
    }

    public boolean isHit() {
        return isHit;
    }

    public JetTransition getJetTransition() {
        return jetTransition;
    }

    public void setJetTransition(JetTransition jetTransition) {
        this.jetTransition = jetTransition;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public void setRemainingRegularBombs(int remainingRegularBombs) {
        this.remainingRegularBombs = remainingRegularBombs;
    }

    public void setRemainingAtomicBombs(int remainingAtomicBombs) {
        this.remainingAtomicBombs = remainingAtomicBombs;
    }

    public void setRemainingClusterBombs(int remainingClusterBombs) {
        this.remainingClusterBombs = remainingClusterBombs;
    }

    public void setFreezeChargeLevel(int freezeChargeLevel) {
        this.freezeChargeLevel = freezeChargeLevel;
    }

    public void setInvulnerable(boolean invulnerable) {
        isInvulnerable = invulnerable;
    }

    public void setBombsShot(int bombsShot) {
        this.bombsShot = bombsShot;
    }

    public void setBombsHit(int bombsHit) {
        this.bombsHit = bombsHit;
    }

    public void fireRegularBomb() {

    }

    public void fireAtomicBomb() {

    }

    public void fireClusterBomb() {

    }

    public void explodeJet() {

    }
}
