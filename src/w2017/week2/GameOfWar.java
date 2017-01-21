/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2017.week2;

import java.util.ArrayList;

/**
 *
 * @author mathi
 */
public class GameOfWar {
    private ArrayList<Card> p1hand;
    private ArrayList<Card> p2hand;
    
    //this is the constructor
    public GameOfWar()
    {
        p1hand = new ArrayList<>();
        p2hand = new ArrayList<>();
        
        DeckOfCards theDeck = new DeckOfCards();
        theDeck.shuffle();
        
        dealCards(theDeck);
    } //end of the constructor
    
    /**
     * This method will deal all the cards to each player equally
     */
    private void dealCards(DeckOfCards theDeck)
    {
        for(int cardNum=0; cardNum < 52; cardNum++)
        {
            if(cardNum % 2 ==0){
                p1hand.add(theDeck.dealTopCard());
            }else{
                p2hand.add(theDeck.dealTopCard());
            }
        }
    }
    
    /**
     * This method will simulate playing the game
     */
    public void playTheGame()
    {
        while(!p1hand.isEmpty() && !p2hand.isEmpty())
        {
            playHand();
        }
        
        if(p1hand.isEmpty())
            System.out.println("Player 2 wins!");
        else if(p2hand.isEmpty())
            System.out.println("Player 1 wins!");
    }
    
    /**
     * This will simulate playing a "hand" in the game of war
     */
    private void playHand()
    {
        if (p1hand.isEmpty() || p2hand.isEmpty())
            return;
        
        Card p1Card = p1hand.remove(0);
        Card p2Card = p2hand.remove(0);
        //System.out.println(p1hand.size() + " p1hand");
        System.out.printf("Player 1: %s, cards in hand: %d", p1Card, p1hand.size()+1);
        System.out.printf("%nPlayer 2: %s, cards in hand: %d%n", p2Card, p2hand.size()+1);
        
        //check if p1 wins
        if(p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            p1hand.add(p1Card);
            p1hand.add(p2Card);
            
        }
        //check if p2 wins
        else if(p2Card.getFaceValue() > p1Card.getFaceValue())
        {
            p2hand.add(p2Card);
            p2hand.add(p1Card);
        }
        //war round
        else
        {
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
    }
    
    /**
     * This method simulate playing a "war" hand
     * @param warPile 
     */
    private void playWarHand(ArrayList<Card> warPile)
    {
        //check if the player 1 has enough cards to play war
        if(p1hand.size() < 3)
        {
            
            p2hand.addAll(p1hand);
            p1hand.clear();
            p2hand.addAll(warPile);
            return;
        }
        //check if the player 1 has enough cards to play war
        if(p2hand.size() < 3)
        {
            p1hand.addAll(p2hand);
            p2hand.clear();
            p1hand.addAll(warPile);
            return;
        }
        
        //take 3 cards from player 1
        warPile.add(p1hand.remove(0));
        warPile.add(p1hand.remove(0));
        Card p1Card = p1hand.remove(0);
        
        //take 3 cards from player 2
        warPile.add(p2hand.remove(0));
        warPile.add(p2hand.remove(0));
        Card p2Card = p2hand.remove(0);
        
        //check if player 1 wins
        if(p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            p1hand.addAll(warPile);
            p1hand.add(p1Card);
            p1hand.add(p2Card);
        }
        //check if player 2 wins
        else if(p2Card.getFaceValue() > p1Card.getFaceValue())
        {
            p2hand.addAll(warPile);
            p2hand.add(p2Card);
            p2hand.add(p1Card);
        }
        //otherwise we must have another war
        else
        {
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
    }//end of war hand method
    
    
} //end of the class
