package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LeaderBoardController {

    public ObservableList<Player> getSortedByScore() {
        ArrayList<Player> players = new ArrayList<>(Player.getPlayers());

        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                if (p1.getTotalKills() != p2.getTotalKills())
                    return Integer.compare(p1.getTotalKills(), p2.getTotalKills());
                else
                    return Integer.compare(p1.getFinalWave(), p2.getFinalWave());
            }
        });

        ObservableList<Player> topTenScore = FXCollections.observableArrayList();

        for (int i = 0; i < 10; i++) {
            topTenScore.add(players.get(i));
        }

        return topTenScore;
    }

    public ObservableList<Player> getSortedByAccuracy() {

    }

    public ObservableList<Player> getSortedByDifficultyScore() {

    }
}
