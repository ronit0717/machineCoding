package service;

import dto.Position;
import model.Board;
import model.Player;

public interface MovementValidationService {
    boolean validateMovement(Board board, Position from, Position to, Player player);
}
