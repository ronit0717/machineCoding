package com.rccode.model;

import com.rccode.enumeration.PieceColor;
import com.rccode.service.PieceDecodeService;
import com.rccode.service.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayer;

    public Game(PieceDecodeService pieceDecodeService) {
        this.board = new Board(pieceDecodeService);

        this.players = new ArrayList<>(2);
        this.players.add(new Player(RandomUtil.getRandomId(), PieceColor.WHITE));
        this.players.add(new Player(RandomUtil.getRandomId(), PieceColor.BLACK));

        this.currentPlayer = 0;
    }

    public void setNextPlayer() {
        this.currentPlayer = (this.currentPlayer + 1) % players.size();
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public Board getBoard() {
        return board;
    }
}
