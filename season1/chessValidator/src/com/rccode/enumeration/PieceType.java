package com.rccode.enumeration;

import com.rccode.constant.AppConstant;

import java.util.LinkedList;
import java.util.List;

public enum PieceType {
    PAWN {
        @Override
        public Character getPieceColorCode() {
            return 'P';
        }

        @Override
        public boolean isValidMove(int pos1, int pos2, PieceColor color, boolean oppositionAtToPosition) {
            int x1 = pos1 / AppConstant.DIMENSION;
            int y1 = pos1 % AppConstant.DIMENSION;
            int x2 = pos2 / AppConstant.DIMENSION;
            int y2 = pos2 % AppConstant.DIMENSION;
            boolean firstMove = false;
            if ((PieceColor.WHITE.equals(color) && x1 == 1) || (PieceColor.BLACK.equals(color) && x1 == AppConstant.DIMENSION - 2)) {
                firstMove = true;
            }

            int deltaX = (x2 - x1);

            if (deltaX == 0) {
                return false;
            }

            int deltaY = Math.abs(y2 - y1);

            if ( (deltaX > 0 && !PieceColor.WHITE.equals(color)) || (deltaX < 0 && !PieceColor.BLACK.equals(color))) {
                return false;
            }
            deltaX = Math.abs(x2 - x1);
            if (deltaX > 2) {
                return false;
            } else if (deltaX == 2 && !firstMove) {
                return false;
            } else if (deltaX == 2 && deltaY != 0) {
                return false;
            }

            if (deltaY > 1) {
                return false;
            } else if (deltaY == 1 && !oppositionAtToPosition) {
                return false;
            }

            return true;
        }
    },
    KNIGHT {
        @Override
        public Character getPieceColorCode() {
            return 'N';
        }

        @Override
        public boolean isValidMove(int pos1, int pos2) {
            int x1 = pos1 / AppConstant.DIMENSION;
            int y1 = pos1 % AppConstant.DIMENSION;
            int x2 = pos2 / AppConstant.DIMENSION;
            int y2 = pos2 % AppConstant.DIMENSION;

            int deltaX = Math.abs(x2 - x1);
            int deltaY = Math.abs(y2 - y1);

            if ((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)) {
                return true;
            }
            return false;
        }
    },
    ROOK {
        @Override
        public Character getPieceColorCode() {
            return 'R';
        }

        @Override
        public boolean isValidMove(int pos1, int pos2) {
            int x1 = pos1 / AppConstant.DIMENSION;
            int y1 = pos1 % AppConstant.DIMENSION;
            int x2 = pos2 / AppConstant.DIMENSION;
            int y2 = pos2 % AppConstant.DIMENSION;

            int deltaX = Math.abs(x2 - x1);
            int deltaY = Math.abs(y2 - y1);

            if (deltaX == 0 || deltaY == 0) {
                return true;
            }
            return false;
        }

        @Override
        public List<Integer> getIntermediatePositions(int pos1, int pos2) {
            List<Integer> positions = new LinkedList<>();
            int x1 = pos1 / AppConstant.DIMENSION;
            int y1 = pos1 % AppConstant.DIMENSION;
            int x2 = pos2 / AppConstant.DIMENSION;
            int y2 = pos2 % AppConstant.DIMENSION;

            int deltaX = Math.abs(x2 - x1);
            int deltaY = Math.abs(y2 - y1);

            if (deltaX == 0) {
                int min = Math.min(y1, y2) + 1;
                int max = Math.max(y1, y2) - 1;
                for (int i = min; i <= max; i++ ) {
                    positions.add(x1 * AppConstant.DIMENSION + i);
                }
            } else if (deltaY == 0) {
                int min = Math.min(x1, x2) + 1;
                int max = Math.max(x1, x2) - 1;
                for (int i = min; i <= max; i++ ) {
                    positions.add(i * AppConstant.DIMENSION + y1);
                }
            }
            return positions;
        }
    },
    BISHOP {
        @Override
        public Character getPieceColorCode() {
            return 'B';
        }

        @Override
        public boolean isValidMove(int pos1, int pos2) {
            int x1 = pos1 / AppConstant.DIMENSION;
            int y1 = pos1 % AppConstant.DIMENSION;
            int x2 = pos2 / AppConstant.DIMENSION;
            int y2 = pos2 % AppConstant.DIMENSION;

            int deltaX = Math.abs(x2 - x1);
            int deltaY = Math.abs(y2 - y1);

            if (deltaX == deltaY) {
                return true;
            }
            return false;
        }

        @Override
        public List<Integer> getIntermediatePositions(int pos1, int pos2) {
            List<Integer> positions = new LinkedList<>();
            int x1 = pos1 / AppConstant.DIMENSION;
            int y1 = pos1 % AppConstant.DIMENSION;
            int x2 = pos2 / AppConstant.DIMENSION;
            int y2 = pos2 % AppConstant.DIMENSION;

            int deltaX = (x2 - x1);
            int deltaY = (y2 - y1);
            int direction = deltaX * deltaY;

            if (direction > 0) {
                int minX = Math.min(x1, x2) + 1;
                int minY = Math.min(y1, y2) + 1;
                int maxX = Math.max(x1, x2) - 1;
                int maxY = Math.max(y1, y2) - 1;
                for (int i = minX, j = minY; i <= maxX && j <= maxY; i++, j++) {
                    positions.add(i * AppConstant.DIMENSION + j);
                }
            } else {
                int minX = Math.min(x1, x2) + 1;
                int minY = Math.min(y1, y2) + 1;
                int maxX = Math.max(x1, x2) - 1;
                int maxY = Math.max(y1, y2) - 1;
                for (int i = minX, j = maxY; i <= maxX && j >= minY; i++, j--) {
                    positions.add(i * AppConstant.DIMENSION + j);
                }
            }
            return positions;
        }
    },
    QUEEN {
        @Override
        public Character getPieceColorCode() {
            return 'Q';
        }

        @Override
        public boolean isValidMove(int pos1, int pos2) {
            int x1 = pos1 / AppConstant.DIMENSION;
            int y1 = pos1 % AppConstant.DIMENSION;
            int x2 = pos2 / AppConstant.DIMENSION;
            int y2 = pos2 % AppConstant.DIMENSION;

            int deltaX = Math.abs(x2 - x1);
            int deltaY = Math.abs(y2 - y1);

            if (deltaX == deltaY || deltaX == 0 || deltaY == 0) {
                return true;
            }
            return false;
        }

        @Override
        public List<Integer> getIntermediatePositions(int pos1, int pos2) {
            List<Integer> positions = new LinkedList<>();
            int x1 = pos1 / AppConstant.DIMENSION;
            int y1 = pos1 % AppConstant.DIMENSION;
            int x2 = pos2 / AppConstant.DIMENSION;
            int y2 = pos2 % AppConstant.DIMENSION;

            int deltaX = (x2 - x1);
            int deltaY = (y2 - y1);
            int direction = deltaX * deltaY;

            if (deltaX == 0) {
                int min = Math.min(y1, y2) + 1;
                int max = Math.max(y1, y2) - 1;
                for (int i = min; i <= max; i++ ) {
                    positions.add(x1 * AppConstant.DIMENSION + i);
                }
            } else if (deltaY == 0) {
                int min = Math.min(x1, x2) + 1;
                int max = Math.max(x1, x2) - 1;
                for (int i = min; i <= max; i++ ) {
                    positions.add(i * AppConstant.DIMENSION + y1);
                }
            } else {
                if (direction > 0) {
                    int minX = Math.min(x1, x2) + 1;
                    int minY = Math.min(y1, y2) + 1;
                    int maxX = Math.max(x1, x2) - 1;
                    int maxY = Math.max(y1, y2) - 1;
                    for (int i = minX, j = minY; i <= maxX && j <= maxY; i++, j++) {
                        positions.add(i * AppConstant.DIMENSION + j);
                    }
                } else {
                    int minX = Math.min(x1, x2) + 1;
                    int minY = Math.min(y1, y2) + 1;
                    int maxX = Math.max(x1, x2) - 1;
                    int maxY = Math.max(y1, y2) - 1;
                    for (int i = minX, j = maxY; i <= maxX && j >= minY; i++, j--) {
                        positions.add(i * AppConstant.DIMENSION + j);
                    }
                }
            }

            return positions;
        }
    },
    KING {
        @Override
        public Character getPieceColorCode() {
            return 'K';
        }

        @Override
        public boolean isValidMove(int pos1, int pos2) {
            int x1 = pos1 / AppConstant.DIMENSION;
            int y1 = pos1 % AppConstant.DIMENSION;
            int x2 = pos2 / AppConstant.DIMENSION;
            int y2 = pos2 % AppConstant.DIMENSION;

            int deltaX = Math.abs(x2 - x1);
            int deltaY = Math.abs(y2 - y1);

            if (deltaX == deltaY && deltaX == 1 ) {
                return true;
            }

            if ( (deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 0)) {
                return true;
            }
            return false;
        }
    };

    public boolean isValidMove(int pos1, int pos2) {
        return false;
    }

    public boolean isValidMove(int pos1, int pos2, PieceColor color, boolean oppositionAtToPosition) {
        return false;
    }

    public List<Integer> getIntermediatePositions(int pos1, int pos2) {
        List<Integer> positions = new LinkedList<>();
        return positions;
    }

    public Character getPieceColorCode() {
        return null;
    }
}
