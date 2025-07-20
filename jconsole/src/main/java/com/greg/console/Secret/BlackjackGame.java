package com.greg.console.Secret;

import java.util.ArrayList;
import java.util.Random;

public class BlackjackGame 
{
    // region Constants
    private String[] Suits = {
        "H", "D", "C", "S"
    };
    // endregion

    // region Classes
    private class Card 
    {
        public static String[] Numbers = {
            "A", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "J", "Q", "K"
        };

        private int number;
        private String suit;

        public Card(int number, String suit) 
        {
            this.number = number;
            this.suit = suit;
        }

        public String getNumberStr() {
            return Numbers[this.number - 1];
        }

        public int getNumberInt() {
            return this.number;
        }

        public String getSuit() {
            return this.suit;
        }
        
        @Override
        public String toString() 
        {
            return number + suit;
        }

        @Override
        public boolean equals(Object obj) 
        {
            // Check if the compared objects are the same instance
            if (this == obj) 
            {
                return true;
            }

            // Check if the obj is null or not the same class
            if (obj == null || getClass() != obj.getClass()) 
            {
                return false;
            }
            // Cast the object to Person and compare the data members
            Card other = (Card) obj;
            return this.number == other.number && this.suit.equals(other.suit);
        }

        public int add(Card other)
        {
            return number + other.number;
        }
    }

    private class Player
    {
        private ArrayList<Card> cards;
        private String name;
        private PlayerType playerType;
        
        public Player(String name, PlayerType playerType) 
        {
            this.cards = new ArrayList<Card>();
            this.name = name;
            this.playerType = playerType;
        }

        public String getName() {
            return this.name;
        }

        public PlayerType getPlayerType() {
            return this.playerType;
        }

        public int getTotal() {
            var total = 0;
            for (var card : cards) {
                total += card.getNumberInt();
            }
            return total;
        }

        @Override
        public String toString()
        {
            var info = "Player: " + this.name + "\nCards:\n";
            for (var card : this.cards)
            {
                info += card.toString() + "\n";
            }
            info += "Total: " + getTotal();
            return info;
        }
    }
    // endregion

    // region Enums
    private enum PlayerType 
    {
        Player, House
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
            this.players.add(new Player(String.format("Player %d", i), PlayerType.Player));
        }
        this.players.add(new Player("House", PlayerType.House));

        // set up deck
        var cards = new ArrayList<Card>();
        for (int n = 1; n <= 13; n++)
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

    private void dealCards(ArrayList<Player> players, ArrayList<Card> cards) 
    {
        var rand = new Random();
        for (var player : players)
        {
            for (int i = 0; i < 2; i++) 
            {
                var randIndex = rand.nextInt(cards.size());
                var selectedCard = cards.get(randIndex);
                player.cards.add(selectedCard);
                cards.remove(randIndex);
            }
        }
    }

    private void displayPlayerInfos(ArrayList<Player> players)
    {
        for (var player : players) 
        {
            System.out.println(player.toString());
        }
    }

    public void Run() 
    {
        Run(1);
    }

    public void Run(int numberOfPlayers) 
    {
        setUp(numberOfPlayers);
        dealCards(this.players, this.deck);
        displayPlayerInfos(players);
    }
}
