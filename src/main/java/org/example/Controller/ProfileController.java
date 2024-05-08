package org.example.Controller;

import org.example.Model.Player;
import org.example.Model.Result;

public class ProfileController {

    public Result removePlayerAccount() {
        Player.removePlayer(Player.getLoggedInPlayer());
        return new Result("Account removed successfully", true);
    }

    public Result changeUsername(String username) {
        Player.getLoggedInPlayer().setUsername(username);
        return new Result("Changed username successfully", true);
    }

    public Result changePassword(String password) {
        Player.getLoggedInPlayer().setPassword(password);
        return new Result("Changed password successfully", true);
    }
}
