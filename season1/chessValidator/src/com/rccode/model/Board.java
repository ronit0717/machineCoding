package com.rccode.model;

import com.rccode.constant.AppConstant;
import com.rccode.service.PieceDecodeService;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cells;

    public Board(PieceDecodeService pieceDecodeService) {
        this.cells = new ArrayList<>(AppConstant.cellCount);
        this.cells.add(new Cell(0, new Piece("WR", pieceDecodeService)));
        this.cells.add(new Cell(1, new Piece("WN", pieceDecodeService)));
        this.cells.add(new Cell(2, new Piece("WB", pieceDecodeService)));
        this.cells.add(new Cell(3, new Piece("WQ", pieceDecodeService)));
        this.cells.add(new Cell(4, new Piece("WK", pieceDecodeService)));
        this.cells.add(new Cell(5, new Piece("WB", pieceDecodeService)));
        this.cells.add(new Cell(6, new Piece("WN", pieceDecodeService)));
        this.cells.add(new Cell(7, new Piece("WR", pieceDecodeService)));
        this.cells.add(new Cell(8, new Piece("WP", pieceDecodeService)));
        this.cells.add(new Cell(9, new Piece("WP", pieceDecodeService)));
        this.cells.add(new Cell(10, new Piece("WP", pieceDecodeService)));
        this.cells.add(new Cell(11, new Piece("WP", pieceDecodeService)));
        this.cells.add(new Cell(12, new Piece("WP", pieceDecodeService)));
        this.cells.add(new Cell(13, new Piece("WP", pieceDecodeService)));
        this.cells.add(new Cell(14, new Piece("WP", pieceDecodeService)));
        this.cells.add(new Cell(15, new Piece("WP", pieceDecodeService)));
        for (int i = 16; i < 48; i++) {
            this.cells.add(new Cell(i));
        }
        this.cells.add(new Cell(48, new Piece("BP", pieceDecodeService)));
        this.cells.add(new Cell(49, new Piece("BP", pieceDecodeService)));
        this.cells.add(new Cell(50, new Piece("BP", pieceDecodeService)));
        this.cells.add(new Cell(51, new Piece("BP", pieceDecodeService)));
        this.cells.add(new Cell(52, new Piece("BP", pieceDecodeService)));
        this.cells.add(new Cell(53, new Piece("BP", pieceDecodeService)));
        this.cells.add(new Cell(54, new Piece("BP", pieceDecodeService)));
        this.cells.add(new Cell(55, new Piece("BP", pieceDecodeService)));
        this.cells.add(new Cell(56, new Piece("BR", pieceDecodeService)));
        this.cells.add(new Cell(57, new Piece("BN", pieceDecodeService)));
        this.cells.add(new Cell(58, new Piece("BB", pieceDecodeService)));
        this.cells.add(new Cell(59, new Piece("BQ", pieceDecodeService)));
        this.cells.add(new Cell(60, new Piece("BK", pieceDecodeService)));
        this.cells.add(new Cell(61, new Piece("BB", pieceDecodeService)));
        this.cells.add(new Cell(62, new Piece("BN", pieceDecodeService)));
        this.cells.add(new Cell(63, new Piece("BR", pieceDecodeService)));
    }

    public List<Cell> getCells() {
        return cells;
    }
}
