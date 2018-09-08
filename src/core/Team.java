/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author Lloyd Dapaah
 */
public class Team {
    private ArrayList<Player> aTeam;
    private int teamBid;
    private int teamScore;
    private int teamTricksTaken;
    private int teamBag;
    private String teamName;
    
    public Team() {
         this.aTeam = new ArrayList();
    }
    
    // getters and setters
    public void setaTeam(ArrayList<Player> aTeam) {
        this.aTeam = aTeam;
    }

    public ArrayList<Player> getaTeam() {
        return aTeam;
    }

    public int getTeamBid() {
        return teamBid;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public int getTeamTricksTaken() {
        return teamTricksTaken;
    }

    public int getTeamBag() {
        return teamBag;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamBid(int teamBid) {
        this.teamBid = teamBid;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public void setTeamTricksTaken(int teamTricksTaken) {
        this.teamTricksTaken = teamTricksTaken;
    }

    public void setTeamBag(int teamBag) {
        this.teamBag = teamBag;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    
}
