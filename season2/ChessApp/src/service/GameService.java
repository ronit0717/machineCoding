package service;

import dto.Position;
import model.Board;
import model.Game;
import model.Piece;
import model.Player;

public class GameService {

    private final MoveValidationFactory moveValidationFactory;
    private final Game game;

    public GameService(MoveValidationFactory moveValidationFactory, Game game) {
        this.moveValidationFactory = moveValidationFactory;
        this.game = game;
    }

    public boolean isValidMove(Player player, int fromX, int fromY, int toX, int toY) {
        Position from = new Position(fromX, fromY);
        Position to = new Position(toX, toY);
        Board board = game.getBoard();
        Piece piece = board.getPieceArray()[fromX][fromY];
        MovementValidationService movementValidationService = moveValidationFactory.getMovementValidationService(piece);
        return movementValidationService.validateMovement(board, from, to, player);
    }

}
