package com.greg.console.Secret;

import java.util.ArrayList;
import java.util.Random;

public class BlackjackGame 
{
    // region Constants
    private String[] Numbers = {
        "A", "2", "3", "4", "5",
        "6", "7", "8", "9", "10",
        "J", "Q", "K"
    };

    private String[] Suits = {
        "H", "D", "C", "S"
    };
    // endregion

    // region Classes
    private class Card 
    {
        private String number;
        private String suit;

        public Card(String number, String suit) 
        {
            this.number = number;
            this.suit = suit;
        }
        
        @Override
        public String toString() 
        {
            return number + suit;
        }
    }

    private class Player
    {
        private ArrayList<Card> cards;
        private String name;
        
        public Player(String name) 
        {
            this.cards = new ArrayList<Card>();
            this.name = name;
        }
    }
    // endregion

    // region Game Variables
    private ArrayList<Player> players;
    private ArrayList<Card> deck;
    // endregion

    private void setUp(int numberOfPlayers) 
    {
        // set up players
        this.players = new ArrayList<Player>();
        for (int i = 1; i < numberOfPlayers; i++)
        {
            this.players.add(new Player(String.format("Player %d", i)));
        }
        this.players.add(new Player("House"));

        // set up deck
        var cards = new ArrayList<Card>();
        for (var n : this.Numbers)
        {
            for (var suit : this.Suits)
            {
                cards.add(new Card(n, suit));
            }
        }
        this.deck = shuffle(cards);
    }

    private ArrayList<Card> shuffle(ArrayList<Card> cards) 
    {
        Random rand = new Random();
        var shuffledCards = new ArrayList<Card>();
        while (cards.size() != 0)
        {
            int randomIndex = rand.nextInt(cards.size());
            Card randomCard = cards.get(randomIndex);
            cards.remove(randomIndex);
            shuffledCards.add(randomCard);
        }
        return shuffledCards;
    }

    public void Run() 
    {
        Run(1);
    }

    public void Run(int numberOfPlayers) 
    {
        setUp(numberOfPlayers);
    }
}
