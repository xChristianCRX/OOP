package org.example.exercicioTruco;

import org.example.exercicioTruco.deck.Card;
import org.example.exercicioTruco.deck.Deck;

public class Hand {
    private final Card vira;
    private final Round[] rounds = new Round[3];
    private final Player player1;
    private final Player player2;
    int numberRounds = 0;
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

    public Hand(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        Deck deck = new Deck();
        deck.shuffle();

        vira = deck.takeOne();
        player1.setCards(deck.take(3));
        player2.setCards(deck.take(3));
    }

    public void playRound(){
        Card card1 = player1.chooseCard();
        Card card2 = player2.chooseCard();
        Round round = new Round(player1.getName(), card1, player2.getName(), card2, vira);
        System.out.println(round.getWinner() != null ? round.getWinner() : "Rodada empatada");

        if(round.getWinner() != null){
            if(round.getWinner().equals(player1.getName())) scorePlayer1++;
            else if(round.getWinner().equals(player2.getName())) scorePlayer2++;
        }

        rounds[numberRounds] = round;
        numberRounds++;
    }

    public boolean isDone(){
        analyzeRounds();
        if(numberRounds == 1 || numberRounds == 0) return false;
        else if(numberRounds == 2 && (scorePlayer1 == 2 || scorePlayer2 == 2)) return true;
        else return numberRounds == 3;
    }

    private void analyzeRounds() {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        for(Round round : rounds){
            if(round == null) continue;

            if(round.getWinner() != null){
                if(round.getWinner().equals(player1.getName())) scorePlayer1++;
                else if(round.getWinner().equals(player2.getName())) scorePlayer2++;
            }
        }
    }

    public String getWinner(){
        if(!isDone()) return null;
        return scorePlayer1 > scorePlayer2 ? player1.getName()
                : scorePlayer1 < scorePlayer2 ? player2.getName()
                : null;
    }
}
