/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import constants.Constants;
import java.util.HashSet;
import java.util.Set;
import constants.Constants.FACE_OF_CARDS;
import constants.Constants.SUIT_OF_CARDS;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lloyd Dapaah
 */
public class Deck {
    private Set<Card> deckOfCards;
    
    // deck constructor creates, shuffles and prints deck
    public Deck() {
        generateDeck();
        
        System.out.println("\n************************\n"
                         + "Displaying deck of cards\n"
                         + "************************");
        System.out.println("Deck size: " + deckOfCards.size() + " cards"
                         + "\nDeck includes");
        displayDeck();
        System.out.println("\n************************\n"
                         + "Shuffling deck of cards\n"
                         + "************************");
        shuffleDeck();
        System.out.println("************************\n"
                         + "Displaying deck of cards\n"
                         + "************************");
        System.out.println("Deck size: " + deckOfCards.size() + " cards"
                         + "\nDeck includes");
        displayDeck();
    }

    // getters and setters
    public Set<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(Set<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
    
    // generate cards using each suit and face
    // set color of card based on suit and face
    private void generateDeck() {
        deckOfCards = new HashSet();
        
        for(FACE_OF_CARDS face: FACE_OF_CARDS.values()) {
            for(SUIT_OF_CARDS suit: SUIT_OF_CARDS.values()) {
                Card newCard = new Card();
                
                newCard.setFaceValue(face);
                newCard.setSuitValue(suit);
                
                if(newCard.getSuitValue() == SUIT_OF_CARDS.CLUBS
                   || newCard.getSuitValue() == SUIT_OF_CARDS.SPADES) {
                    newCard.setColor(Constants.COLOR.BLACK);
                } else {
                    newCard.setColor(Constants.COLOR.RED);
                }
                
                if(!(deckOfCards.contains(newCard))) {
                    deckOfCards.add(newCard);
                }
            }
        }
    }
    
    // print out cards in deck
    private void displayDeck() {
        for(Card c: deckOfCards) {
            System.out.println( "Card: " +
                    c.getFaceValue().name() + " of " + 
                    c.getSuitValue().name() + " is color " + 
                    c.getColor().name());
        }
    }
    
    // create a list from set, shuffle list, put list back into set
    private void shuffleDeck() {
        ArrayList list = new ArrayList(deckOfCards);
        
        Collections.shuffle(list);
        deckOfCards = new HashSet(list);
    }
}
