package com.landon.flushchecker;

public class Card {
    // TODO: use enums instead of ints for suits and ranks
    private int suit;
    private int rank;

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuitAsString() {
        String SUIT;
        if (suit == 0) {
            SUIT = "CLUBS";
        } else if (suit == 1) {
            SUIT = "DIAMONDS";
        } else if (suit == 2) {
            SUIT = "HEARTS";
        } else { // assume suit == 3, but not guaranteed; use enum...
            SUIT = "SPADES";
        }
        return SUIT;
    }

    public String getRankAsString() {
        String RANK;
        if (rank == 1) {
            RANK = "ACE";
        } else if (rank == 11) {
            RANK = "JACK";
        } else if (rank == 12) {
            RANK = "QUEEN";
        } else if (rank == 13) {
            RANK = "KING";
        } else { // 2, 3, ... ,10
            RANK = Integer.toString(rank);
        }
        return RANK;
    }
}
