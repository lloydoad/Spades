/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import constants.Constants;
import constants.Constants.SUIT_OF_CARDS;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lloyd Dapaah
 */
public class Game {
    private SUIT_OF_CARDS winningSuit;
    private Player leadPlayer;
    private Player dealerPlayer;
    private Player winningPlayer;
    private int currentRound;
    private int initialDealerNumber;
    private ArrayList<Team> teams;
    private ArrayList<Player> table;
    private Deck deck;
    private Scanner input;
    
    // constructors for game create teams, print teams, creates deck and 
    // prints deck
    public Game(){
        createTeams();
        outputTeams();
        generateDeck();
        setTable();
        dealHand();
        displayHands();
    }

    // getters and setters
    public SUIT_OF_CARDS getWinningSuit() {
        return winningSuit;
    }

    public Player getLeadPlayer() {
        return leadPlayer;
    }

    public Player getDealerPlayer() {
        return dealerPlayer;
    }

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setWinningSuit(SUIT_OF_CARDS winningSuit) {
        this.winningSuit = winningSuit;
    }

    public void setLeadPlayer(Player leadPlayer) {
        this.leadPlayer = leadPlayer;
    }

    public void setDealerPlayer(Player dealerPlayer) {
        this.dealerPlayer = dealerPlayer;
    }

    public void setWinningPlayer(Player winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public void setTeams(ArrayList<Team> team) {
        this.teams = team;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    
    // create new deck
    private void generateDeck() {
        deck = new Deck();
    }
    
    // get a single player
    // add single player to team 1 with AI
    // create team two with AI players
    private void createTeams() {
        int i;
        String nameOne;
        HumanPlayer playerOne = new HumanPlayer();
        teams = new ArrayList();
        Team teamOne = new Team();
        Team teamTwo = new Team();
        
        teamOne.setTeamName("Team One");
        teamTwo.setTeamName("Team Two");
        
        teams.add(teamOne);
        teams.add(teamTwo);
        
        input = new Scanner(System.in);
        // prompt player for name
        System.out.println("Enter human player name");
        nameOne = input.next();
        playerOne.setPlayerName(nameOne);
        
        System.out.println("Human Player added to Team One");
        teamOne.getaTeam().add(playerOne);
        
        for(i = 1; i <= Constants.AI_PLAYERS; i++){
            AiPlayer aiPlayer = new AiPlayer();
            
            aiPlayer.setPlayerName("AI " + i);
            
            if(i < 2)
                teamOne.getaTeam().add(aiPlayer);
            else
                teamTwo.getaTeam().add(aiPlayer);
        }   
    }
    
    // run through teams container and print team names
    // at every team, run through and print player names
    private void outputTeams() {
        for(Team teamGroup: teams){
            System.out.println(teamGroup.getTeamName() + " includes players:");
            
            for(Player playerList: teamGroup.getaTeam()){
                System.out.println("Player: " + playerList.getPlayerName());
            }
        }
    }
    
    // set table function
    // create table variable and add players sequentially. Generate 
    // random dealer
    private void setTable() {
        table = new ArrayList();
        Team tableTeamOne = teams.get(0);
        Team tableTeamTwo = teams.get(1);
        
        Player teamOnePlayerOne = tableTeamOne.getaTeam().get(0);
        Player teamOnePlayerTwo = tableTeamOne.getaTeam().get(1);
        Player teamTwoPlayerOne = tableTeamTwo.getaTeam().get(0);
        Player teamTwoPlayerTwo = tableTeamTwo.getaTeam().get(1);
        
        table.add(0, teamOnePlayerOne);
        table.add(1, teamTwoPlayerOne);
        table.add(2, teamOnePlayerTwo);
        table.add(3, teamTwoPlayerTwo);
       
        Random randomGen = new Random();
        initialDealerNumber = randomGen.nextInt(4);
        
        dealerPlayer = table.get(initialDealerNumber);
    }

    public int getInitialDealerNumber() {
        return initialDealerNumber;
    }
    
    // deal hand to each player on table in alternating pattern
    // start on the left of dealer
    // reset player receiving card based on iterations
    // remove card from deck as they are dealt
    private void dealHand() {
        int cPlayerNumber;
        
        if(initialDealerNumber < 3)
            cPlayerNumber = initialDealerNumber + 1;
        else 
            cPlayerNumber = 0;
        
        System.out.println("\n***Starting to deal***");
        for(Iterator<Card> cCard = deck.getDeckOfCards().iterator(); cCard.hasNext();) {
            Card curCard = cCard.next();
            
            System.out.println("Dealing card to " + table.get(cPlayerNumber).getPlayerName());
            table.get(cPlayerNumber).getHand().add(curCard);
            
            if(cPlayerNumber == 3)
                cPlayerNumber = 0;
            else
                cPlayerNumber++;
            
            cCard.remove();
        }
    }
    
    // loop through teams and players and call display hands
    private void displayHands() {
        System.out.println("\n***Displaying player hands***");
        
        for(Team cTeam: teams) {
            System.out.println("\n***Displaying " + cTeam.getTeamName() + " hands");
            for(Player cPlayer: cTeam.getaTeam()) {
                System.out.println("***Displaying " + cPlayer.getPlayerName() + "s hand***");
                cPlayer.displayHand();
            }
        }
    }
}
