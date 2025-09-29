package main;

import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPieces(Piece piece, Coordinates coordinates) {
        piece.coordinates = coordinates; // Обновление координат фигуры при расположении на доске
        pieces.put(coordinates, piece);
    }

    public void setupDefaultPiecesPositions() {

    }
}
