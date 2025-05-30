package com.rccode.model;

import com.rccode.enumeration.PieceColor;
import com.rccode.enumeration.PieceType;
import com.rccode.service.PieceDecodeService;

public class Piece {
    private PieceType pieceType;
    private PieceColor pieceColor;

    public Piece(PieceType pieceType, PieceColor pieceColor) {
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
    }

    public Piece(String piece, PieceDecodeService pieceDecodeService) {
        this.pieceColor = pieceDecodeService.getPieceColorFromCharacter(piece.charAt(0));
        this.pieceType = pieceDecodeService.getPieceTypeFromCharacter(piece.charAt(1));
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }
}
