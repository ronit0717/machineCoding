package com.rccode.service.impl;

import com.rccode.enumeration.PieceColor;
import com.rccode.enumeration.PieceType;
import com.rccode.model.Piece;
import com.rccode.service.PieceDecodeService;

import java.util.HashMap;
import java.util.Map;

public class PieceDecodeServiceImpl implements PieceDecodeService {

    private Map<Character, PieceType> map;
    private Map<Character, PieceColor> colorMap;

    public PieceDecodeServiceImpl() {
        this.map = new HashMap<>();
        map.put('P', PieceType.PAWN);
        map.put('R', PieceType.ROOK);
        map.put('N', PieceType.KNIGHT);
        map.put('B', PieceType.BISHOP);
        map.put('Q', PieceType.QUEEN);
        map.put('K', PieceType.KING);

        this.colorMap = new HashMap<>();
        colorMap.put('W', PieceColor.WHITE);
        colorMap.put('B', PieceColor.BLACK);
    }

    @Override
    public PieceType getPieceTypeFromCharacter(Character c) {
        return map.get(c);
    }

    @Override
    public PieceColor getPieceColorFromCharacter(Character c) {
        return colorMap.get(c);
    }

    @Override
    public String getPieceStringFromPiece(Piece piece) {
        if (piece == null) {
            return "--";
        }
        return String.valueOf(piece.getPieceColor().getPieceColorCode()) + piece.getPieceType().getPieceColorCode();
    }

}
