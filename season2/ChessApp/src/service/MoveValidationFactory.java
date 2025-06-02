package service;

import enums.PieceType;
import model.Piece;
import service.impl.*;

public class MoveValidationFactory {

    public MovementValidationService getMovementValidationService(Piece piece) {
        if (piece == null) {
            throw new IllegalArgumentException("Piece cannot be null");
        }

        PieceType pieceType = piece.getPieceType();
        return switch (pieceType) {
            case PAWN -> new PawnMovementValidationService();
            case ROOK -> new RookMovementValidationService();
            case BISHOP -> new BishopMovementValidationService();
            case KNIGHT -> new KnightMovementValidationService();
            case QUEEN -> new QueenMovementValidationService();
            case KING -> new KingMovementValidationService();
        };
    }

}
