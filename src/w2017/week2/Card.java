/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2017.week2;

/**
 *
 * @author mathi
 */
public class Card {
    private String faceName, suit;
    private int faceValue;
    
    public Card(String faceName, String suit, int value)
    {
        this.faceName = faceName;
        setSuit(suit);
        
    }
    
    /**
     * This method will validate the argument is in the range 2-14 and set the face value accordingly.
     */
    private void setFaceValue(int value)
    {
        if (value >=2 && value <=14)
            faceValue = value;
        else
            throw new IllegalArgumentException("card must have values in the range of 2-14");
    }
   
    
    /**
     * This method will validate that the argument is hearts, diamonds, spades or clubs. If it is, then will set the instance variable for the class.
     * If it is not a input, it will throw an exception.
     */
    private void setSuit(String suit)
    {
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") || suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("clubs"))
            this.suit = suit;
        else
            throw new IllegalArgumentException("suit must be hearts, diamonds, spades or clubs");
    }
    
    /**
     * This method will return a String to represent the card
     */
    @Override
    public String toString()
    {
        return faceName + " of " + suit;
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

    //just a random comment
}
