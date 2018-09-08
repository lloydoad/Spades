/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import constants.Constants.COLOR;
import constants.Constants.FACE_OF_CARDS;
import constants.Constants.SUIT_OF_CARDS;

/**
 *
 * @author Lloyd Dapaah
 */
public class Card {
    private FACE_OF_CARDS faceValue;
    private SUIT_OF_CARDS suitValue;
    private COLOR color;
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        return hashCode;
    }
    
    // return true if new card instant is already used
    @Override
    public boolean equals(Object input)
    {
        if(input instanceof Card){
            Card card = (Card) input;
            return (card.faceValue.equals(this.faceValue) 
                    && card.color.equals(this.color)
                    && card.suitValue.equals(this.suitValue));
        }else {
            return false;
        }
    }
    
    // getters and setters for face, suit and color
    public FACE_OF_CARDS getFaceValue() {
        return faceValue;
    }

    public SUIT_OF_CARDS getSuitValue() {
        return suitValue;
    }

    public COLOR getColor() {
        return color;
    }

    public void setFaceValue(FACE_OF_CARDS faceValue) {
        this.faceValue = faceValue;
    }

    public void setSuitValue(SUIT_OF_CARDS suitValue) {
        this.suitValue = suitValue;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }
    
}
