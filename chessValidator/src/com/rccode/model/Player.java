package com.rccode.model;

import com.rccode.enumeration.PieceColor;

public class Player {
    private String id;
    private PieceColor color;

    public Player(String id, PieceColor color) {
        this.id = id;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public PieceColor getColor() {
        return color;
    }
}
