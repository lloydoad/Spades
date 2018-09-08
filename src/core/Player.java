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
public abstract class Player implements IPlayer {
    private String playerName;
    private int tricksTaken;
    private int tricksBid;
    private int currentScore;
    private ArrayList<Card> hand;
    private int i = 0;
    
    public Player() {
        hand = new ArrayList();
    }

    // getters and setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getTricksTaken() {
        return tricksTaken;
    }

    public void setTricksTaken(int tricksTaken) {
        this.tricksTaken = tricksTaken;
    }

    public int getTricksBid() {
        return tricksBid;
    }

    public void setTricksBid(int tricksBid) {
        this.tricksBid = tricksBid;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
    
    @Override
    public abstract Card playCard();
    
    @Override
    public abstract int placeBids();

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
    
    public void displayHand() {
        for(Card cCard: hand) {
            System.out.println(i + ", " + cCard.getSuitValue() + " of " + cCard.getFaceValue());
            i++;
        }
    }
   

    
    
}
