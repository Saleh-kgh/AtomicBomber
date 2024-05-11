package org.example.Controller;

import org.example.Model.Player;

public class SettingsController {

    public void setDifficultyRookie() {
        Player.getLoggedInPlayer().setCurrentDifficulty(1);
    }

    public void setDifficultyVeteran() {
        Player.getLoggedInPlayer().setCurrentDifficulty(2);
    }

    public void setDifficultyLegend() {
        Player.getLoggedInPlayer().setCurrentDifficulty(3);
    }

    public void changeSoundMuteness() {
        if (Player.getLoggedInPlayer().getGameSoundVolume() == 1)
            Player.getLoggedInPlayer().setGameSoundVolume(0);
        else
            Player.getLoggedInPlayer().setGameSoundVolume(1);
    }

    public void changeClassicTheme () {
        Player.getLoggedInPlayer().setThemeClassic(!Player.getLoggedInPlayer().isThemeClassic());
    }
}
