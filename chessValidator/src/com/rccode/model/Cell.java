package com.rccode.model;

public class Cell {
    private int index;
    private Piece piece;

    public Cell(int index) {
        this.index = index;
        this.piece = null;
    }

    public Cell(int index, Piece piece) {
        this.index = index;
        this.piece = piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getIndex() {
        return index;
    }

    public Piece getPiece() {
        return piece;
    }
}
