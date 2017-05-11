package com.cs60333.kgifaldi.lab2_kgifaldi;

import java.io.Serializable;

/**
 * Created by Kyle on 3/1/2017.
 */
public class Team implements Serializable {
    String teamLogo;
    String teamName;
    String gameDate;
    String teamMascot;
    String teamRecord;
    String finalScore;

    //String[] temp = new String[]{"fs", "Florida State", "Feb 11", "Osceola and Renegade", "(5-20)", "55-99"};

    public Team (String team_logo, String team_name, String game_date, String team_mascot, String team_record, String final_score) {
        setTeamName(team_name);
        setTeamLogo(team_logo);
        setGameDate(game_date);
        setTeamMascot(team_mascot);
        setTeamRecord(team_record);
        setFinalScore(final_score);
    }

    public void setTeamName(String team_name) {
        this.teamName = team_name;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamLogo(String team_logo) {
        this.teamLogo = team_logo;
    }

    public String getTeamLogo() {
        return this.teamLogo;
    }

    public void setGameDate(String game_date) {
        this.gameDate = game_date;
    }

    public String getGameDate() {
        return this.gameDate;
    }

    public void setTeamMascot(String team_mascot) {
        this.teamMascot = team_mascot;
    }

    public String getTeamMascot() {
        return this.teamMascot;
    }

    public void setTeamRecord(String team_record) {
        this.teamRecord = team_record;
    }

    public String getTeamRecord() {
        return this.teamRecord;
    }

    public void setFinalScore(String final_score) {
        this.finalScore = final_score;
    }

    public String getFinalScore() {
        return this.finalScore;
    }
}