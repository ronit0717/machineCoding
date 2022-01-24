package com.rccode.service.impl;

import com.rccode.constant.AppConstant;
import com.rccode.enumeration.PieceType;
import com.rccode.exception.ProcessException;
import com.rccode.model.Board;
import com.rccode.model.Piece;
import com.rccode.model.Player;
import com.rccode.service.BoardService;
import com.rccode.service.PieceDecodeService;

import java.util.List;

public class BoardServiceImpl implements BoardService {

    private PieceDecodeService pieceDecodeService;

    public BoardServiceImpl() {
        this.pieceDecodeService = new PieceDecodeServiceImpl();
    }

    @Override
    public void printBoard(Board board) {
        for (int i = AppConstant.DIMENSION - 1; i >= 0; i--) {
            for (int j = 0; j < AppConstant.DIMENSION; j++) {
                int index = i * AppConstant.DIMENSION + j;
                System.out.print(pieceDecodeService.getPieceStringFromPiece(board.getCells().get(index).getPiece()) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public int getBoardIndexFromStr(String str) {
        int y = str.charAt(0) - 'a';
        int x = str.charAt(1) - '1';
        if (x < 0 || x >= AppConstant.DIMENSION || y < 0 || y >= AppConstant.DIMENSION) {
            throw new ProcessException("getBoardIndexFromStr", "Invalid position");
        }
        return x * AppConstant.DIMENSION + y;
    }

    @Override
    public boolean isValidMove(Board board, Player player, int from, int to) {
        Piece fromPiece = board.getCells().get(from).getPiece();
        Piece toPiece = board.getCells().get(to).getPiece();
        if (toPiece != null) {
            if (fromPiece.getPieceColor().equals(toPiece.getPieceColor())) {
                return false;
            }
        }
        boolean oppostionInToPosition = toPiece != null;
        boolean valid = PieceType.PAWN.equals(fromPiece.getPieceType()) ?
                fromPiece.getPieceType().isValidMove(from, to, fromPiece.getPieceColor(), oppostionInToPosition) : fromPiece.getPieceType().isValidMove(from, to);
        if (!valid) {
            return false;
        }
        if (hasIntermediatePieces(board, fromPiece, from, to)) {
            return false;
        }
        return true;
    }

    private boolean hasIntermediatePieces(Board board, Piece piece, int from, int to) {
        List<Integer> intermediatePositions = piece.getPieceType().getIntermediatePositions(from, to);
        for (Integer posIndex : intermediatePositions) {
            if (board.getCells().get(posIndex).getPiece() != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(Board board, Player player, int from, int to) {
        if (!isValidMove(board, player, from, to)) {
            throw new ProcessException("Make Move", "Invalid Move");
        }
        Piece piece = board.getCells().get(from).getPiece();
        board.getCells().get(from).setPiece(null);
        board.getCells().get(to).setPiece(piece);
    }
}
