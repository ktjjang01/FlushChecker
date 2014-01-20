package com.landon.flushchecker;

import java.util.Random;


public class Hand {
    Random r = new Random();

    private int numCards;
    private int rSuit;
    private int rRank;
    private Card[] cardAtHand;
    private int[][] deckOfCards;

    public Hand(int numCards) {
        this.numCards = numCards;
        cardAtHand = new Card[numCards]; // Aggregation

        shuffle();
        pickRandomCard();
    }

    protected void deal() {
        for (int i = 0; i <= numCards - 1; i++) {
            cardAtHand[i] = new Card(rSuit, rRank);
            pickRandomCard();
        }
        shuffle();
    }

    protected int getNumCards() {
        return this.numCards;
    }

    protected Card[] getHand() {
        return cardAtHand;
    }

    private void shuffle() {
        deckOfCards = new int[4][13];
        rSuit = r.nextInt(4);
        rRank = r.nextInt(12) + 1;
    }

    private void pickRandomCard() {
        while (deckOfCards[rSuit][rRank - 1] != 0) {
            rSuit = r.nextInt(4);
            rRank = r.nextInt(12) + 1;
        }
        deckOfCards[rSuit][rRank - 1]++;
    }
}
