package service.impl;

import dto.Position;
import model.Board;
import model.Player;
import service.MovementValidationService;

public class RookMovementValidationService implements MovementValidationService {
    @Override
    public boolean validateMovement(Board board, Position from, Position to, Player player) {
        return false;
    }
}
