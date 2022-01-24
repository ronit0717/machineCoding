package com.rccode.service;

import com.rccode.model.Board;
import com.rccode.model.Player;

public interface BoardService {
    void printBoard(Board board);
    int getBoardIndexFromStr(String str);
    boolean isValidMove(Board board, Player player, int from, int to);
    void move(Board board, Player player, int from, int to);
}
