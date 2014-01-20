package com.landon.FlushChecker;

import java.util.Scanner;

public class FlushTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean playAgain = false;

        do {
            Introduction();
            int numCards = getNumCards(console);

            Hand hand = new Hand(numCards);
            hand.deal();

            printCards(hand);

            if (hand.getNumCards() == 1) {
                System.out.println("You only have one suit: "
                        + hand.getHand()[0].getSuitAsString());
            } else {
                if (isFlush(hand)) {
                    System.out.println("You have a flush! Your cards have: "
                            + hand.getHand()[0].getSuitAsString());
                } else {
                    System.out.println("You do not have a flush.");
                }
            }

            System.out.print("Would you like to play again? [Y/n] ");
            playAgain = console.next().equals("Y");
        } while (playAgain);

        console.close();
    }

    private static void Introduction() {
        System.out.println("This program checks if randomly chosen cards have the");
        System.out.println("same suits.");
        System.out.println();
    }

    private static int getNumCards(Scanner console) {
        String prompt = "Enter number of cards you want in a hand: ";
        int target = getInt(console, prompt);

        while (target < 1 || target > 52) {
            System.err.println("Out of range; number of cards must be greater than ");
            System.err.println("0 and less then 53.");

            target = getInt(console, prompt);
        }
        return target;
    }

    private static int getInt(Scanner console, String prompt) {
        System.out.print(prompt);

        while (!console.hasNextInt()) {
            console.next();
            System.err.println("Not an integer; please try again.");
            System.out.println(prompt);
        }
        return console.nextInt();
    }

    private static void printCards(Hand hand) {
        for (int i = 0; i <= hand.getNumCards() - 1; i++) {
            String rank = hand.getHand()[i].getRankAsString();
            String suit = hand.getHand()[i].getSuitAsString();

            System.out.println(rank + " of " + suit);
        }
    }

    private static boolean isFlush(Hand hand) {
        for (int i = 0; i <= hand.getNumCards() - 2; i++) {
            if (hand.getHand()[i].getSuit() != hand.getHand()[i + 1].getSuit()) {
                return false;
            }
        }
        return true;
    }
}
