package com.rccode.service;

import com.rccode.enumeration.PieceColor;
import com.rccode.enumeration.PieceType;
import com.rccode.model.Piece;

public interface PieceDecodeService {
    PieceType getPieceTypeFromCharacter(Character c);
    PieceColor getPieceColorFromCharacter(Character c);
    String getPieceStringFromPiece(Piece piece);
}
