package model;

import enums.PieceColor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    int id;
    String name;
    PieceColor color;
}
