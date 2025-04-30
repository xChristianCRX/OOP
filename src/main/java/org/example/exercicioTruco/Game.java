package org.example.exercicioTruco;

public class Game {
    private Player player1;
    private Player player2;
    private Hand[] hands = new Hand[30];
    int handsCount = 0;
    public int scorePlayer1 = 0;
    public int scorePlayer2 = 0;

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        Hand hand = new Hand(player1, player2);
        hands[handsCount++] = hand;
    }

    public void play(){
        Hand currentHand = hands[handsCount-1];

        if(currentHand.isDone()){
            String winner = currentHand.getWinner();

            if(winner != null){
                if(winner.equals(player1.getName())) {
                    System.out.println(player1.getName() + " wins!");
                    scorePlayer1++;
                }
                else if(winner.equals(player2.getName())) {
                    System.out.println(player2.getName() + " wins!");
                    scorePlayer2++;
                }
            }else{
                System.out.println("Empate!");
            }

            Hand newHand = new Hand(player1, player2);
            hands[handsCount++] = newHand;

            if(!isDone()){
                newHand.playRound();
            }
        }else{
            currentHand.playRound();
        }
    }

    public boolean isDone(){
        return scorePlayer1 >= 12 || scorePlayer2 >= 12;
    }

    public Player getWinner(){
        if(!isDone()) return null;
        if(scorePlayer1 >= 12) return player1;
        else return player2;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }
}
