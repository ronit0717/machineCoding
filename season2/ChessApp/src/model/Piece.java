package model;

import enums.PieceColor;
import enums.PieceType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Piece {
   private int id;
   private PieceType pieceType;
   private PieceColor pieceColor;
}
