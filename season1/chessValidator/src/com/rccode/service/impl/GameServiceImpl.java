package com.rccode.service.impl;

import com.rccode.exception.ProcessException;
import com.rccode.model.Game;
import com.rccode.model.Player;
import com.rccode.service.BoardService;
import com.rccode.service.GameService;
import com.rccode.service.PieceDecodeService;

public class GameServiceImpl implements GameService {

    private Game game;
    private PieceDecodeService pieceDecodeService;
    private BoardService boardService;

    public GameServiceImpl() {
        this.pieceDecodeService = new PieceDecodeServiceImpl();
        this.boardService = new BoardServiceImpl();
        this.game = new Game(pieceDecodeService);
    }

    @Override
    public void nextMove(String from, String to) {
        try {
            if (from.equals(to)) {
                throw new ProcessException("Next Move", "From and To same position");
            }
            int fromIndex = boardService.getBoardIndexFromStr(from);
            int toIndex = boardService.getBoardIndexFromStr(to);

            Player currentPlayer = game.getCurrentPlayer();
            boardService.move(game.getBoard(), currentPlayer, fromIndex, toIndex);
            game.setNextPlayer();
            printGame();
        } catch (Exception e) {
            System.out.println("Invalid move");
        }
    }

    @Override
    public void printGame() {
        boardService.printBoard(game.getBoard());
    }
}
