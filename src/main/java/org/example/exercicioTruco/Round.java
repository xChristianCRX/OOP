package org.example.exercicioTruco;

import org.example.exercicioTruco.deck.Card;

public class Round {
    private String winner;

    public Round(String player1, Card card1, String player2, Card card2, Card vira) {
        if ((card1.isClosed() && card2.isClosed()) || card1.equals(card2)) {
            winner = null;
            return;
        }

        if (card1.isManilha(vira) ^ card2.isManilha(vira)) {
            winner = card1.isManilha(vira) ? player1 : player2;
            return;
        }

        if (card1.isClosed() || card2.isClosed()) {
            winner = card1.isClosed() ? player2 : player1;
            return;
        }

        int comparison = card1.compareValueTo(card2, vira);
        winner = (comparison > 0) ? player1 : (comparison < 0) ? player2 : null;
    }

    public String getWinner() {
        return winner;
    }
}
