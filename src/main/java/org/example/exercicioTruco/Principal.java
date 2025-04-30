package org.example.exercicioTruco;

public class Principal {
    public static void main(String[] args) {
        Player player1 = new Player("Chris");
        Player player2 = new Player("Leo");

        Game game = new Game(player1, player2);
        while(!game.isDone()){
            game.play();
        }

        System.out.println("Vencedor da partida: "+game.getWinner().getName());
        System.out.println(game.getScorePlayer1());
        System.out.println(game.getScorePlayer2());
    }
}
