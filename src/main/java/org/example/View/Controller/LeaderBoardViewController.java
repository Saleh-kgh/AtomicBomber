package org.example.View.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.Model.Player;

import javax.swing.text.TabableView;
import java.util.Collections;
import java.util.Comparator;

public class LeaderBoardViewController {

    @FXML
    private TableView<Player> tableView;
    @FXML
    private TableColumn<Player, String> usernameColumn;
    @FXML
    private TableColumn<Player, Integer> scoreColumn;
    @FXML
    private TableColumn<Player, Double> accuracyColumn;
    @FXML
    private TableColumn<Player, Double> difficultyScoreColumn;
    @FXML
    private TableColumn<Player, Integer> finalWaveColumn;
    private ObservableList<Player> players = FXCollections.observableArrayList();

    public void initialize() {
        // Set up columns
        usernameColumn.setCellValueFactory(cellData -> cellData.getValue().tableUsernameProperty());
        scoreColumn.setCellValueFactory(cellData -> cellData.getValue().tableScoreProperty().asObject());
        accuracyColumn.setCellValueFactory(cellData -> cellData.getValue().tableAccuracyProperty().asObject());
        difficultyScoreColumn.setCellValueFactory(cellData -> cellData.getValue().tableDifficultyScoreProperty().asObject());
        finalWaveColumn.setCellValueFactory(cellData -> cellData.getValue().tableFinalWaveProperty().asObject());
    }

    // Method to update the TableView with sorted players based on the selected criterion
    private void updateTableView(ObservableList<Player> sortedPlayers) {
        tableView.setItems(sortedPlayers);
    }

    // Method to sort players based on accuracy
    public void sortByAccuracy() {
        ObservableList<Player> sortedPlayers = FXCollections.observableArrayList(players);
        updateTableView(sortedPlayers);
    }

    // Method to sort players based on score
    public void sortByScore() {
        ObservableList<Player> sortedPlayers = FXCollections.observableArrayList(players);
        updateTableView(sortedPlayers);
    }

    // Method to sort players based on difficulty score
    public void sortByDifficultyScore() {
        ObservableList<Player> sortedPlayers = FXCollections.observableArrayList(players);
        updateTableView(sortedPlayers);
    }

    // Add other methods as needed
}
}
