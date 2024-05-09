package org.example.Model;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String username;
    private String password;
    private String avatarAddress;
    private int totalKills;
    private int difficultyBasedKills;
    private int shotBombs;
    private int hitBombs;
    private int finalWave;
    private double accuracy;
    private int currentDifficulty; // for easy 2 for med 3 for hard
    private static ArrayList<Player> players = new ArrayList<>();
    private static Player loggedInPlayer;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.setRandomAvatar();
        currentDifficulty = 1;
        totalKills = 0;
        difficultyBasedKills = 0;
        shotBombs = 0;
        hitBombs = 0;
        finalWave = 0;
        accuracy = 0;
        players.add(this);
    }

    private void setRandomAvatar() {
        Random random = new Random();
        int randomNumber = random.nextInt(4) + 1;
        switch (randomNumber) {
            case 1:
                this.avatarAddress = "D:/AP/AtomicBomber/AlphaVersion/src/main/resources/Pics/Avatars/f18hornet.jpg";
                break;
            case 2:
                this.avatarAddress = "D:/AP/AtomicBomber/AlphaVersion/src/main/resources/Pics/Avatars/f16falcon.jpg";
                break;
            case 3:
                this.avatarAddress = "D:/AP/AtomicBomber/AlphaVersion/src/main/resources/Pics/Avatars/f15eagle.jpg";
                break;
            case 4:
                this.avatarAddress = "D:/AP/AtomicBomber/AlphaVersion/src/main/resources/Pics/Avatars/eurotyphoon.jpg";
                break;

        }
    }

    public void setExactAvatarAddress(String avatarName) {
        String address = "D:/AP/AtomicBomber/AlphaVersion/src/main/resources/Pics/Avatars/" + avatarName;
        this.avatarAddress = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    public int getHitBombs() {
        return hitBombs;
    }

    public void setHitBombs(int hitBombs) {
        this.hitBombs = hitBombs;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getDifficultyBasedKills() {
        return difficultyBasedKills;
    }

    public void setDifficultyBasedKills(int difficultyBasedKills) {
        this.difficultyBasedKills = difficultyBasedKills;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public int getShotBombs() {
        return shotBombs;
    }

    public void setShotBombs(int shotBombs) {
        this.shotBombs = shotBombs;
    }

    public int getFinalWave() {
        return finalWave;
    }

    public void setFinalWave(int finalWave) {
        this.finalWave = finalWave;
    }

    public int getCurrentDifficulty() {
        return currentDifficulty;
    }

    public void setCurrentDifficulty(int currentDifficulty) {
        this.currentDifficulty = currentDifficulty;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static Player getPlayerByName(String username) {
        for (Player player:  players) {
            if (player.getUsername().equals(username))
                return player;
        }
        return null;
    }

    public static boolean doesPlayerExist(String username) {
        return getPlayerByName(username) != null;
    }

    public static void setLoggedInPlayer(Player player) {
        loggedInPlayer = player;
    }

    public static Player getLoggedInPlayer() {
        return loggedInPlayer;
    }

    public static void removePlayer(Player player) {
        if (player.equals(loggedInPlayer))
            loggedInPlayer = null;
        players.remove(player);
    }
}
