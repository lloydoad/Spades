/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author Lloyd Dapaah
 */

// set up constants including color, suit and face
public class Constants {
    public static final int AI_PLAYERS = 3;
    public static final int CARDS_IN_DECK = 52;
    public static final int CARDS_DEALT = 13;
    public static final int ROUNDS_PER_GAME = 13;
    public static final int MINIMUM_BID = 1;
    public static final int WINNING_SCORE = 200;
    public enum COLOR {
        RED, BLACK;
    }
    public enum SUIT_OF_CARDS {
        CLUBS, DIAMONDS, HEARTS, SPADES;
    }
    public enum FACE_OF_CARDS {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, 
        NINE, TEN, JACK, QUEEN, KING, ACE;
    }
}
