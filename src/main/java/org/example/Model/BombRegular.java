package org.example.Model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import org.example.View.Animations.BombRegularExplosion;

public class BombRegular extends Bomb{

    private BombRegularExplosion bombRegularExplosion;

    public BombRegular(Jet jet, Game game) {
        super(jet, game, 50);
        jet.setRemainingRegularBombs(jet.getRemainingRegularBombs() - 1);

        this.setFill(new ImagePattern(new Image
                (Jet.class.getResource("/Pics/Objects/BombRegular.png").toExternalForm())));

        game.getGamePane().getChildren().add(this);

        bombRegularExplosion = new BombRegularExplosion(this, game.getGamePane());
    }

    public BombRegularExplosion getBombRegularExplosion() {
        return bombRegularExplosion;
    }

    public void setBombRegularExplosion(BombRegularExplosion bombRegularExplosion) {
        this.bombRegularExplosion = bombRegularExplosion;
    }

    @Override
    public void explodeBomb() {
        bombRegularExplosion.play();
    }
}
