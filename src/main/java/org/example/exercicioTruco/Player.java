package org.example.exercicioTruco;

import org.example.exercicioTruco.deck.Card;

public class Player {
    private final String name;
    private int score;
    private Card[] cards;
    private int numberCards;

    public Player(String name) {
        this.name = name;
    }

    public void setCards(Card[] cards) {
        if(cards == null || cards.length != 3) return;
        numberCards = cards.length;
        this.cards = cards;
    }

    public Card chooseCard() {
        final Card card = cards[--numberCards];
        cards[numberCards] = null;
        return card;
    }

    public void incrementScore() {
        score++;
    }

    public String getName() {
        return name;
    }

    public Card[] getCards() {
        return cards;
    }

    public int getScore() {
        return score;
    }
}
