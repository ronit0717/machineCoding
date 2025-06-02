package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Game {
    int id;
    Player player1;
    Player player2;
    Board board;

    public Game(int id, Player player1, Player player2) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(8);
    }
}
