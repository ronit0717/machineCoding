package model;

import enums.PieceColor;
import enums.PieceType;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Board {
    Piece[][] pieceArray;
    Set<Piece> deadPieces;

    public Board(int size) {
        this.pieceArray = new Piece[size][size];
        this.deadPieces = new HashSet<>();
        initBoard();
    }

    public void updateCell(Piece piece, int x, int y) {
        this.pieceArray[x][y] = piece;
    }

    private void initBoard() {
        Piece whitePawn1 = new Piece(1, PieceType.PAWN, PieceColor.WHITE);
        Piece whitePawn2 = new Piece(2, PieceType.PAWN, PieceColor.WHITE);
        Piece whitePawn3 = new Piece(3, PieceType.PAWN, PieceColor.WHITE);
        Piece whitePawn4 = new Piece(4, PieceType.PAWN, PieceColor.WHITE);
        Piece whitePawn5 = new Piece(5, PieceType.PAWN, PieceColor.WHITE);
        Piece whitePawn6 = new Piece(6, PieceType.PAWN, PieceColor.WHITE);
        Piece whitePawn7 = new Piece(7, PieceType.PAWN, PieceColor.WHITE);
        Piece whitePawn8 = new Piece(8, PieceType.PAWN, PieceColor.WHITE);
        Piece whiteRook1 = new Piece(9, PieceType.ROOK, PieceColor.WHITE);
        Piece whiteRook2 = new Piece(10, PieceType.ROOK, PieceColor.WHITE);
        Piece whiteKnight1 = new Piece(11, PieceType.KNIGHT, PieceColor.WHITE);
        Piece whiteKnight2 = new Piece(12, PieceType.KNIGHT, PieceColor.WHITE);
        Piece whiteBishop1 = new Piece(13, PieceType.BISHOP, PieceColor.WHITE);
        Piece whiteBishop2 = new Piece(14, PieceType.BISHOP, PieceColor.WHITE);
        Piece whiteQueen = new Piece(15, PieceType.QUEEN, PieceColor.WHITE);
        Piece whiteKing = new Piece(16, PieceType.KING, PieceColor.WHITE);
        Piece blackPawn1 = new Piece(17, PieceType.PAWN, PieceColor.BLACK);
        Piece blackPawn2 = new Piece(18, PieceType.PAWN, PieceColor.BLACK);
        Piece blackPawn3 = new Piece(19, PieceType.PAWN, PieceColor.BLACK);
        Piece blackPawn4 = new Piece(20, PieceType.PAWN, PieceColor.BLACK);
        Piece blackPawn5 = new Piece(21, PieceType.PAWN, PieceColor.BLACK);
        Piece blackPawn6 = new Piece(22, PieceType.PAWN, PieceColor.BLACK);
        Piece blackPawn7 = new Piece(23, PieceType.PAWN, PieceColor.BLACK);
        Piece blackPawn8 = new Piece(24, PieceType.PAWN, PieceColor.BLACK);
        Piece blackRook1 = new Piece(25, PieceType.ROOK, PieceColor.BLACK);
        Piece blackRook2 = new Piece(26, PieceType.ROOK, PieceColor.BLACK);
        Piece blackKnight1 = new Piece(27, PieceType.KNIGHT, PieceColor.BLACK);
        Piece blackKnight2 = new Piece(28, PieceType.KNIGHT, PieceColor.BLACK);
        Piece blackBishop1 = new Piece(29, PieceType.BISHOP, PieceColor.BLACK);
        Piece blackBishop2 = new Piece(30, PieceType.BISHOP, PieceColor.BLACK);
        Piece blackQueen = new Piece(31, PieceType.QUEEN, PieceColor.BLACK);
        Piece blackKing = new Piece(32, PieceType.KING, PieceColor.BLACK);

        pieceArray[0][0] = blackRook1;
        pieceArray[0][1] = blackKnight1;
        pieceArray[0][2] = blackBishop1;
        pieceArray[0][3] = blackQueen;
        pieceArray[0][4] = blackKing;
        pieceArray[0][5] = blackBishop2;
        pieceArray[0][6] = blackKnight2;
        pieceArray[0][7] = blackRook2;
        pieceArray[1][0] = blackPawn1;
        pieceArray[1][1] = blackPawn2;
        pieceArray[1][2] = blackPawn3;
        pieceArray[1][3] = blackPawn4;
        pieceArray[1][4] = blackPawn5;
        pieceArray[1][5] = blackPawn6;
        pieceArray[1][6] = blackPawn7;
        pieceArray[1][7] = blackPawn8;
        pieceArray[6][0] = whitePawn1;
        pieceArray[6][1] = whitePawn2;
        pieceArray[6][2] = whitePawn3;
        pieceArray[6][3] = whitePawn4;
        pieceArray[6][4] = whitePawn5;
        pieceArray[6][5] = whitePawn6;
        pieceArray[6][6] = whitePawn7;
        pieceArray[6][7] = whitePawn8;
        pieceArray[7][0] = whiteRook1;
        pieceArray[7][1] = whiteKnight1;
        pieceArray[7][2] = whiteBishop1;
        pieceArray[7][3] = whiteQueen;
        pieceArray[7][4] = whiteKing;
        pieceArray[7][5] = whiteBishop2;
        pieceArray[7][6] = whiteKnight2;
        pieceArray[7][7] = whiteRook2;
    }
}
