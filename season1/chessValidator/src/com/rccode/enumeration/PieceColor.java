package com.rccode.enumeration;

public enum PieceColor {
    BLACK {
        @Override
        public Character getPieceColorCode() {
            return 'B';
        }
    },
    WHITE {
        public Character getPieceColorCode() {
            return 'W';
        }
    };

    public Character getPieceColorCode() {
        return null;
    }
}
